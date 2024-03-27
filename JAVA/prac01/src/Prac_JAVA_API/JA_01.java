package Prac_JAVA_API;

import java.util.ArrayList;

/*
치킨 값 계산
 */
public class JA_01 {
	public static void main(String[] args) {
		ArrayList<Menu> chicken = new ArrayList<>();
		chicken.add(new Menu("후라이드 치킨", 9900));
		chicken.add(new Menu("로스트 치킨", 9900));
		chicken.add(new Menu("양념 치킨", 10900));
		chicken.add(new Menu("간장 치킨", 10900));
		chicken.add(new Menu("파닭 치킨", 12900));
		chicken.add(new Menu("마늘아 치킨", 13900));

		int allPrice_for = 0;
		for( int i = 0 ; i < chicken.size() ; i++){
			allPrice_for += chicken.get(i).getPrice();
		}

		int allPrice_foreach = 0;
		for( Menu menu : chicken)
			allPrice_foreach += menu.getPrice();

		System.out.println("allPrice_for 총합 : 		" + allPrice_for + " 원");
		System.out.println("allPrice_foreach 총합 : 	" + allPrice_foreach + " 원");
	}
}

class Menu{
	private String menu;
	private int price;

	public Menu(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}