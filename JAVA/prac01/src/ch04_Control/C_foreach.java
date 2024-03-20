package ch04_Control;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * Class - C_foreach
 * 	- Method : main
 * 		= Ch 04. 제어문 ( foreach ) - 수업 내용 및 코드 소스
 */
public class C_foreach {
	public static void main(String[] args) {
		ArrayList<String> numbers = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));

		for(String n : numbers){
			System.out.println("n : " + n);
		}
	}
}
