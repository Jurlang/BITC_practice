package ch04_Control;
/*
 * Class - C_while
 * 	- Method : main
 * 		= Ch 04. 제어문 ( while ) - 수업 내용 및 코드 소스
 */
public class C_while {
	public static void main(String[] args) {
		// 기본 while 문
		int treeHit = 0;
		while (treeHit < 10){
			treeHit++;
			System.out.println("나무를 " + treeHit + "번 찍었습니다.");
			if(treeHit == 10){
				System.out.println("나무 넘어갑니다.");
			}
		}

		// break 이용
		int coffee = 10;
		int money = 300;
		while(money > 0){
			money -= 10;
			System.out.println("돈을 받았으니 커피를 줍니다.");
			coffee--;
			System.out.println("남은 커피 양 : " + coffee + " 잔 입니다.");
			if(coffee == 0){
				System.out.println("커피 품절");
				System.out.println("남은 돈 : " + money);
				break;
			}
		}

		// continue 이용
		int i = 0;
		System.out.printf("짝수 : ");
		while(i < 50){
			i++;
			if(i % 2 == 1) {
				continue;
			}
			System.out.printf("%d ", i);
		}
	}
}
