package ch07_JavaMoreSkill;

public class Singleton_Sample {
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		singleton1.setTest("test1");
		singleton2.setTest("test2");
		System.out.println("singleton1.getTest : " + singleton1.getTest());
		System.out.println("singleton2.getTest : " + singleton2.getTest());
		System.out.println("singleton1 == singleton2 : "+ (singleton1 == singleton2));
	}
}