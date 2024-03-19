package ch03_dataType;

/*
class : S_Array
    - Method : main
        . 수업 3장 기초 자료형 ( Array ) - 코드 작성 및 실행 연습
*/

public class S_Array {
	public static void main(String[] args) {
		String[] weeks = {"월", "화", "수", "목", "금", "토", "일"};

		System.out.println("----------인덱스를 이용한 배열 값 접근(0부터 시작)");
		System.out.println("weeks[3] = " + weeks[3]);
		System.out.println();

		System.out.println("----------반복문을 이용한 배열 값 얻기");
		for(int i = 0 ; i < weeks.length ; i++ ){
			System.out.printf("weeks[%d] = %s\n", i, weeks[i]);
		}

	}
}
