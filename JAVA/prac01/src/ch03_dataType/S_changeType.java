package ch03_dataType;


/*
class : S_changeType
    - Method : main
        . 수업 3장 기초 자료형 ( 형변환 ) - 코드 작성 및 실행 연습
        . final - Data 변경 불가.

*/
public class S_changeType {
	public static void main(String[] args) {
		System.out.println("문자열(정수) -> 숫자 ( 정수, 실수 )");

		String num = "123";
		System.out.println("String num + 100 : " + (num + 100));
		int n = Integer.parseInt(num);
		System.out.println("n = Integer.parseInt(num) + 100 : " + (n+100));
		double d = Double.parseDouble(num);
		System.out.println("d = Double.parseDouble(num) + 0.23 : " + (d+0.23));
		float f = Float.parseFloat((num));
		System.out.println("f = Float.parseFloat((num) + 0.23 : " + (f+0.23));
		System.out.println();

		System.out.println("숫자 -> 문자열");
		n = 123;
		num = "" + n;
		System.out.println("num = \"\" + n ↓");
		System.out.println("String num + 100 : " + (num+100));
		d = 123.123;
		num = "" + d;
		System.out.println("num = \"\" + d ↓");
		System.out.println("String num + 100 : " + (num+100));
		num = String.valueOf(n);
		System.out.println("String.valueOf(n) : " + (num+100));
		System.out.println("Integer.toString(n) : "+ (num+100));
		System.out.println();

		System.out.println("문자열(실수) -> 숫자 (정수)");
		num = "123.123";
		System.out.println("String num + 100 : " + (num+100));
//		n = Integer.parseInt(num);
		System.out.println("n = Integer.parseInt(num) 은 NumberFormatException 에러");
		d = Double.parseDouble(num);
		System.out.println("d = Double.parseDouble(num) 후에");
		n = (int)d;
		System.out.println("n = (int)d 해줘야함.");
		System.out.println("n : " + n);
	}
}
