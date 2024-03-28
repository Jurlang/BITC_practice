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

		System.out.println("Card : " + card.getCard());

		game.devideCard(card, u, c);
		System.out.println("Card : " + card.getCard());
		System.out.println("u : " + u.getCard() + " // size : " + u.getSize());
		System.out.println("c : " + c.getCard() + " // size : " + c.getSize());
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
		for(int i = 0 ; i < card.size(); i++)
			size += card.get(i).size();
		return size;
	}
	public ArrayList<ArrayList<Integer>> getCard() {
		for(int i = 0 ; i < 4 ; i++ ){
			Collections.sort(card.get(i));
		}
		return card;
	}
	public ArrayList<Integer> getCard(Integer kind) {
		return card.get(kind);
	}
	public void putCard(int kind, int num){
		card.get(kind).add(num);
	}
	public void sameCardRemove(){
		for(int kind = 0 ; kind < card.size() ; kind++ ){
			for(int num = 0 ; num < card.get(kind).size() ; num++){
				int count = 1;


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
	public ArrayList<ArrayList<Integer>> getCard() {
		return card;
	}
	public ArrayList<Integer> getCard(Integer i) {
		return card.get(i);
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
		card.removeAll(card);
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