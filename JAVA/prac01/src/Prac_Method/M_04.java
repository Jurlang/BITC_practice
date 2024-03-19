package Prac_Method;
/*
* 주사위의 눈 수만큼 달러 획득
* 3번 던져 얻은 달러
* 이를 환전한 결과를 출력
* Math.random() 1~6 반환 dice 메소드 구현
* 1 달러 환율 = 1082.25108원*/
public class M_04 {
	public static void main(String[] args) {
		double dollar = dice() + dice() + dice();
		double won = exchange(dollar);
		System.out.printf("획득 금액 : $%.2f (%.0f원)", dollar, won);
	}
	public static int dice(){
		return (int)(Math.random()*6)+1;
	}
	public static double exchange(double dollar){
		return dollar * 1082.25108;
	}
}
