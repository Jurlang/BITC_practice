package Game;

import java.util.ArrayList;
import java.util.Scanner;

/*
NumBaseball 숫자 야구
	. 컴퓨터가 0~9999 사이의 숫자를 고른다. ( 중복 없는 4자리 )
	. 사용자가 숫자를 넣는다.
	. 같은 자리이면서 같은 숫자 = 스트라이크
	. 다른 자리이면서 같은 숫자 = 볼
	. 아에 숫자가 없으면 .. ?  = 아웃
	. 목표 : 삼진아웃.

	1. 컴퓨터가 숫자를 정한다. ( 중복 없는 4자리 )
	2. 유저가 숫자를 입력한다. ( 중복 없는 4자리 )
	3. 유저숫자와 컴퓨터 숫자 비교
		2중for문 - i == j 	스트 카운트
				- i != j 	볼 카운트
		만약 스트 0 볼 0 == 아웃
	4. 2번과 3번 반복
	5. 정답 찾기
*/
public class NumBaseball {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Com c = new Com();
		Gamer g = new Gamer();
		int digit;

		while(true) {
			while (true) {
				System.out.print("게임할 숫자의 자리 수 ( 3 , 4 ) : ");
				String _digit = in.nextLine();
				if (_digit.equals("3") || _digit.equals("4")) {
					digit = Integer.parseInt(_digit);
					break;
				} else System.out.println("------------------------------------------ 3 또는 4 로 입력해주세요.");
			}

			c.setNum(digit);

			NB_Rule nb = new NB_Rule();
			while (true) {
				while (true) {
					System.out.print("유저님 숫자를 입력하세요 : ");
					String num = in.nextLine();
					if (g.setNum(digit, num)) break;
					else System.out.println("------------------------------------------ 입력이 잘 못 되었거나, 반복되는 숫자가 있습니다..");
				}
				if (nb.compareNum(digit, g.num, c.num)) break;
			}

			while(true) {
				System.out.print("게임을 계속하시겠습니까 ? ( 1 ) // 안할란다 치아라 ( 2 ) ");
				String chk = in.nextLine();
				if (chk.equals("1"))
					break;
				else if(chk.equals("2"))
					return;
			}
		}
	}
}

abstract class Number {
	ArrayList<Integer> num;
}

class Com extends Number{
	void setNum(int digit){
		num = new ArrayList<>();
		for(int i = 0 ; i < digit ; i ++ ) {
			int a = (int) (Math.random() * 10);
			if(num.contains(a)) i -= 1;
			else num.add(a);
		}
	}
}

class Gamer extends Number{
	boolean setNum(int digit, String number){
		if(number.length() != digit) return false;
		num = new ArrayList<>();
		for(int i = 0 ; i < digit ; i ++){
			char c = number.charAt(i);
			if(Character.isDigit(c)) {
				int n = Integer.parseInt(c + "");
				if (!num.contains(n)) {
					num.add(n);
				}
			}
		}
		return num.size() == digit;
	}
}

class NB_Rule{
	int strike;
	int ball;
	int count = 0;

	boolean compareNum(int digit, ArrayList<Integer> userNum, ArrayList<Integer> comNum){
		strike = 0;
		ball = 0;

		for( int i = 0; i < digit ; i++){
			for( int j = 0 ; j < digit ; j++){
				if( userNum.get(i).equals(comNum.get(j)) && i == j )
					strike += 1;
				else if( userNum.get(i).equals(comNum.get(j)) && i != j )
					ball += 1;
			}
		}
		count++;
		if(strike == userNum.size()){
			System.out.println("------------------------------------------ 정답입니다. // " + count + " 번째 도전");
			return true;
		}
		else {
			System.out.println("------------------------------------------ 스트라이크 : " + strike + " // 볼 : " + ball + " // " + count + " 번째 도전");
			return false;
		}
	}
}