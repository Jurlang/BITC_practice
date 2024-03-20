package Prac_Array_Loop;
/*
서울 : 599
부산 : 51
인천 : 46
대전 : 43
대구 : 27
배열로 만들기
*/
public class AL_02 {
	public static void main(String[] args) {
		String[] cities = {"서울", "부산", "인천", "대전", "대구"};
		int[] visitors = {599, 51, 46, 43, 27};
		
		for(int i = 0; i< cities.length; i++){
			System.out.println(cities[i] + " : " + visitors[i] + " 명");
		}
	}
}
