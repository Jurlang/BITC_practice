package Homework_API;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class WindSpeed {
	private JSONArray item;

	public WindSpeed() throws IOException {
		StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6260000/BusanWindInfoService/getWindInfo"); /*URL*/

		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
							  + "=YRkBWQZx3aRQLHb0r%2FsplLRqGDjcHP5uBmuSttKbnzcJS4KYDMKEAUIZ9LKomlPSq%2B15lfre7b0SQqF7veL7Mg%3D%3D"); /*Service Key*/
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 수*/
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("20", "UTF-8")); /*한 페이지당 표출 데이터 수*/
		urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); // json 으로 출력

		URL url = new URL(urlBuilder.toString());

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;

		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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

		JSONTokener tokener = new JSONTokener(sb.toString());
		JSONObject jsonString = new JSONObject(tokener);
		JSONObject all = (JSONObject) jsonString.get("getWindInfo");
		JSONObject body = (JSONObject) all.get("body");
		JSONObject items = (JSONObject) body.get("items");
		this.item = (JSONArray) items.get("item");
	}

	int getSize(){
		return item.length();
	}
	void getArea(){
		for(int i = 1 ; i < item.length() ; i++){
			JSONObject ob = (JSONObject)item.get(i-1);
			System.out.print((i) + "\t" + printString(ob, "siteName"));
			if(i % 4 == 0)
				System.out.println();
		}
	}
	void getItem(int idx) {
		JSONObject ob = (JSONObject) item.get(idx-1);
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("측정 시간\t\t" + printString(ob,"obsrDt"));
		System.out.println("지역명\t\t\t" + printString(ob, "siteName"));
		System.out.println("1m당 풍속\t\t" + printString(ob, "windSpeed1m"));
		System.out.println("1m당 풍향\t\t" + printString(ob, "windDirection1m")
										  + getDerectionNm(ob, "windDirection1m"));
		System.out.println("돌풍 풍속\t\t" + printString(ob, "windSpeedGust"));
		System.out.println("돌풍 풍향\t\t" + printString(ob, "windDirectionGust")
										  + getDerectionNm(ob, "windDirectionGust"));
		System.out.println("상태\t\t\t\t" + printString(ob, "sttusNm"));
		System.out.println("---------------------------------------------------------------------------------");
	}
	String printString(JSONObject ob, String str) {
		String name = ob.get(str).toString();
		int length = name.replace(" ", "").length();
		if (str.equals("siteName")) {
			if (length <= 4) {
				return name + "\t\t\t";
			} else if (length <= 6) {
				return name + "\t\t";
			} else {
				return name + "\t";
			}
		} else {
			if (length < 4) {
				return name + "\t\t\t";
			} else {
				return name + "\t\t";
			}
		}
	}
	String getDerectionNm(JSONObject ob, String str){
		String direction = ob.get(str).toString();
		double _direction = Double.parseDouble(direction);
		if(360 >= _direction && _direction >= 337.5 || _direction >=0 && _direction < 22.5) return "북\t풍";
		else if(_direction >= 22.5 && _direction < 67.5) return "북동\t풍";
		else if(_direction >= 67.5 && _direction < 112.5) return "동\t풍";
		else if(_direction >= 112.5 && _direction < 157.5) return "남동\t풍";
		else if(_direction >= 157.5 && _direction < 202.5) return "남\t풍";
		else if(_direction >= 202.5 && _direction < 247.5) return "남서\t풍";
		else if(_direction >= 247.5 && _direction < 292.5) return "서\t풍";
		else if(_direction >= 292.5 && _direction < 337.5) return "북서\t풍";
		else return "측량 에러";
	}
}
