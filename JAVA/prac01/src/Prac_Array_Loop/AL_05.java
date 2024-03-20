package Prac_Array_Loop;
/*
* 정수 n 을 만드는 3가지 정수의 곱 A,B,C를 출력
*/
public class AL_05 {
	public static void main(String[] args) {
		printCombos(10);
	}
	public static void printCombos(int n){
		int idxChk = 0;
		for ( int i = 0 ; i <= n ; i++ ){
			for ( int j = 0 ; j <= n ; j++ ){
				for ( int k = 0 ; k <= n ; k++ ){
					if(i * j * k == n){
						System.out.printf("%d = %d x %d x %d\n", n, i, j, k);
						idxChk++;
					}
				}
			}
		}
		System.out.println("===================");
		System.out.println("경우의 수 : " + idxChk);
	}
}
