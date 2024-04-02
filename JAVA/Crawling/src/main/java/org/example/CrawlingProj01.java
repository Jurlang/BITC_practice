package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

// 네이버 뉴스 크롤링
public class CrawlingProj01 {
	public static void main(String[] args) {
		String url = "https://sports.naver.com/wfootball/index";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get(); // 페이지 문서 자체를 얻음
		} catch (IOException e) {
			System.err.println("입출력 예외 에러 발생 !");
		}
		if(doc != null) {
			Elements es = doc.select("div.home_news");
			System.out.println(es);
			String title = es.select("h2").text();
			System.out.println("--------------------------------------------------------------------");
			System.out.println(title);
			System.out.println("--------------------------------------------------------------------");

			for(Element li : es.select("li")){
				System.out.println(li.text());
			}
		}

	}
}
