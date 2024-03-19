package Start_JAVA;

public class S12 {
	public static void main(String[] args) {
		int x = 374;

		int x100 = x / 100;
		int x10 = (x - x100 * 100) / 10;
		int x1 = x % 10;

		System.out.println("총합 : " + (x100 + x10 + x1));
	}
}
