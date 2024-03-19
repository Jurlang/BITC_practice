package Start_JAVA_Prac;

public class S11 {
	public static void main(String[] args) {
		double jan = 81.36;
		double feb = jan + 0.71;
		double mar = feb - 0.43;

		double avr = (jan + feb + mar) / 3;

		System.out.println("평균 : " + avr + " kg");
	}
}
