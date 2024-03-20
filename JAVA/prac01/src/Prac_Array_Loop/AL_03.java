package Prac_Array_Loop;
/*
두 개의 배열을 하나로 합치기
*/
public class AL_03 {
	public static void main(String[] args) {
		int[] evens = {0,2,4,6,8};
		int[] odds = {1,3,5,7,9};

		int[] result = merge(evens, odds);

		System.out.printf("결과 : ");
		for( int i = 0; i < result.length; i++){
			System.out.printf("%d ", result[i]);
		}
	}
	public static int[] merge(int[] arr1, int[] arr2){
		int[] mergedArr = new int[arr1.length + arr2.length];

		for(int i = 0 ; i < arr1.length; i++){
			mergedArr[2*i] = arr1[i];
			mergedArr[2*i + 1] = arr2[i];
		}

		return mergedArr;
	}
}
