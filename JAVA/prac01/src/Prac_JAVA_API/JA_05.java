package Prac_JAVA_API;

import java.util.ArrayList;

/*
하루 총 매출
 */
public class JA_05 {
	public static void main(String[] args) {
		Store store = new Store();
		store.add(new Menu_hong("김밥", 2000, 57));
		store.add(new Menu_hong("돈까스", 6000, 29));
		store.add(new Menu_hong("냉면", 5000, 34));

		System.out.println(store.totalSales());
	}
}

class Menu_hong{
	String name;
	int price;
	int count;

	public Menu_hong(String name, int price, int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public int getCount() {
		return count;
	}
}

class Store{
	private ArrayList<Menu_hong> list;

	public Store() {
		this.list = new ArrayList<>();
	}

	public void add(Menu_hong menu){
		list.add(menu);
	}

	public int totalSales(){
		int sum = 0;
		for(Menu_hong i : list)
			sum += i.getPrice() * i.getCount();
		return sum;
	}
}
