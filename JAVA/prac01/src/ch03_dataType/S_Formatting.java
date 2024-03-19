package ch03_dataType;

/*
class : S_InnerMethod
    - Method : main
        . 수업 3장 문자열 포매팅 - 코드 작성 및 실행 연습
 */

public class S_Formatting {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("------------ %d - 정수");
        System.out.println(String.format("자리 지정 x - I eat %d apples.", 10));
        System.out.println(String.format("자리 지정 o - I eat %06d apples.", 10));

        System.out.println();
        System.out.println("------------ %f - 부동 소수");
        System.out.println(String.format("자리 지정 x - rate is %f%%.", 3.234));
        System.out.println(String.format("자리 지정 o - rate is %010.4f%%.", 3.234));

        System.out.println();
        System.out.println("------------ %c - 문자");
        System.out.println(String.format("자리 지정 x - 나는 오늘 '%10c'을 배웠어", 'ㄱ'));
        System.out.println(String.format("자리 지정 o - 나는 오늘 '%10c'을 배웠어 ( %%10c - 앞에 띄우고 붙임 )", 'ㄱ'));
        System.out.println(String.format("자리 지정 o - 나는 오늘 '%-10c'을 배웠어 ( %%-10c - 붙이고 띄움 )", 'ㄱ'));

        System.out.println();
        System.out.println("------------ %s - 문자열");
        System.out.println(String.format("자리 지정 x - 나는 오늘 \"%s\"를 배웠어", "낫 놓고 ㄱ 자도 모른다."));
        System.out.println(String.format("자리 지정 o - 나는 오늘 \"%15s\"를 배웠어 ( %%15s - 앞에 띄우고 붙임 )", "낫 놓고 ㄱ 자도 모른다."));
        System.out.println(String.format("자리 지정 o - 나는 오늘 \"%-15s\"를 배웠어 ( %%-15s - 붙이고 띄움 )", "낫 놓고 ㄱ 자도 모른다."));

        System.out.println();
        System.out.println("------------ formatting 2개 사용");
        System.out.println(String.format("나는 사과 %d개를 먹을 동안 너는 \"%s\"를 쓰거라.", 10, "배움에는 끝이 없다."));

        System.out.println();
        System.out.println("------------ String.format 없이 바로 출력 printf");
        System.out.printf("이것은 String.format 없이 바로 출력 %d\n", 500);
    }
}
