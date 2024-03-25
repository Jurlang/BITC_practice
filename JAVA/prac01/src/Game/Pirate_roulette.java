package Game;

import java.util.ArrayList;
import java.util.Scanner;

/*
해적룰렛 게임 만들기
1. 유저를 등록한다.
2. 해적 룰렛 통의 사이즈를 정한다.
3. 유저가 돌아가면서 칼을 넣는다.
4. 터지는 번호에 칼을 넣으면 터진다.

필요한 데이터
	통 크기
	통 정답 번호
	유저 이름
	유저 제시 번호
	유저가 제시한 번호들 기록
 */
public class Pirate_roulette {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("함께할 인원 수 : ");
		int userCount = in.nextInt();
		ArrayList<User> users = new ArrayList<>();

		for(int i = 0 ; i < userCount; i++){
			System.out.print("유저 이름 : ");
			users.add(new User(in.next()));
		}

		System.out.print("해적 통의 사이즈 : ");
		Pirate hook = new Pirate(in.nextInt());
		while (true) {

			System.out.println("게임을 시작하지. 순서는 내 맘대로.");
			ArrayList<Integer> userOrder = new ArrayList<>();
			while (true) {
				int userNum = (int) (Math.random() * userCount + 1);
				if (userOrder.contains(userNum)) {
					continue;
				} else {
					userOrder.add(userNum);
				}
				if (userOrder.size() == userCount) {
					break;
				}
			}
			if (_Game(in, hook, users, userOrder)) break;
		}

	}

	static boolean _Game(Scanner in, Pirate hook, ArrayList<User> users,ArrayList<Integer> userOrder){
		boolean hookChk = true;
		ArrayList<Integer> alreadyNum = new ArrayList<>();
		int arround = 0;
		hook.bomb = (int)(Math.random()*hook.size +1);
		System.out.println("----------------게임을 시작하지----------------");
		while(hookChk){
			for(int i = 0 ; i < users.size(); i++){
				System.out.printf("%s ! 해적 룰렛의 번호를 입력하라 ( 1 ~ %d ) : ", users.get(userOrder.get(i)-1).name, hook.size);
				int num = in.nextInt();
				if(alreadyNum.contains(num)){
					System.out.println("------------------------------------------------------- 그건 이미 다른 사람이 한 것이다 !!");
					i -= 1;
					continue;
				} else if(num > hook.size || num < 0){
					System.out.println("------------------------------------------------------- 그건 범위 밖의 숫자다 !");
					i -= 1;
					continue;
				}else {
					alreadyNum.add(0, num);
				}
				if(!hook.explode(alreadyNum.get(0))){
					System.out.println("------------------------------------------------------- 펑 !!!!!!!!!!!!!!!");
					System.out.println();
					System.out.println();
					System.out.println("----------------게임을 종료하지----------------");
					System.out.printf("-------------------그냥 줘 터질 사람 : %s\n", users.get(userOrder.get(i)-1).name);
					hookChk = false;
					break;
				} else{
					System.out.printf("------------------------------------------------------- 후.. %s ! 간신히 살았군 \n", users.get(userOrder.get(i)-1).name);
				}
			}
			if (!hookChk){
				continue;
			}
			arround++;
			System.out.printf("------------------------------------------------------- 너네 %d 바퀴 돌았다.\n", arround);
		}
		while(true) {
			System.out.print("계속 할건가? (1) /// 그만 할건가? (2)\n");
			int num = in.nextInt();
			if (num == 1) return false;
			else if (num == 2) return true;
			else System.out.println("1번과 2번 중에서만 적어라 !!");
		}
	}
}

class Pirate{
	int size;
	int bomb;

	public Pirate(int size) {
		this.size = size;
	}

	boolean explode(int num){
		return bomb != num;
	}

	@Override
	public String toString() {
		return "Pirate{" +"size=" + size +", bomb=" + bomb +'}';
	}
}
class User{
	String name;

	public User(String name) {
		this.name = name;
	}

}