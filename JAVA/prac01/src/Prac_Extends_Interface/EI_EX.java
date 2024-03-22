package Prac_Extends_Interface;

import java.util.ArrayList;

/*
*********인터페이스 예제
공통 인터페이스를 구현하는 서로 다른 객체
 */
public class EI_EX {
	public static void main(String[] args) {
		Sounding dog = new Dog();
		Sounding baby = new Baby();
		Sounding tiger = new Tiger();
		Sounding robot = new Robot();

		ArrayList<Sounding> list = new ArrayList<>();
		list.add(dog);
		list.add(baby);
		list.add(tiger);
		list.add(robot);

		for(int i = 0; i < list.size(); i++){
			list.get(i).sound();
		}

	}
}
interface Sounding{
	void sound();
}
class Dog implements Sounding{
	@Override
	public void sound() {
		System.out.println("Dog : 멍멍 !");
	}
}
class Baby implements Sounding{
	@Override
	public void sound() {
		System.out.println("Baby : 응애 !");
	}
}
class Tiger implements Sounding{
	@Override
	public void sound() {
		System.out.println("Tiger : 어흥 !");
	}
}
class Robot implements Sounding{
	@Override
	public void sound() {
		System.out.println("Robot : 삐빕 !");
	}
}