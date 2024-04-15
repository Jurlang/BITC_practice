import java.util.*;

public class test {
	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6};
		int size = 0;
		for(int i = 0 ; i < 10 ; i++){
			if(Math.pow(2,i) >= arr.length){
				size = (int)Math.pow(2,i);
				break;
			}
		}
		int[] answer = new int[size];
		for(int i = 0 ; i < size ; i++){
			if(i>=arr.length) answer[i] = 0;
			else answer[i] = arr[i];
		}

//		System.out.println(answer);
		for(int i = 0 ; i< answer.length ; i++){
			System.out.println(answer[i]);
		}
	}
}
