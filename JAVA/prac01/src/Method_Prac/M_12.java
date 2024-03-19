package Method_Prac;
/*
* 주급 = 근무시간 x 기본 시급
* 기본 시급 최저 8 이보다 작으면 경고문
* 주당 근무 60 넘을시 경고문
*/
public class M_12 {
	public static void main(String[] args) {
		printPay(10.00, 40);
		printPay(10.00, 50);
		printPay(7.50, 38);
		printPay(8.50, 66);
	}
	public static void printPay(double basePay, int hours){
		double pay;
		if(basePay < 8){
			System.out.println("최저시급에러!");
		} else if(hours > 60){
			System.out.println("초과 근무 시간 에러!");
		}else{
			pay = basePay * hours;
			System.out.printf("%.2f\n", pay);
		}
	}
}
