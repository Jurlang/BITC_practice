package Prac_Start_JAVA;

public class S09 {
	public static void main(String[] args) {
		double meter = 100;
		double sec = 18;

		double speed = (meter/1000) / (sec / 3600);

		System.out.println("시속 : " + speed + " km/h");
	}
}
