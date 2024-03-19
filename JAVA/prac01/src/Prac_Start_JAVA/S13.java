package Prac_Start_JAVA;

public class S13 {
	public static void main(String[] args) {
		double time = 5.0;
		double gravity = -9.81;
		double initVelocity = 0.0;
		double initPosition = 1000.0;

		double finalPosition = (0.5 * gravity * time * time) + initVelocity * time + initPosition;

		System.out.printf("%.2f초 후 위치 : %.2f m\n", time, finalPosition);
	}
}
