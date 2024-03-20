package Prac_Class;

public class C_01 {
	public static void main(String[] args) {
		Cylinder c = new Cylinder();

		c.r = 4;
		c.h = 5;

		System.out.printf("원기둥의 부피 : %.2f\n", c.getVolumn());
		System.out.printf("원기둥의 겉넓이 : %.2f\n", c.getArea());
	}
}

class Cylinder{
	double r;
	double h;
	double pi = Math.PI;

	double getArea(){
		return 2 * pi * r * r + 2 * pi * r * h;
	}
	double getVolumn(){
		return pi * r * r * h;
	}
}