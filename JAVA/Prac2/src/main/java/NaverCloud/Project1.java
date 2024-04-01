package NaverCloud;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) throws IOException, ParseException {

		Scanner scanner = new Scanner(System.in);
		System.out.print("주소를 입력: ");
		String address = scanner.nextLine();
		scanner.close();

		StringBuilder urlBuilder = new StringBuilder("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="); /*URL*/
		urlBuilder.append(URLEncoder.encode(address,"UTF-8")); /*주소를 url인코딩하여 붙임*/

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "pil5kbxktj");
		conn.setRequestProperty("X-NCP-APIGW-API-KEY", "2sESkRyLgSoUfPVWo86pwkhgjjHcGvfpvAj1bXEN");
		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader br;
		if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		} else {
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}

		String result = br.readLine();

		br.close();
		conn.disconnect();

		JSONParser jsonParser = new JSONParser();
		org.json.JSONObject jOb = new org.json.JSONObject(result);
		System.out.println(jOb.toString(2));
		JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
		JSONArray jsonArr = (JSONArray)jsonObject.get("addresses");
		String x = "";
		String y = "";
		String z = "";

		for(Object o : jsonArr){
			JSONObject ob = (JSONObject) o;
			System.out.println("address : " + ob.get("roadAddress"));
			z = ob.get("roadAddress").toString();
			System.out.println("jibunAddress : " + ob.get("jibunAddress"));
			System.out.println("경도 : " + ob.get("x"));
			x = ob.get("x").toString();
			System.out.println("위도 : " + ob.get("y"));
			y = ob.get("y").toString();
		}
		mapService(x, y, z);

	}

	private static void mapService(String x, String y, String address) throws IOException, ParseException {
		String mapUrl = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";

		String pos  = URLEncoder.encode(x + " " + y, "UTF-8");

		mapUrl += "center="+x+","+y;
		mapUrl += "&level=16&w=500&h=700";
		mapUrl += "&markers=type:t|size:mid|pos:" + pos + "|label:" + URLEncoder.encode(address, "UTF-8");

		URL url = new URL(mapUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "pil5kbxktj");
		conn.setRequestProperty("X-NCP-APIGW-API-KEY", "2sESkRyLgSoUfPVWo86pwkhgjjHcGvfpvAj1bXEN");

		System.out.println("Response code: " + conn.getResponseCode());
		int responseCode = conn.getResponseCode();
		BufferedReader br;
		if(responseCode == 200){
			InputStream is = conn.getInputStream();
			int read = 0;
			byte[] bytes = new byte[1024];
			String tempname = Long.valueOf(new Date().getTime()).toString();
			File f = new File(tempname + ".jpg");
			f.createNewFile();
			OutputStream outputStream = new FileOutputStream(f);
			while ((read=is.read(bytes))!= -1){
				outputStream.write(bytes,0,read);
			}
			outputStream.close();
			is.close();
		} else{
			br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while((inputLine = br.readLine()) != null){
				response.append(inputLine);
			}
			br.close();
			System.out.println(response);
		}
		conn.disconnect();
	}

}
