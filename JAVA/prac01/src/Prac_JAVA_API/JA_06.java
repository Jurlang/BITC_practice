package Prac_JAVA_API;

import java.util.TreeSet;

/*
Tree set 예제
 */
public class JA_06 {
	public static void main(String[] args) {
		TreeSet<String> names = new TreeSet<>();

		names.add("Daniel");
		names.add("Brian");
		names.add("Eugene");
		names.add("Adam");
		names.add("Cate");

		System.out.println("names.size()	-> " + names.size());
		System.out.println("names.first()	-> " + names.first());
		System.out.println("names.last()	-> " + names.last());

		System.out.println("== for each 구문 출력 ==");
		for(String str : names)
			System.out.println(str);

	}
}