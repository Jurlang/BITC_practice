package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

// 네이버 주식
public class CrawlingProj03 {
	public static void main(String[] args) {
		String url = "https://finance.naver.com/item/main.nhn?code=009900";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			System.err.println("입출력 예외 발생 !!!");
		}
		if(doc != null) {
			Elements todayList = doc.select(".new_totalinfo dl>dd");

			String time = todayList.get(0).text();
			String name = todayList.get(1).text().substring(4);
			String[] price = todayList.get(3).text().split(" ");
			String yesterdayPrice = todayList.get(4).text().substring(4);
			String startPrice = todayList.get(5).text().substring(3);
			String highPrice = todayList.get(6).text().substring(3);
			String lowPrice = todayList.get(8).text().substring(3);

			System.out.println("기준 시간 : " + time);
			System.out.print("종목명\t\t현재가\t전일가\t시가\t\t고가\t\t저가\n");
			System.out.printf("%s\t\t%s\t%s\t%s\t%s\t%s\n", name, price[1], yesterdayPrice, startPrice,highPrice,lowPrice);

		}
	}
}
