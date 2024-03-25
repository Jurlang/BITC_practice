package ch05_object;
/*
Class : O_Interface
	- Method : main
		= Ch 05. 객체 지향 프로그래밍 ( Interface )
 */
public class O_Interface {
	public static void main(String[] args) {
		// Interface Ex
		Tiger tiger = new Tiger("어흥이");
		Lion lion = new Lion("크앙이");
		System.out.println(tiger.name + " getFood : " + tiger.getFood());
		System.out.println(lion.name + " getFood : " + lion.getFood());
		tiger.printFood();
		lion.printFood();
		Predator.printBall();


		// 다형성 Ex
		// 		- 부모(클래스,인터페이스,추상클래스) 클래스로 여러가지 클래스를 가질 수 있다.
		Object[] objArr = {new Person(), new Computer()};
		// 	> Object Class is a parent of All Class
		Describable[] objs = { new Person(), new Computer() };
		for(Object obj : objArr){
			System.out.println(obj);
		}
		for(Describable obj : objs){
			System.out.println(obj.getDescription());
		}
		
		// 추상 클래스
		//		- 인터페이스( 추상메소드 ) + 클래스( 변수 메소드 )
		GameObject[] gObjs = { new Player(), new Monster() };
		for(GameObject obj : gObjs){
			System.out.println(obj.getClass());
			obj.describe();
		}
	}
}
// 인터페이스 예제
interface Predator{
	String getFood();

	default void printFood(){
		System.out.println("this is my Food : MEAT");
	}
	static void printBall(){
		System.out.println("야이 볼");
	}
}
class Interface_Animal{
	String name;

	public Interface_Animal(String name) {
		this.name = name;
	}
}
class Tiger extends Interface_Animal implements Predator{
	public Tiger(String name) {
		super(name);
	}

	@Override
	public String getFood() {
		return "apple";
	}
}
class Lion extends Interface_Animal implements Predator{
	public Lion(String name) {
		super(name);
	}

	@Override
	public String getFood() {
		return "banana";
	}
}

// 다형성 예제
interface Describable{
	String getDescription();
}
class Person implements Describable{
	@Override
	public String getDescription() {
		return "I am Person Class";
	}

	@Override
	public String toString() {
		return "Person";
	}
}
class Computer implements Describable{
	@Override
	public String toString() {
		return "Computer";
	}

	@Override
	public String getDescription() {
		return "I am Computer Class";
	}
}

// 추상클래스 예제
abstract class GameObject{
	String name;
	void game(){
		System.out.println("게임을 시작하지");
	}
	abstract void describe();
}
class Player extends GameObject{
	@Override
	void describe() {
		System.out.println("I am Player !");
	}
}
class Monster extends GameObject{
	@Override
	void describe() {
		System.out.println("I am Monster !");
	}
}