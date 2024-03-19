package ch03_solved;

public class S14 {
	public static void main(String[] args) {
		int price = 152365;

		int oman = price / 50000;
		int man = (price-oman*50000) / 10000;
		int ochun = (price-oman*50000-man * 10000) / 5000;
		int chun = (price-oman*50000-man * 10000-ochun * 5000) / 1000;
		int discounted = price % 1000;

		int totalCnt = oman + man + ochun + chun;

		System.out.printf("5만원 x %d \n", oman);
		System.out.printf("1만원 x %d \n", man);
		System.out.printf("5천원 x %d \n", ochun);
		System.out.printf("1천원 x %d \n", chun);
		System.out.println("---------------");
		System.out.printf("총 장수 : %d 장\n", totalCnt);
		System.out.printf("금액 : %d 원 \n", price - discounted);
		System.out.printf("할인 : %d 원 \n", discounted);
	}
}
