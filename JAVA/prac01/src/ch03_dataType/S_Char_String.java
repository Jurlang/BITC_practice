package ch03_dataType;

/*
class : S_Char_String
    - Method : main
        . 수업 3장 기초 자료형 ( Char ) - 코드 작성 및 실행 연습
        . 수업 3장 기초 자료형 ( String ) - 코드 작성 및 실행 연습
 */

public class S_Char_String {
    public static void main(String[] args) {
        
        // 문자 Char 코드
        char a1 = 'a';              // 일반문자
        char a2 = 97;               // 아스키코드
        char a3 = '\u0061';         // 유니코드

        System.out.println("char    a1      " + a1);
        System.out.println("char    a2      " + a2);
        System.out.println("char    a3      " + a3);

        // 문자열 String 리터럴 선언 코드
        String s1 = "Unhappy Java";
        String s2 = "a";
        String s3 = "123";

        System.out.println("String  s1      " + s1);
        System.out.println("String  s2      " + s2);
        System.out.println("String  s3      " + s3);

        // 문자열 String 객체 생성 코드
        String cs1 = new String("Unhappy Java");
        String cs2 = new String("a");
        String cs3 = new String("123");

        System.out.println("String  cs1     " + cs1);
        System.out.println("String  cs2     " + cs2);
        System.out.println("String  cs3     " + cs3);
    }
}
