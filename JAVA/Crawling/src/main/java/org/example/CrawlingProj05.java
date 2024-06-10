package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class CrawlingProj05 {
	public static void main(String[] args) {
		String url = "https://www.lottegiantsshop.com/shop/shopbrand.html?xcode=003&type=M&mcode=002";

		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			System.out.println("에러 발생 !!");
		}
		if (doc != null) {
			Elements CardItem = doc.select("div.txt>a");
			Elements Price = doc.select("div.price");
			Elements CardContents = doc.select("div.text");
			Elements img = doc.select("img.MS_prod_img_s");

			System.out.println(img);
			System.out.println("---------------------------------------------------------------------------------");

			Iterator<Element> name = CardItem.iterator();
			Iterator<Element> price = Price.iterator();
			while (name.hasNext()) {
				System.out.println(name.next().text());
				System.out.println(price.next().text().replace(",", ""));
			}
			System.out.println("---------------------------------------------------------------------------------");
		}
	}
}
