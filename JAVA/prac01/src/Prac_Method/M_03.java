package Prac_Method;
/*
* 가솔리 8.86L -> 182.736 Km 운행
*/
public class M_03 {
	public static void main(String[] args) {
		double gasoline = 8.86;
		double distance = 182.736;
		double efficiency = calcEffiency(gasoline, distance);
		System.out.printf("연비 : %.2f km/L", efficiency);
	}

	public static double calcEffiency(double fuel, double distance){
		return distance / fuel;
	}
}
