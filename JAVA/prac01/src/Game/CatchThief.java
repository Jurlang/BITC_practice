package Game;

import java.util.*;

/*
게임 : 도둑잡기
규칙
	. 53장의 카드를 나눠 갖는다. ( 1 대 1 )
	. 자신의 카드 중 숫자가 같은 카드를 2장씩 버린다.
	. 순서대로 옆의 카드를 한 장 들고오고,
		- 같은 카드가 있다 ? - 버림
		- 같은 카드가 없다 ? - 보류
	. 마지막 조커를 갖고 있는 사람이 패배.

설계
	유저, 컴퓨터, 카드, 게임
	카드
		- 1~13 하트 , 클로바, 스페이스, 다이아 + 조커

	유저, 컴퓨터
		- 카드
		= 카드 섞기
		= 버리기
		= 옆 사람 카드 고르기

	게임
		= 카드 나눠주기
		=
 */
public class CatchThief {
	public static void main(String[] args) {
		Card card = new Card();
		CardGamer c = new CardGamer();
		CardGamer u = new CardGamer();
		CardGame game = new CardGame();

		// 카드 나누기
		game.devideCard(card, u, c);
		System.out.println("c : " + c.getCard() + " | size : " + c.getSize());
		System.out.println("u : " + u.getCard() + " | size : " + u.getSize());

		// 본인 카드에서 한장씩 버리기
		c.removeSameCard();
		u.removeSameCard();
		System.out.println("c : " + c.getCard() + " | size : " + c.getSize());
		System.out.println("u : " + u.getCard() + " | size : " + u.getSize());

		// 본인의 카드 보여주기 ( 랜덤한 값을 가진 ArrayList)


	}
}

class CardGamer{
	private ArrayList<ArrayList<Integer>> card;

	public CardGamer() {
		card = new ArrayList<>();
		for( int i = 0  ; i < 5; i++){
			card.add(new ArrayList<>());
		}
	}
	public int getSize(){
		int size = 0;
		for (ArrayList<Integer> integers : card)
			size += integers.size();
		return size;
	}
	public ArrayList<ArrayList<Integer>> getCard() {
		for(int i = 0 ; i < 4 ; i++ ){
			Collections.sort(card.get(i));
		}
		return card;
	}
	public void putCard(int kind, int num){
		card.get(kind).add(num);
	}
	public void removeSameCard() {
		for(int i = 0; i < card.size()-1 ; i++){
			for(int j = 0 ; j < card.get(i).size(); j++){
				for(int k = i + 1 ; k < card.size() ; k++){
					if(card.get(k).contains(card.get(i).get(j))) {
						card.get(k).set(card.get(k).indexOf(card.get(i).get(j)), 0);
						card.get(i).set(j,0);
						break;
					}
				}
			}
		}
		for (ArrayList<Integer> integers : card) {
			for (int j = integers.size() - 1; j >= 0; j--) {
				if (integers.get(j) == 0) {
					integers.remove(j);
				}
			}
		}
	}

}

class Card{
	private ArrayList<ArrayList<Integer>> card;

	public Card(){
		card = new ArrayList<>();
		for(int j = 0 ; j < 4 ; j++) {
			ArrayList<Integer> kind = new ArrayList<>();
			for (int i = 0; i < 13; i++) {
				kind.add(i + 1);
			}
			card.add(kind);
		}
		card.add(new ArrayList<>(List.of(99)));

	}
	public boolean removeCard(int kind, int num){
		if (!(card.get(kind).get(num) == 0)) {
			card.get(kind).set(num, 0);
			return true;
		} else {
			return false;
		}
	}
	public void allRemoveCard(){
		card.clear();
	}
}

class CardGame{
	void devideCard(Card card, CardGamer u, CardGamer c){
		Random r = new Random();
		for (int i = 0; i < 53; i++) {
			int num = r.nextInt(13);
			int kind = r.nextInt(5);
			if(kind != 4) {
				if (card.removeCard(kind, num)) {
					if (i % 2 == 0)
						u.putCard(kind, num+1);
					else
						c.putCard(kind, num+1);
				}else i -= 1;
			} else{
				if(card.removeCard(kind, 0)){
					if (i % 2 == 0)
						u.putCard(kind, 99);
					else
						c.putCard(kind, 99);
				}else i -= 1;
			}
		}
		card.allRemoveCard();
	}
}