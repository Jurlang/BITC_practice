package org.example;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

// CGV 크롤링
public class CrawlingProj02 {
	public static void main(String[] args) {
		String url = "http://www.cgv.co.kr/movies/";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			System.err.println("입출력 예외 에러 발생 !!");
		}
		if(doc != null){
			Elements es = doc.select("div.sect-movie-chart");

			Iterator<Element> el1 = es.select("strong.rank").iterator();
			Iterator<Element> el2 = es.select("strong.title").iterator();

			while(el1.hasNext()){
				System.out.printf("%s\t",el1.next().text());
				System.out.println(el2.next().text());
			}
		}
	}
}
