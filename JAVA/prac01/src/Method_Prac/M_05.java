package Method_Prac;

import java.util.Scanner;

/*
* 체력과 마력이 2000 이상 착용가능
* 체력과 마력을 입력하여 착용 결과를 출력
*/
public class M_05 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int hp1 = in.nextInt();
		int mp1 = in.nextInt();

		wear(hp1, mp1);

		int hp2 = in.nextInt();
		int mp2 = in.nextInt();

		wear(hp2, mp2);
	}

	public static void wear(int hp, int mp){
		if(hp >= 2000 && mp >= 2000){
			System.out.println("아이템 장착 완료 !");
		}
		else{
			System.out.println("아이템을 착용할 수 없습니다.");
		}
	}
}
