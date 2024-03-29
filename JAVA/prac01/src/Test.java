public class Test {
	public static void main(String[] args) {
		int start = 10;
		int end_num = 3;
		int[] answer = new int[start - end_num +1];
		int idx = 0;
		for(int i = start ; i >= end_num ; i-- ){
			System.out.println(i);

			answer[idx] = i;
			idx++;
		}

		for(int i = 0 ; i < answer.length ; i++)
			System.out.print(answer[i]);


	}
}
