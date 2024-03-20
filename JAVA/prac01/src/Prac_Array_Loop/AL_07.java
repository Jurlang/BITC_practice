package Prac_Array_Loop;
/*
* 1일뒤 2마리
* 2일뒤 4마리
* 3일뒤 8마리
* 9일뒤 512마리 ...
* 배열로 기록.
* */
public class AL_07 {
	public static void main(String[] args) {
		int[] bacteriaCountLogs = new int[10];

		writeLog(bacteriaCountLogs);
		printLog(bacteriaCountLogs);
	}
	//박테리아의 개체수를 기록
	public static void writeLog(int[] logs){
		for( int i = 0 ; i < logs.length ; i ++ ){
			logs[i] = (int)Math.pow(2,i);
		}
	}
	// 배열을 입력받아, 해당 요소를 모두 출력
	public static void printLog(int[] arr){
		System.out.printf("[");
		for( int i = 0 ; i < arr.length ; i++ ){
			System.out.printf("%d", arr[i]);
			if(i != arr.length -1) {
				System.out.printf(", ");
			}
		}
		System.out.println("]");
	}
}
