package Prac_Extends_Interface;
/*
코드를 분석 및 수정하여 출력과 같은 예를 얻자.
- 자동차와 트럭
 */
public class EI_02 {
	public static void main(String[] args) {
		Car c = new Car("티코");
		Car t = new Truck("봉고", 1.5);

		System.out.println(c.toString());
		System.out.println(t.toString());
	}
}

class Car{
	protected String name;
	public Car(String name){
		this.name = name;
	}
	public String toString(){
		return String.format("[자동차] { name : %s }", name);
	}
}

class Truck extends Car{
	protected double ton;

	public Truck(String name, double ton){
		super(name);
		this.ton = ton;
	}

	public String toString(){
		return String.format("[트럭] { name : %s, ton : %.1f }", name, ton);
	}
}
