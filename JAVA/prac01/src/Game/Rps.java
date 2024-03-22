package Game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/*
가위 바위 보 게임
규칙
	3번 연속 게임
	3승 - 승 3
	2번 승 - 승 2, 1
	1번 승 2번 무 - 1 0
	1번 승 1번 패 1무 - 무
	3무 - 무
	나머지 - 패
 */
public class Rps {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<Integer, String> gObject = new HashMap<>();
		gObject.put(1, "Rock");
		gObject.put(2, "Scissors");
		gObject.put(3, "Paper");

		String[] gResult = { "_", "_", "_" };

		boolean _continue = true;

		while (_continue) {
			int score = 0;
			for (int i = 1; i < 4; i++) {
				System.out.printf("%d 번째 게임을 시작하지. 현재 결과 : %s %s %s\n",i, gResult[0], gResult[1], gResult[2]);
				System.out.print("바위 ( 1 ), 가위 ( 2 ), 보 ( 3 ) 선택 하여라. ");
				int user = in.nextInt();
				int com = (int) (Math.random() * 3) + 1;

				if(user < 0 || user > 3){
					System.out.println("1 , 2 , 3 중에만 선택하여라");
					i -= 1;
					continue;
				}

				System.out.println("User : " + gObject.get(user) + " // " + "Com : " + gObject.get(com));

				if (user == 1) {
					if (com == 1) {
						System.out.println(" 무승부 : 승점 +0점");
						gResult[i-1] = "무";
					} else if (com == 2) {
						System.out.println(" 승리 : 승점 +1점");
						gResult[i-1] = "승";
						score += 1;
					} else {
						System.out.println(" 패배 : 승점 -1점");
						gResult[i-1] = "패";
						score -= 1;
					}
				} else if (user == 2) {
					if (com == 1) {
						System.out.println(" 패배 : 승점 -1점");
						gResult[i-1] = "패";
						score -= 1;
					} else if (com == 2) {
						System.out.println(" 무승부 : 승점 +0점");
						gResult[i-1] = "무";
					} else {
						System.out.println(" 승리 : 승점 +1점");
						gResult[i-1] = "승";
						score += 1;
					}
				} else if (user == 3){
					if (com == 1) {
						System.out.println(" 승리 : 승점 +1점");
						gResult[i-1] = "승";
						score += 1;
					} else if (com == 2) {
						System.out.println(" 패배 : 승점 -1점");
						gResult[i-1] = "패";
						score -= 1;
					} else {
						System.out.println(" 무승부 : 승점 +0점");
						gResult[i-1] = "무";
					}
				}
			}
			System.out.println();
			System.out.printf("현재 결과 : %s %s %s\n", gResult[0], gResult[1], gResult[2]);
			if (score > 0) System.out.println("너의 승리다.");
			else if (score < 0) System.out.println("너의 패배다.");
			else System.out.println("호호호 무승부구나 다음 승부를 기약하지.");

			boolean chk_continue = true;
			while(chk_continue) {
				System.out.print("한 번 더 하겠다. ( 1 )\n");
				System.out.print("아니 그만 하겠다. ( 2 )\n");
				System.out.print("너의 선택은 ?");
				int chk = in.nextInt();
				if (chk == 1) {
					chk_continue = false;
					Arrays.fill(gResult, "_");
//					for(int i = 0; i<gResult.length;i++){
//						gResult[i] = "_";
//					}
				} else if (chk == 2) {
					_continue = false;
					chk_continue = false;
				} else {
					System.out.println(" 1 과 2 중에만 적거라.");
				}
			}
		}
	}
}
