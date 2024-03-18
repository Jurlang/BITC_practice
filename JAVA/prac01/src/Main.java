/*
Class : Main
    - Method : Main
        . 프로그램이 시작되는 함수.
        . 기본적 선언 및 초기화를 한다.
 */
public class Main {
    public static void main(String[] args) {

        //자바는 메인 메소드에서 시작된다.
        System.out.println("hello world");

        // 변수 선언 및 초기화
        int a = 1;
        char b = 'c';
        String c = "abc";
        long longNumber = 1000000000;
        long moreInt = 3000000000L;
        float f = 3.14f;
        double d = 3.14;

        // 변수 확인용 출력
        System.out.println("int a : " + a + " / char b : " + b + " / String c : " + c );
        System.out.println("longNumber : " + longNumber);
        System.out.println("moreInt : " + moreInt);
        System.out.println("f : " + f);
        System.out.println("d : " + d);
    }
}
