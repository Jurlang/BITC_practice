package Prac_Method;
/*
* 소개팅 어플 등급
* 요소 : 성격, 외모, 능력
* A - 모든 요소 4점 이상
* B - 총점 10점 이상 적어도 하나가 4점 이상
* C - 그외*/
public class M_11 {
	public static void main(String[] args) {
		String x = rating(4.2, 4.7, 4.3);
		String y = rating(3.8, 4.1, 3.5);
		String z = rating(3.6, 3.0, 3.4);

		System.out.printf("X -> %s등급\n", x);
		System.out.printf("Y -> %s등급\n", y);
		System.out.printf("Z -> %s등급\n", z);
	}
	public static String rating(double personality, double look, double skill){
		String result;
		double sum = personality + look + skill;

		if(personality >= 4.0 && look >= 4.0 && skill >= 4.0){
			result = "A";
		} else if(sum >= 10 && personality>=4 || look >= 4 || skill >=4 ){
			result = "B";
		}else{
			result = "C";
		}
		return result;
	}
}
