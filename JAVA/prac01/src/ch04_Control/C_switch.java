package ch04_Control;

import java.util.Scanner;

/*
 * Class - C_switch
 * 	- Method : main
 * 		= Ch 04. 제어문 ( switch ) - 수업 내용 및 코드 소스
 */
public class C_switch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int month = in.nextInt();
		String monthString = "";
		switch (month){
			case 1:
				monthString = "1월달";
				break;
			case 2:
				monthString = "2월달";
				break;
			case 3:
				monthString = "3월달";
				break;
			case 4:
				monthString = "4월달";
				break;
			case 5:
				monthString = "5월달";
				break;
			case 6:
				monthString = "6월달";
				break;
			case 7:
				monthString = "7월달";
				break;
			case 8:
				monthString = "8월달";
				break;
			case 9:
				monthString = "9월달";
				break;
			case 10:
				monthString = "10월달";
				break;
			case 11:
				monthString = "11월달";
				break;
			case 12:
				monthString = "12월달";
				break;
			default:
				monthString = "1~12까지만 입력해주세요.";
				break;
		}
		System.out.println(monthString);
	}
}
