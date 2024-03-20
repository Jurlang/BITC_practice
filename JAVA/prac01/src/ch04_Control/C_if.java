package ch04_Control;

import java.util.ArrayList;
import java.util.Arrays;

/*
* Class - C_if
* 	- Method : main
* 		= Ch 04. 제어문 ( IF ) - 수업 내용 및 코드 소스
*/
public class C_if {
	public static void main(String[] args) {
		//돈이 3000 이상이면 택시타고가라 없으면 걸어가라
		int money1 = 2000;
		System.out.println("---------- 1    ");
		if(money1 >= 3000) System.out.println("택시를 타고 가라");
		else System.out.println("걸어가라");

		//돈이 3000 이상이거나 카드가 있다면 택시타고가라 없으면 걸어가라
		int money2 = 2000;
		boolean hasCard = true;
		System.out.println("---------- 2    ");
		if(money2 >= 3000 || hasCard) System.out.println("택시를 타고 가라");
		else System.out.println("걸어가라");

		//contains 이용하여 조건제어문(if) 활용해보기
		ArrayList<String> pocket = new ArrayList<>();
		pocket.addAll(Arrays.asList("paper", "cellphone", "money"));
		System.out.println("---------- 3    ");
		System.out.println("pocket : " + pocket);
		if(pocket.contains("money"))
			System.out.println("택시 타셈");
		else
			System.out.println("걸어가셈");
	}
}
