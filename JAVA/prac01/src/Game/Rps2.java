package Game;

import java.util.Arrays;
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
public class Rps2 {
	public static void main(String[] args) {
		GameObject[] go = {new Scissors("가위"), new Rock("바위"), new Paper("보자기")};
		Scanner in = new Scanner(System.in);

		String[] gResult = {"_", "_", "_"};

		boolean _continue = true;

		while (_continue) {
			int score = 0;
			for (int i = 1; i < 4; i++) {
				System.out.println("--------------------------------------------");
				System.out.printf("%d 번째 게임을 시작하지. 현재 결과 : %s %s %s\n", i, gResult[0], gResult[1], gResult[2]);
				System.out.print("가위 ( 1 ), 바위 ( 2 ), 보 ( 3 ) 선택 하여라. ");
				int user = in.nextInt();
				int com = (int) (Math.random() * 3) + 1;

				if (user < 0 || user > 3) {
					System.out.println("1 , 2 , 3 중에만 선택하여라");
					i -= 1;
					continue;
				}
				System.out.println("--------------------------------------------");
				System.out.println("User : " + go[user - 1].name + " // " + "Com : " + go[com - 1].name);
				if (go[user - 1].compareTo(go[com - 1]) == 1) gResult[i - 1] = "승";
				else if (go[user - 1].compareTo(go[com - 1]) == 0) gResult[i - 1] = "무";
				else if (go[user - 1].compareTo(go[com - 1]) == -1) gResult[i - 1] = "패";
				score += go[user - 1].compareTo(go[com - 1]);

				if(score == 2 || score == -2 && i < 3){
					System.out.println("--------------------------------------------");
					System.out.println("허허허허허 결판이 난 것 같구나 !");
					break;
				}

			}
			System.out.println("--------------------------------------------");
			System.out.printf("현재 결과 : %s %s %s\n", gResult[0], gResult[1], gResult[2]);
			if (score > 0) System.out.println("너의 승리다.");
			else if (score < 0) System.out.println("너의 패배다.");
			else System.out.println("호호호 무승부구나 다음 승부를 기약하지.");
			System.out.println("--------------------------------------------");

			boolean chk_continue = true;
			while (chk_continue) {
				System.out.print("한 번 더 하겠다. ( 1 )\n");
				System.out.print("아니 그만 하겠다. ( 2 )\n");
				System.out.print("너의 선택은 ? ");
				int chk = in.nextInt();
				if (chk == 1) {
					chk_continue = false;
					Arrays.fill(gResult, "_");
//					for (int i = 0; i < gResult.length; i++) {
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
		in.close();
	}
}

class GameObject {
	String name;

	public GameObject(String name) {
		this.name = name;
	}

	public int compareTo(GameObject g) {
		return 0;
	}
}

class Rock extends GameObject {
	public Rock(String name) {
		super(name);
	}

	@Override
	public int compareTo(GameObject g) {
		if (g.getClass() == Scissors.class) return 1;
		else if (g.getClass() == Paper.class) return -1;
		else return 0;
	}
}

class Scissors extends GameObject {
	public Scissors(String name) {
		super(name);
	}

	@Override
	public int compareTo(GameObject g) {
		if (g.getClass() == Paper.class) return 1;
		else if (g.getClass() == Rock.class) return -1;
		else return 0;
	}
}

class Paper extends GameObject {
	public Paper(String name) {
		super(name);
	}

	@Override
	public int compareTo(GameObject g) {
		if (g.getClass() == Rock.class) return 1;
		else if (g.getClass() == Scissors.class) return -1;
		else return 0;
	}
}