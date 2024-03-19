package ch03_dataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class S_Generics {
	public static void main(String[] args) {
		ArrayList<String> as = new ArrayList<>();
		as.add("138");
		as.add("129");
		as.add("142");

		System.out.println("sort 전 : " + as);
		as.sort(Comparator.naturalOrder());
		System.out.println("naturalOrder sort 후 : " + as);
		as.sort(Comparator.reverseOrder());
		System.out.println("reverseOrder sort 후 : " + as);
		System.out.println();

		ArrayList<String> as2 = new ArrayList<>(Arrays.asList("123", "234", "345"));
		System.out.println("Arrays.asList 이용하여 as2 만들기 : " + as2);
		String result = String.join(" : ", as2);
		System.out.println("String.join(\" : \", as2) - result = " + result);
		System.out.println();

		ArrayList<Integer> ai = new ArrayList<>();
		ai.add(123);
		ai.add(234);
		ai.add(345);
		System.out.println("정수형 arraylist : " + ai);
	}
}
