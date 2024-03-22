package ch05_object;

import org.w3c.dom.ls.LSOutput;

/*
Class : O_Extends
	- Method : main
		= Ch 05. 객체 지향 프로그래밍 ( Extends )
		= Ch 05. 객체 지향 프로그래밍 ( Constructor )
 */
public class O_Extends {
	public static void main(String[] args) {
		Animal2 cat = new Animal2();
		Dog dog = new Dog();
		Animal2 test = new Dog();
//		Dog test2 = new Animal2();  - 컴파일 에러 ( 자식 클래스로 부모 클래스 객체 안됨 )
		test.setName("테스트");
		test.sleep();
//		test.sleep(dog);	- 컴파일 에러 ( 부모가 자식 것 못씀 )
		cat.setName("야옹야옹");
		dog.setName("뽀삐뽀삐");
		System.out.println(dog.name);
		cat.sleep();
		dog.sleep();
		dog.sleep(cat);
	}
}

class Animal2{
	String name;
	Animal2(){
		name = "";
	}
	Animal2(String name){
		this.name = name;
	}

	void setName(String name){
		this.name = name;
	}
	void sleep(){
		System.out.println(name + "이 잠에 얕게 빠져버린다.");
	}
}

class Dog extends Animal2{
	Dog(){
		name = "";
	}
	Dog(String name){
		this.name = name;
		System.out.println("생성자 오버로딩");
	}
	void sleep(){
		System.out.println(name + " 이 잠에 깊게 빠져버린다.");
		System.out.println("이것이 메소드 오버라이딩");
	}
	void sleep(Animal2 animal){
		System.out.println(animal.name + "과 "+ name + "이 잠에 빠져버려따");
		System.out.println("이것이 메소드 오버로딩");
	}
	void test(){
		System.out.println("test");
	}
}

class Cat extends Animal2{
	int weight;

	public Cat(int weight) {
		this.weight = weight;
	}

	public Cat(String name, int weight) {
		super(name);
		this.weight = weight;
	}
}