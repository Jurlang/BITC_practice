package ch03;

/*
class : S_Number
    - Method : main
        . 수업 3장 기초 자료형 ( 숫자 ) - 코드 작성 및 실행 연습
 */

public class S_Number {
    public static void main(String[] args) {

        // 변수 선언 및 초기화
        int a = 11;
        int b = 5;

        // 변수 값 확인용 출력
        System.out.println("10진수 a= 11      : " + a);
        System.out.println("10진수 b= 5       : " + b);
        System.out.println("덧셈      a + b : " + (a + b));
        System.out.println("뺄셈      a - b : " + (a - b));
        System.out.println("곱셈      a * b : " + (a * b));
        System.out.println("나눔      a / b : " + (a / b));
        System.out.println("남음      a % b : " + (a % b));

    }
}