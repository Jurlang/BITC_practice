package publicAPI;

import org.json.XML;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonSimple {
	public static void main(String[] args) throws IOException, ParseException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1661000/EmergencyInformationService/getEmgPatientTransferInfo"); /*URL*/

		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=YRkBWQZx3aRQLHb0r%2FsplLRqGDjcHP5uBmuSttKbnzcJS4KYDMKEAUIZ9LKomlPSq%2B15lfre7b0SQqF7veL7Mg%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 수*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("2", "UTF-8")); /*한 페이지당 표출 데이터 수*/
		urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*결과형식(xml/json)*/
		urlBuilder.append("&" + URLEncoder.encode("sidoHqOgidNm","UTF-8") + "=" + URLEncoder.encode("충청남도소방본부", "UTF-8")); /*시도본부*/
		urlBuilder.append("&" + URLEncoder.encode("rsacGutFsttOgidNm","UTF-8") + "=" + URLEncoder.encode("공주소방서", "UTF-8")); /*출동소방서*/
		urlBuilder.append("&" + URLEncoder.encode("stmtYm","UTF-8") + "=" + URLEncoder.encode("202101", "UTF-8")); /*신고년월*/

		URL url = new URL(urlBuilder.toString());

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;

		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		ArrayList<String> sb = new ArrayList<>();

		String line;
		while ((line = rd.readLine()) != null) {
			sb.add(line);
		}

		rd.close();
		conn.disconnect();

		org.json.JSONObject jsonString = XML.toJSONObject(sb.toString());
		System.out.println(jsonString.toString(2));

		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonString.toString());
		JSONObject response = (JSONObject) jsonObject.get("response");
		JSONObject body = (JSONObject) response.get("body");
		JSONObject items = (JSONObject) body.get("items");
		JSONArray item = (JSONArray) items.get("item");

		System.out.println(item);

		for(Object one : item){
			JSONObject ob = (JSONObject) one;
			System.out.println(ob.get("ptntAge"));
		}

	}
}
