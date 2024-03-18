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
        int c = 023;        // 8진수
        int d = 0xc3;       // 16진수

        // 변수 값 확인용 출력
        System.out.println("10진수 a  10      : " + a);
        System.out.println("10진수 b  5       : " + b);
        System.out.println("8진수  c  023     : " + c);
        System.out.println("16진수 d  0xc3    : " + d);
        System.out.println("a + b : " + (a + b));
        System.out.println("a - b : " + (a - b));
        System.out.println("a * b : " + (a * b));
        System.out.println("a / b : " + (a / b));
        System.out.println("a % b : " + (a % b));

    }
}