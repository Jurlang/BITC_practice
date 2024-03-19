package Method_Prac;

import java.util.Scanner;

/*
* 저층은 1~10
* 고층은 11~20
* 층수를 입력받아 타야할 엘베 반환
*/
public class M_08 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();

		System.out.printf("%d층 -> %s 엘레베이터\n", a, guide(a));
		System.out.printf("%d층 -> %s 엘레베이터\n", b, guide(b));
		System.out.printf("%d층 -> %s 엘레베이터\n", c, guide(c));
	}

	public static String guide(int floor){
		return floor >= 1 && floor <= 10 ? "저층" : "고층";
	}
}
