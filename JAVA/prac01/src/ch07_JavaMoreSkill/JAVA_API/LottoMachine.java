package ch07_JavaMoreSkill.JAVA_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LottoMachine {
	public static void main(String[] args) {
		// 45개의 공을 리스트로 만듬
		ArrayList<Integer> numbers = new ArrayList<>();
		for( int i = 1 ; i <= 45 ; i++){
			numbers.add(i);
		}
		Collections.shuffle(numbers);

		int[] picked = new int[6];

		for(int i = 0 ; i < 6 ; i++){
			picked[i] = numbers.get(i);
		}

		System.out.printf("자동 생성 번호 : %s", Arrays.toString(picked));
	}
}
