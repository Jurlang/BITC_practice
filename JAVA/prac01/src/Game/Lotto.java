package Game;

import java.util.ArrayList;
import java.util.Comparator;

/*
로또 번호 얻어오기.
 */
public class Lotto {
	public static void main(String[] args) {
		ArrayList<Integer>[] lotto = new ArrayList[5];
		for(int i = 0 ; i < 5 ; i++){
			lotto[i] = new ArrayList<>();
		}
		for(int i = 0; i< 5; i++){
			for(int j = 0 ; j < 6 ; j++) {
				int randomNum = (int) (Math.random() * 45 + 1);
				if(lotto[i].contains(randomNum)){
					j -= 1;
				} else {
					lotto[i].add(randomNum);
				}
			}
			lotto[i].sort(Comparator.naturalOrder());
		}
		System.out.println("-------------------------------------");
		System.out.println("T O D A Y   L O T T O   N U M B E R !");
		System.out.println("-------------------------------------");
		for(int i = 0; i < 5 ; i++){
			System.out.println((i+1) + " : " +lotto[i]);
		}
		System.out.println("-------------------------------------");

	}
}
