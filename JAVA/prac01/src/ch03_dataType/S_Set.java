package ch03_dataType;

import java.util.Arrays;
import java.util.HashSet;

/*
class : S_Set
    - Method : main
        . 수업 3장 기초 자료형 ( Set ) - 코드 작성 및 실행 연습
        . set1.retainAll( set2 ), set1.addAll( set2 ), set1.removeAll( set2 )
        . add( value ), remove( value )
*/
public class S_Set {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>(Arrays.asList("h","e","l","l","o"));
		System.out.println();
		System.out.println("set = new HashSet<>(Arrays.asList(\"h\",\"e\",\"l\",\"l\",\"o\"))");
		System.out.println("set : " + set);

		HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
		HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4,5,6,7,8,9));
		System.out.println();
		System.out.println("s1 : " + s1);
		System.out.println("s2 : " + s2);
		System.out.println();

		HashSet<Integer> intersection = new HashSet<>(s1);
		intersection.retainAll(s2);
		System.out.println("intersection <= s1");
		System.out.println("intersection.retainAll(s2) - intersection : " + intersection);
		System.out.println();
		HashSet<Integer> union = new HashSet<>(s1);
		union.addAll(s2);
		System.out.println("union <= s1");
		System.out.println("union.addAll(s2) - union : " + union);
		System.out.println();
		HashSet<Integer> subs = new HashSet<>(s1);
		subs.removeAll(s2);
		System.out.println("subs <= s1");
		System.out.println("subs.removeAll(s2) - subs : " + subs);
		System.out.println();

		s1.add(11);
		s1.add(12);
		System.out.println("s1.add(11) , s1.add(12)");
		System.out.println("s1 : " + s1);
		System.out.println();
		s1.addAll(Arrays.asList(13,14,15));
		System.out.println("s1.addAll(Arrays.asList(13,14,15))");
		System.out.println("s1 : " + s1);
		System.out.println();

		s1.remove(13);
		System.out.println("s1.remove(13)");
		System.out.println("s1 : " + s1);
		System.out.println();
		s1.removeAll(Arrays.asList(14,15));
		System.out.println("s1.removeAll(Arrays.asList(14,15))");
		System.out.println("s1 : " + s1);
	}
}
