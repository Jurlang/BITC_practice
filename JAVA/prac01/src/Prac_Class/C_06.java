package Prac_Class;
/*
주어진 코드로 중국집 주문 메뉴의 총합을 구한다.
*/
public class C_06 {
	public static void main(String[] args) {
		Menu jjajang = new Menu("짜장", 4900);
		Menu jjambbong = new Menu("짬뽕", 5900);
		Menu tangsook = new Menu("탕수육", 13900);

		Menu[] menuArr = {jjajang, jjambbong, tangsook};
		Order order = new Order(123, menuArr);

		System.out.printf("주문합계 : %d 원\n", order.totalPrice());
	}
}

class Order{
	int orderNum;
	Menu[] menus;

	Order(int i , Menu[] arr){
		orderNum = i;
		menus = arr;
	}

	public int totalPrice(){
		int totalPrice = 0;
		for(int i = 0; i<menus.length; i++){
			totalPrice += menus[i].price;
		}
		return totalPrice;
	}
}

class Menu{
	String name;
	int price;

	Menu(String name, int price){
		this.name = name;
		this.price = price;
	}

}