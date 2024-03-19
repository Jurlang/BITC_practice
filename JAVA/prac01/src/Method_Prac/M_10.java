package Method_Prac;
/*
* BMI = W / (T * T)
* 비만 - 30 이상
* 과체중 - 25 ~ 30
* 정상  - 18.5 ~ 25
* 저체중 - 18.5 미만
*/
public class M_10 {
	public static void main(String[] args) {
		double w = 81.6;
		double t = 1.76;

		double bmi = calculate(w,t);

		System.out.printf("BMI : %.2f(%.1f kg, %.2fm)\n", bmi, w, t);
		System.out.printf("결과 : %s 입니다.\n", result(bmi));
	}

	public static double calculate(double weight, double tall){
		return weight / (tall * tall);
	}

	public static String result(double bmi){
		String result;

		if(bmi >= 30){
			result = "비만";
		}else if(bmi >= 25){
			result = "과체중";
		}else if(bmi >= 18.5){
			result = "정상";
		}else {
			result = "저체중";
		}

		return result;
	}
}
