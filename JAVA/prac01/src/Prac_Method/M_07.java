package Prac_Method;
/*
* 보컬과 댄스의 점수의 곱이 70 이상 합격*/
public class M_07 {
	public static void main(String[] args) {
		double tomVo = 8.8;
		double tomDa = 7.6;
		double kateVo = 9.2;
		double kateDa = 7.8;


		System.out.printf("Tom의 오디션 결과 : %s\n", test(tomVo, tomDa));
		System.out.printf("kate의 오디션 결과 : %s\n", test(kateVo, kateDa));
	}
	public static String test(double vocal, double dance){
		return (vocal*dance)>70.0?"합격":"불합격";
	}
}

