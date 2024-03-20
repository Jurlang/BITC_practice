package ch05_object;

/*
Class : O_objectEX
	- Method : main
		= Ch 05. 객체 지향 프로그래밍 ( 객체 예제 )
*/
public class O_objectEX {
	public static void main(String[] args) {
		Calculator cal1 = new Calculator();
		Calculator cal2 = new Calculator();

		System.out.println(cal1.add(3));
		System.out.println(cal1.add(4));

		System.out.println(cal2.add(3));
		System.out.println(cal2.add(7));
	}
}

/*
Class : Calculator
 	- Method : add ( int )
 		= 파라미터 값을 더해 필드 변수에 저장.
*/
class Calculator{
	int result = 0;

	int add(int num){
		result += num;
		return result;
	}
}