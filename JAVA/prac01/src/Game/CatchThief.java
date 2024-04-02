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
		Scanner in = new Scanner(System.in);
		Card card = new Card();
		CardGamer c = new CardGamer();
		CardGamer u = new CardGamer();
		CardGame game = new CardGame();

		// 카드 나누기
		game.devideCard(card, u, c);

		// 본인 카드에서 한장씩 버리기
		c.removeSameCard();
		u.removeSameCard();

		// 본인의 카드 보여주기 ( 랜덤한 값을 가진 ArrayList )
		c.setGameCard(c.getCard());
		u.setGameCard(u.getCard());
		System.out.println("----------게임의 시작---------");
		System.out.println("게임은 도둑잡기 - 조커(99) 뽑기 입니다.");
		System.out.println("마지막 패에 조커(99)를 가진 유저/컴퓨터 가 패배합니다.");
		System.out.println("행운이 따르시길....");
		System.out.println("----------당신의 카드---------");
		System.out.println("당신의 카드 : " + u.getGameCard());

		// 내가 한 번 고르고, 컴퓨터가 한 번 고르고
		while(true) {
			if(game.gameCondition(u,c)) break;
			game.selectComputerCard(u, c, in);
			System.out.println();
			System.out.println("당신의 카드 : " + u.getGameCard());

			if(game.gameCondition(u,c)) break;
			game.selectUserCard(u, c);
			System.out.println();
			System.out.println("당신의 카드 : " + u.getGameCard());
		}



	}
}

class CardGamer{
	private final ArrayList<ArrayList<Integer>> card;
	private ArrayList<Integer> gameCard;

	public CardGamer() {
		card = new ArrayList<>();
		for( int i = 0  ; i < 5; i++){
			card.add(new ArrayList<>());
		}
	}
	// CARD
	public ArrayList<ArrayList<Integer>> getCard() {
		for(int i = 0 ; i < 4 ; i++ ){
			Collections.sort(card.get(i));
		}
		return card;
	}
	public void putCard(int kind, int num){
		card.get(kind).add(num);
	}
	// REMOVE SAME CARD
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
	// GAMECARD
	public void setGameCard(ArrayList<ArrayList<Integer>> card){
		gameCard = new ArrayList<>();
		for(ArrayList<Integer> kind : card){
			gameCard.addAll(kind);
		}
		card.clear();
	}
	public ArrayList<Integer> getGameCard(){
		return gameCard;
	}
	public Integer getGameCard(int idx){
		return gameCard.get(idx);
	}
	public int getGameCardSize(){
		return gameCard.size();
	}
	public boolean getContainsGameCard(int num){
		return gameCard.contains(num);
	}
	public void removeGameCard(int num){
		gameCard.remove((Integer)num);
	}
	public void putGameCard(int num){
		gameCard.add(num);
	}
}

class Card{
	private final ArrayList<ArrayList<Integer>> card;

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
	void selectComputerCard(CardGamer u, CardGamer c, Scanner in){
		System.out.println("----------당신의 차례----------");
		ArrayList<Integer> num = new ArrayList<>();
		System.out.print("들고갈 카드를 정하세요 ( ");
		for(int i = 0 ; i < c.getGameCardSize(); i++){
			int idx = (int)(Math.random()*c.getGameCardSize());
			if(!num.contains(idx)){
				num.add(idx);
				System.out.printf("%d ", i+1);
			} else{
				i -= 1;
			}
		}
		System.out.print(") : ");

		int selectIdx = 0;
		try {
			selectIdx = in.nextInt();
		}catch(InputMismatchException e){
			System.out.println("뻐킹 넘버 쓰라고 범위 내에서");
		}
		System.out.println("컴퓨터에게서 " + c.getGameCard(num.get(selectIdx - 1))+"를 가져왔습니다.");
		if(selectIdx > 0 && selectIdx <= c.getGameCardSize()) {
			if(u.getContainsGameCard(c.getGameCard(num.get(selectIdx - 1)))){
				u.removeGameCard(c.getGameCard(num.get(selectIdx - 1)));
				c.removeGameCard(c.getGameCard(num.get(selectIdx - 1)));
			} else{
				u.putGameCard(c.getGameCard(num.get(selectIdx - 1)));
				c.removeGameCard(c.getGameCard(num.get(selectIdx - 1)));
			}
		}
		else System.out.println("적힌 숫자 범위로 입력 부탁드립니다.");

	}
	void selectUserCard(CardGamer u, CardGamer c){
		System.out.println("----------컴퓨터 차례----------");
		int selectIdx = (int)(Math.random()*u.getGameCardSize());
		System.out.println("컴퓨터가 " + u.getGameCard(selectIdx) + "를 들고 갑니다.");
		if(c.getContainsGameCard(u.getGameCard(selectIdx))){
			c.removeGameCard(u.getGameCard(selectIdx));
			u.removeGameCard(u.getGameCard(selectIdx));
		} else{
			c.putGameCard(u.getGameCard(selectIdx));
			u.removeGameCard(u.getGameCard(selectIdx));
		}
	}
	boolean gameCondition(CardGamer u, CardGamer c){
		if((u.getGameCardSize() == 1 && c.getGameCardSize() == 0) || (u.getGameCardSize() == 0 && c.getGameCardSize() == 1)){
			System.out.println("게임이 종료되었습니다.");
			if(u.getGameCardSize() == 1) System.out.println("사용자의 패배입니다.");
			else System.out.println("사용자의 승리입니다.");
			return true;
		}
		return false;
	}
}