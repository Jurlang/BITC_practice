package swingGui;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class NaverMap {
	static String clientId = "pil5kbxktj";
	static String clientKey = "2sESkRyLgSoUfPVWo86pwkhgjjHcGvfpvAj1bXEN";

	MainFrame mainFrame;

	public NaverMap(MainFrame mainFrame) throws IOException, ParseException {
		this.mainFrame = mainFrame;

		String address = mainFrame.address.getText();

		StringBuilder urlBuilder = new StringBuilder("https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="); /*URL*/
		urlBuilder.append(URLEncoder.encode(address,"UTF-8")); /*주소를 url인코딩하여 붙임*/

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
		conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientKey);
		System.out.println("Address Data : Response code: " + conn.getResponseCode());

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
		JSONObject jsonObject = (JSONObject)jsonParser.parse(result);
		JSONArray jsonArr = (JSONArray)jsonObject.get("addresses");

		for(Object o : jsonArr){
			JSONObject ob = (JSONObject) o;
			System.out.println("address : " + ob.get("roadAddress"));
			System.out.println("jibunAddress : " + ob.get("jibunAddress"));
			System.out.println("경도 : " + ob.get("x"));
			System.out.println("위도 : " + ob.get("y"));

			AddressVO vo = new AddressVO(
					ob.get("roadAddress").toString(),
					ob.get("jibunAddress").toString(),
					ob.get("x").toString(),
					ob.get("y").toString()
			);
			System.out.println(vo.toString());
			mapService(vo);
		}
	}

	private void mapService(AddressVO vo) throws IOException, ParseException {
		String mapUrl = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";

		String pos  = URLEncoder.encode(vo.getX() + " " + vo.getY(), "UTF-8");

		mapUrl += "center="+vo.getX()+","+vo.getY();
		mapUrl += "&level=16&w=700&h=500";
		mapUrl += "&markers=type:t|size:mid|pos:" + pos + "|label:" + URLEncoder.encode(vo.getRoadAddress(), "UTF-8");

		URL url = new URL(mapUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "pil5kbxktj");
		conn.setRequestProperty("X-NCP-APIGW-API-KEY", "2sESkRyLgSoUfPVWo86pwkhgjjHcGvfpvAj1bXEN");

		System.out.println("Address Image : Response code: " + conn.getResponseCode());
		int responseCode = conn.getResponseCode();
		BufferedReader br;
		if(responseCode == 200){
			InputStream is = conn.getInputStream();
			Image image = ImageIO.read(is);
			is.close();
			ImageIcon imageIcon = new ImageIcon(image);
			mainFrame.imageLabel.setIcon(imageIcon);
			mainFrame.resAddress.setText(vo.getRoadAddress());
			mainFrame.jibunAddress.setText(vo.getJibunAddress());
			mainFrame.resX.setText(vo.getX());
			mainFrame.resY.setText(vo.getY());
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
