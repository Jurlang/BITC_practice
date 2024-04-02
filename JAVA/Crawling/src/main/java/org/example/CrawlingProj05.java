package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class CrawlingProj05 {
	public static void main(String[] args) {
		String url = "https://www.inflearn.com/courses/it-programming";

		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			System.out.println("에러 발생 !!");
		}
		if(doc != null){
			Elements CardItem = doc.select("a.course_card_front");
			Elements CardContents = doc.select("div.card-content");

			System.out.println(CardItem);
			Iterator<Element> aLink = CardItem.iterator();

			Iterator<Element> title = CardContents.select("div.course_title").iterator();
			Iterator<Element> price = CardContents.select("div.price").iterator();
			while(title.hasNext()){
				System.out.println("---------------------------------------------------------------------------------");
				System.out.println("강의 제목\t" + title.next().text());

				String[] realPrice = price.next().text().split(" ");
				if(realPrice.length > 1) System.out.println("강의 가격\t" + realPrice[1].substring(1)+"원");
				else System.out.println("강의 가격\t" + realPrice[0].substring(1)+"원");

				String[] realLink = aLink.next().attr("abs:href").split("\\?");
				System.out.println("강의 링크\t" + realLink[0]);
//				System.out.println("강의 링크\t" + "https://www.inflearn.com" + );
			}
			System.out.println("---------------------------------------------------------------------------------");
		}
	}
}
