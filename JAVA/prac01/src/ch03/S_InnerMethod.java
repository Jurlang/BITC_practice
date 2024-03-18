package ch03;

/*
class : S_InnerMehtod
    - Method : main
        . 수업 3장 문자열 내장 함수 - 코드 작성 및 실행 연습
        . 사용한 함수 : equals , indexOf , contains , charAt
                      replaceAll , substring , toUpperCase , split
 */

public class S_InnerMethod {
    public static void main(String[] args) {

        // equals   문자열 비교 ( 같으냐 다르냐 )
        String s1 = "hello";
        String s2 = "java";
        String s3 = "hello";

        System.out.println("-------equals");
        System.out.println("s1.equals(s2)         " + s1.equals(s2));
        System.out.println("s1.equals(s3)         " + s1.equals(s3));
        System.out.println();

        //---------------------------------------------------------------------
        System.out.println("---------------------------------------------------------------------");
        String a = "Hello Java";
        System.out.println("String a              " + a);
        System.out.println();

        // indexOf  문자열에서 특정 문자 또는 문자열이 몇 번째부터 시작하는 지
        //          0 에서부터 시작
        System.out.println("-------indexOf");
        System.out.println("a.indexOf(\"Java\")     " + a.indexOf("Java"));
        System.out.println("a.indexOf(\"a\")        " + a.indexOf("a"));
        System.out.println();

        // contains 포함되어 있는지 아닌지
        System.out.println("-------contains");
        System.out.println("a.contains(\"Java\")    " + a.contains("Java"));
        System.out.println("a.contains(\"oJ\")      " + a.contains("oJ"));
        System.out.println("a.contains(\"o J\")     " + a.contains("o J"));
        System.out.println();

        // charAt   특정 위치의 문자를 리턴
        System.out.println("-------charAt");
        System.out.println("a.charAt(6)           " + a.charAt(6));
        System.out.println();

        // replaceAll   특정 문자열을 다른 문자열로 변경
        System.out.println("-------replaceAll ( Java -> World )");
        System.out.println("String a              " + a);
        System.out.println("a.replaceAll()        " + a.replaceAll("Java", "World"));
        System.out.println();

        // substring    문자열에서 특정 문자열 순서를 뽑아냄
        System.out.println("-------substring");
        System.out.println("a.substring(4)        " + a.substring(1));      // 1번부터 끝까지
        System.out.println("a.substring(0,4)      " + a.substring(0, 4));    // 0번부터 4번 전까지
        System.out.println("a.substring(6,9)      " + a.substring(6, 10));
        System.out.println();

        // toUpperCase(toLowerCase)    영어를 다 대문자(소문자)로
        System.out.println("-------toUpperCase(toLowerCase)");
        System.out.println("a.toUpperCase()       " + a.toUpperCase());
        System.out.println("a.toLowerCase()       " + a.toLowerCase());
        System.out.println();

        System.out.println("---------------------------------------------------------------------");
        String b = "a 1:b 30000:c:d";
        System.out.println("String b :            " + b);
        System.out.println();

        // split    특정한 구분자로 나누어(쪼개어) 배열로 리턴
        System.out.println("-------split");
        String[] result = b.split(":");
        System.out.println("b.split(\":\")        ");
        for (int i = 0; i < result.length; i++) {
            System.out.println("                i[" + i + "] : " + result[i]);
        }


    }
}
