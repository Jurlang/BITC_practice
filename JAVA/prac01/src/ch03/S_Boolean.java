package ch03;
/*
class : S_Boolean
    - Method : main
        . 수업 3장 기초 자료형 ( boolean ) - 코드 작성 및 실행 연습
 */
public class S_Boolean {
    public static void main(String[] args) {

        int base = 180;
        int height = 185;

        boolean isTall = height > base;

        if(isTall){
            System.out.println("키가 큽니다.");
        }
        else{
            System.out.println("키가 작습니다.");
        }

        int i = 3;
        boolean isOdd = i%2==1;
        System.out.println(isOdd);
    }
}
