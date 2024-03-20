package ch04_Control;
/*
 * Class - C_for
 * 	- Method : main
 * 		= Ch 04. 제어문 ( for ) - 수업 내용 및 코드 소스
 */
public class C_for {
	public static void main(String[] args) {
		String[] numbers = {"one", "two", "three", "four"};
		for(int i = 0; i < numbers.length; i++){
			System.out.println(numbers[i]);
		}
		System.out.println();
		int[] marks = {90, 25, 67, 45, 80};
		for(int i = 0; i < marks.length ; i++){
			if(marks[i] >= 60) System.out.println((i+1) + "번 학생은 합격입니다.");
			else System.out.println((i+1) + "번 학생은 불합격입니다.");
		}
		System.out.println();
		int[] marks2 = {90, 25, 67, 45, 80};
		for(int i = 0; i < marks2.length ; i++){
			if(marks2[i] < 60) continue;
			System.out.println((i+1) + "번 학생은 합격입니다.");
		}
		System.out.println();

		for(int i = 2; i < 10; i++){
			System.out.printf("2단 : ");
			for(int j = 1; j < 10; j++){
				System.out.printf("X %d = %d / ", j , i*j);
			}
			System.out.println();
		}
	}
}
