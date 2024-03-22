package Game;

import java.util.ArrayList;

/*
1. 앞서 만든 Lotto 를 10번 돌린다.
2. Lotto 번호 ( 1 ~ 45 ) 를 카운팅 한다.
3. 1 ~ 45 중 가장 많이 카운트 된 6 자리를 선별 ( 1줄 )
4. 위 과정을 5번 하여 5줄을 만든다.
 */
public class Lotto_Count {
	public static void main(String[] args) {
		ArrayList<Integer>[] _lotto= new ArrayList[5];

		int[] lottoNumCount = new int[45];
		int lottoLine;
		for(lottoLine = 0; lottoLine < 5 ; lottoLine++) {

			for (int i = 0; i < 45; i++) {
				lottoNumCount[i] = 0;
			}

			for (int k = 0; k < 10; k++) {
				for (int i = 0; i < 5; i++) {
					ArrayList<Integer> lotto_line = new ArrayList<>();
					for (int j = 0; j < 6; j++) {
						int randomNum = (int) (Math.random() * 45 + 1);
						if (lotto_line.contains(randomNum)) {
							j -= 1;
						} else {
							lotto_line.add(randomNum);
							lottoNumCount[randomNum - 1] += 1;
						}
					}
				}
			}
			System.out.println((lottoLine+1) + " 차 Counting-----------------------");
			for (int i = 0; i < 45; i=i+5) {
				System.out.printf("%d : %d		%d : %d		%d : %d		%d : %d		%d : %d\n",
						i+1, lottoNumCount[i], i+2, lottoNumCount[i+1], i+3, lottoNumCount[i+2], i+4, lottoNumCount[i+3], i+5, lottoNumCount[i+4]);
			}

			_lotto[lottoLine] = new ArrayList<>();
			_lotto[lottoLine].add(0);

			for(int i = 1; i < 6; i++){
				for(int j = 0; j < i; j++) {
					if(lottoNumCount[i] > lottoNumCount[_lotto[lottoLine].get(j)]) {
						if(!_lotto[lottoLine].contains(i)) _lotto[lottoLine].add(j, i);
					} else{
						if( j == i - 1 )
							if(!_lotto[lottoLine].contains(i)) _lotto[lottoLine].add(j+1, i);
					}
				}
			}
			for (int i = 6; i < 45; i++) {
				for (int j = 0; j < 6; j++) {
					if (lottoNumCount[i] > lottoNumCount[_lotto[lottoLine].get(j)]) {
						if (_lotto[lottoLine].get(j) != i) {
							_lotto[lottoLine].add(j, i);
							break;
						}
					}
				}
			}
		}

		System.out.println("-------------------------------------");
		System.out.println("T O D A Y   L O T T O   N U M B E R !");
		System.out.println("-------------------------------------");
		for(int i = 0; i< 5 ; i++){
			System.out.printf("%d Line : ", i+1);
			for(int j = 0 ; j < 6 ; j++) {
				System.out.printf("%d ", _lotto[i].get(j)+1);
			}
			System.out.println();
		}
		System.out.println("-------------------------------------");
	}
}
