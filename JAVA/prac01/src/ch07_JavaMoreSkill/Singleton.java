package ch07_JavaMoreSkill;

public class Singleton {
	private String test;
	private static Singleton one;
	private Singleton(){}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public static Singleton getInstance(){
		if ( one == null ) {
			one = new Singleton();
		}
		return one;
	}
}
