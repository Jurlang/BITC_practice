package Prac_Array_Loop;

import java.util.Scanner;

/*
영어의 모음이 A E I O U 라 가정했을 때,
문자열의 자음과 모음의 개수를 배열로 반환하는 count() 메소드.
소문자 모음과 특수문자를 추가 인식하도록 count() 메소드 수정
*/
public class AL_04 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();

		int[] result = count(s);

		System.out.printf("%s\n=> 자음 %d 개 , 모음 %d 개", s, result[0], result[1]);
	}

	public static int[] count(String str) {
		int conso = 0;
		int vowel = 0;

		char[] characters = str.toCharArray();

		for (int i = 0; i < characters.length; i++) {
			switch (characters[i]) {
				case 'A':
				case 'a':
				case 'E':
				case 'e':
				case 'I':
				case 'i':
				case 'O':
				case 'o':
				case 'U':
				case 'u':
					vowel++;
					break;
				case ' ':
				case '\t':
				case '\n':
				case ',':
				case '.':
				case '?':
				case '!':
					break;
				default:
					conso++;
					break;
			}
		}
		return new int[]{conso, vowel};
	}
}
