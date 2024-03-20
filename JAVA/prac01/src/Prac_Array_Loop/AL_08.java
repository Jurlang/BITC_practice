package Prac_Array_Loop;
/*
* 가장 높은 점수를 가진 사람의 이름과 점수 출력하기
*/
public class AL_08 {
	public static void main(String[] args) {
		String[] names = {"Elena", "Suzie", "John", "Emily", "Neda", "Kate", "Alex", "Daniel", "Hamilton"};
		int[] scores = {65,74,23,75,68,96,88,98,54};

		int i = topIndex(scores);

		System.out.printf("1등 : %s ( %d 점 )\n", names[i], scores[i]);
	}

	public static int topIndex(int[] arr){
		int topVal = 0;
		int topIdx = 0;
		for(int i = 0; i < arr.length ; i++){
			if(arr[i] > topVal){
				topVal = arr[i];
				topIdx = i;
			}
		}
		return topIdx;
	}
}
