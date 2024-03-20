package Prac_Array_Loop;

import java.util.Scanner;

/*
* Factorial 할 수를 입력받아
* 그 수에 맞는 Factorial 출력
*/
public class AL_06 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();

		printFactorial(x);
	}

	public static void printFactorial(int x){
		int mul = 1;
		System.out.printf("%d! = ", x);
		for( int i = x; i > 0 ; i--){
			if( i != 1) System.out.printf("%d x ",i);
			else System.out.printf("%d = ", i);
			mul = mul * i;
		}
		System.out.printf("%d", mul);
	}
}
