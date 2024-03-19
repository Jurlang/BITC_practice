package ch03_dataType;

/*
class : S_StringBuffer
    - Method : main
        . 수업 3장 기초 자료형 ( StringBuffer ) - 코드 작성 및 실행 연습
        . 사용한 함수 : append(string) , toString() , insert(n,string) , substring(n,m)
*/

public class S_StringBuffer {
	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer();
		sb.append("hello");
		sb.append(" ");
		sb.append("jump to java");

		String s = "";
		s += "hello";
		s += " ";
		s += "jump to java";

		System.out.println("---------SB 객체 생성(new) 후 삽입(append) 및 string(+=)으로 만들기");
		System.out.println("StringBuffer sb : " + sb);
		System.out.println("String s : " + s);
		System.out.println();

		System.out.println("---------insert(n , string) - n번째 string 삽입");
		sb.insert(5, " hello");
		System.out.println("StringBuffer sb : " + sb);
		System.out.println();

		System.out.println("---------substring(n, m) - n 부터 m 전까지 출력");
		System.out.println("sb.substring(2,6) : " + sb.substring(2,7));
	}
}
