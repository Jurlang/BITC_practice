package ch03_dataType;


/*
class : S_Enum
    - Method : main
        . 수업 3장 기초 자료형 ( Enum ) - 코드 작성 및 실행 연습

*/
public class S_Enum {
	enum CoffeeType{
		Americano,
		Ice_Americano,
		Cafe_Latte
	}
	public static void main(String[] args) {
		System.out.println(CoffeeType.Americano);
		System.out.println(CoffeeType.Ice_Americano);
		System.out.println(CoffeeType.Cafe_Latte);
	}
}
