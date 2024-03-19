package ch03_solved;

public class S05 {
	public static void main(String[] args) {
		double euro = 1281.62664;
		double dollor = 1091.70306;

		int scanEur = 52;
		int scanDol = 32;

		double eTow = scanEur * euro;
		double dTow = scanDol * dollor;

		System.out.printf("환전 결과 : %.0f원", eTow+dTow);
	}
}
