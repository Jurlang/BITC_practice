package Method_Prac;
/*
* 삼겹살 1인분의 무게는 180g
* 삼겹살 1g의 칼로리가 5.179kcal
* 삼겹살 3인분의 칼로리를 소수점 이하 둘째자리까지
*/
public class M_02 {
	public static void main(String[] args) {
		int n = 3;
		double result = calorieCalculator(n);

		System.out.printf("삼겹살 3인분 : %.2f kcal", result);

	}

	private static double calorieCalculator(int n){
		return 180 * 5.179 * n;
	}
}
