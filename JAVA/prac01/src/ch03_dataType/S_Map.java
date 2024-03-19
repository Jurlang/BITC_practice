package ch03_dataType;

import java.util.HashMap;

/*
class : S_Map
    - Method : main
        . 수업 3장 기초 자료형 ( Map ) - 코드 작성 및 실행 연습
        . put ( key, value ), get( key ), containsKey(key), containsValue(value)
        . remove( key ), size(), keySet(), values()
*/

public class S_Map {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("people", "여러 사람");
		map.put("person", "한 사람");
		map.put("male", "남성");
		map.put("female", "여성");

		System.out.println();
		System.out.println("map.put( key, value ) 로 데이터 추가");
		System.out.println("map : " + map);
		System.out.println();
		System.out.println("map.get(person) : "+ map.get("person"));
		System.out.println("map.containsKey(person) : " + map.containsKey("person"));
		System.out.println("map.containsValue(남성) : " + map.containsValue("남성"));
		System.out.println("map.remove(person) : " + map.remove("person"));
		System.out.println("remove 후 map : " + map);
		System.out.println("map.size() : " + map.size());
		System.out.println("map.keySet() : " + map.keySet());
		System.out.println("map.values() : " + map.values());
	}
}
