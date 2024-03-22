package Prac_Extends_Interface;
/*
상속을 통해 중복된 코드를 없애라.
- 다양한 음료
 */
public class EI_01 {
	public static void main(String[] args) {
		Juice j = new Juice();
		Coffee c = new Coffee();
		Beer b = new Beer();
		Water w = new Water();
		Tea t = new Tea();

		Drink[] drinks = {j,c,b,w,t};

		for( Drink d : drinks ){
			d.ordered();
		}
	}
}

class Drink{
	String name;
	String price;
	public void ordered(){
		System.out.println("주문되었습니다.");
	}
}
class Juice extends Drink{}
class Coffee extends Drink{}
class Beer extends Drink{}
class Water extends Drink{}
class Tea extends Drink{}
