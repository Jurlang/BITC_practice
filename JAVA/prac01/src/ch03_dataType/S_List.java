package ch03_dataType;

import java.util.ArrayList;
/*
class : S_List
    - Method : main
        . 수업 3장 기초 자료형 ( List ) - 코드 작성 및 실행 연습
        . add( value ) , get ( index ) , remove ( value or index )
        . size() , contains( value )
*/
public class S_List {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("138");
		al.add("129");
		al.add("142");

		System.out.println();
		System.out.println("al.add(\"138\"), al.add(\"129\"), al.add(\"142\")");
		System.out.println("al = [\"138\",\"129\",\"142\"]");
		System.out.println();
		System.out.println("al.get(1) 			: " + al.get(1));
		System.out.println("al.size() 			: " + al.size());
		System.out.println("al.contains(\"142\")	: " + al.contains("142"));
		System.out.println("al.contains(\"143\")	: " + al.contains("143"));
		System.out.println();
		al.remove("138");
		al.remove(0);
		System.out.println("al.remove(\"138\")");
		System.out.println("al = [\"129\",\"142\"]");
		System.out.println();
		System.out.println("al.remove(0)");
		System.out.println("al = [\"142\"]");
		System.out.println();
		System.out.println("al.size()				: " + al.size());
		System.out.println("al.get(0)				: " + al.get(0));
		System.out.println("al.get(0).getClass()	: " + al.get(0).getClass());
	}
}
