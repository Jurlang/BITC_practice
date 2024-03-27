package ch07_JavaMoreSkill.JMS_Exception;

public class Try_Catch_Finally {
	public void shouldBeRun(){
		System.out.println("Ok, Thanks");
	}
	public static void main(String[] args) {
		Try_Catch_Finally sample = new Try_Catch_Finally();
		int c;
		try {
			c = 4 / 0;
		} catch (ArithmeticException e) {
			c = -1;
		} finally{
			sample.shouldBeRun();
		}
		System.out.println(c);
	}
}
