package Prac_Array_Loop;

import java.util.Scanner;

/*
매달 0.231kg 씩 살이 찐다.
현재 체중 72.4kg 5개월 후의 몸무게

*/
public class AL_01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		double nowKg = in.nextDouble();
		int afterMonth = in.nextInt();

		double afterKg = weight(nowKg, afterMonth);

		System.out.printf("%d 개월 후 예상 몸무게 => %.2f kg", afterMonth, afterKg);
	}

	public static double weight(double nowKg, int afterMonth){
		for( int i = 1; i <= afterMonth; i++){
			nowKg = nowKg + 0.231;
		}
		return nowKg;
	}
}
