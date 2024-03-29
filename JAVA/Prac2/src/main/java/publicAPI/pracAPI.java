package publicAPI;

import org.json.JSONTokener;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class pracAPI {
	public static void main(String[] args) throws IOException, ParseException {
		StringBuilder urlBuilder = new StringBuilder("http://api.odcloud.kr/api/15077586/v1/centers"); /*URL*/

		urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=YRkBWQZx3aRQLHb0r%2FsplLRqGDjcHP5uBmuSttKbnzcJS4KYDMKEAUIZ9LKomlPSq%2B15lfre7b0SQqF7veL7Mg%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("page","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 수*/
		urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지당 표출 데이터 수*/


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

		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();

		org.json.JSONTokener tokener = new JSONTokener(sb.toString());
		org.json.JSONObject jsonString = new org.json.JSONObject(tokener);
		System.out.println(jsonString.toString(2));
		org.json.JSONArray arr = jsonString.getJSONArray("data");

		for(Object one : arr){
			org.json.JSONObject ob = (org.json.JSONObject)one;
			System.out.print(ob.get("id") + "\t");
			System.out.print(ob.get("facilityName") + "\t");
			System.out.print(ob.get("address") + "\t");
			System.out.print(ob.get("org") + "\t");
			System.out.print(ob.get("createdAt") + "\t");
			System.out.println(ob.get("phoneNumber"));
		}


//		JSONParser jsonParser = new JSONParser();
//		JSONObject jsonObject = (JSONObject)jsonParser.parse(jsonString.toString());
//		JSONObject response = (JSONObject) jsonObject.get("response");
//		JSONObject body = (JSONObject) response.get("body");
//		JSONObject items = (JSONObject) body.get("items");
//		JSONArray item = (JSONArray) items.get("item");
//
//		System.out.println(item);
//
//		for(Object one : item){
//			JSONObject ob = (JSONObject) one;
//			System.out.println(ob.get("ptntAge"));
//		}
	}
}
