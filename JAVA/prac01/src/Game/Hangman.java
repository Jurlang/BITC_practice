package Game;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
행맨 게임 만들기.
 */
public class Hangman {

	public static void main(String[] args) throws IOException, InterruptedException {
		final String os = System.getProperty("os.name");
		Scanner in = new Scanner(System.in);

		System.out.print("관리자]제공될 시도 횟 수를 입력하시오 : ");
		int remainTries = in.nextInt();
		System.out.print("관리자]맞춰야할 단어를 입력하시오 : ");
		String correctWord = in.next();
		if(os.contains("Windows"))
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		else
			Runtime.getRuntime().exec("clear");

		char[] word = correctWord.toCharArray();
		char[] remainWord = new char[word.length];
		for( int i = 0; i < word.length ; i++){
			remainWord[i] = '_';
		}
		System.out.println("----------------------------");
		System.out.println("Start the Quiz");
		System.out.println("----------------------------");
		while(remainTries != 0 && !Arrays.equals(remainWord, word)){
			System.out.println("남은 기회 : " + remainTries);
			System.out.print("한 글자만 적으세요 : ");
			String answer = in.next();
			System.out.println();
			char[] answerArray = answer.toCharArray();

			if(answer.length() > 1){
				System.out.println("한 글자만 작성해주세요.");
				continue;
			}

			for(int i = 0; i< word.length; i++){
				if(answerArray[0] == word[i]){
					remainWord[i] = answerArray[0];
				}
				System.out.printf("%c ", remainWord[i]);
			}

			if(Arrays.equals(remainWord, word)){
				System.out.println("정답입니다.");
				in.close();
				return;
			}

			remainTries--;
			if(remainTries == 0){
				System.out.println("기회가 끝났습니다. 아쉽군요.");
				in.close();
				return;
			}
		}
	}
}
