package Prac_Class;
/*
* 다이어그램을 보고 클래스 만들어
* 그 클래스를 toString()로 출력하기
*/
public class C_02 {
	public static void main(String[] args) {
		Food chicken = new Food("치킨", 18000);
		Food pizza = new Food("피자", 28000);
		Food sushi = new Food("초밥세트", 22000);

		Food[] foods = {chicken, pizza, sushi};

		for(int i = 0 ; i < foods.length ; i++){
			System.out.println(foods[i].toString());
		}
	}
}

class Food{
	String name;
	int price;

	Food(String name, int price){
		this.name = name;
		this.price = price;
	}
	public String toString(){
		return "Food{ name : " + name + ", price : " + price + " 원 }";
	}
}