package ch05_object;
/*
Class : O_MethodEx
	- Method : sum ( int , int )
		= 매개변수 int 2개를 받아 더함
	- Method : main
		= Ch 05. 객체 지향 프로그래밍 ( Method )
 */
public class O_MethodEX {
	public static void main(String[] args) {
		int a = 3;
		int b = 4;

		O_MethodEX me = new O_MethodEX();
		System.out.println("int a = " + a + " // int b : " + b);
		System.out.println("me.sum(a, b)	: " + me.sum(a, b));
		System.out.println("me.sum(10,23) 	: " + me.sum(10, 23));
		me.noReturn();
		System.out.println(me.myName("현이"));
	}

	int sum(int a, int b){
		return a + b;
	}

	void noReturn(){
		System.out.println("입력도 없고~ 리턴도 없고~");
	}

	String myName(String name){
		return "내 이름은 " + name + " 입니다.";
	}
}
