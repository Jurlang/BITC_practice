package Prac_JAVA_API;

import java.util.ArrayList;

/*
장바구니 총합
 */
public class JA_04 {
	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.add(new Item("스프라이트 셔츠", 49900));
		cart.add(new Item("슬림 면바지", 58900));
		cart.add(new Item("스니커즈", 46900));

		int price = cart.totalPrice();

		System.out.println("총합 : " + price + " 원");
	}
}
class Cart{
	private ArrayList<Item> list;

	public Cart() {
		this.list = new ArrayList<>();
	}

	public void add(Item item){
		list.add(item);
	}

	public int totalPrice(){
		int sum = 0 ;

		for(Item i : list)
			sum += i.getPrice();

		return sum;
	}
}

class Item{
	private String name;
	private int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}