package Prac_Class;
/*
정육면체 - 부피 겉넓이 구하기.
*/
public class C_04 {
	public static void main(String[] args) {
		Cube a = new Cube(3);
		Cube b = new Cube(5);

		System.out.printf("정육면체 a의 부피 : %d , 겉넓이 : %d\n", a.volumn(), a.surfaceArea());
		System.out.printf("정육면체 b의 부피 : %d , 겉넓이 : %d\n", b.volumn(), b.surfaceArea());
	}
}

class Cube{
	int length;

	Cube(int length){
		this.length = length;
	}

	public int volumn(){
		return length * length * length;
	}
	public int surfaceArea(){
		return length * length * 6;
	}
}