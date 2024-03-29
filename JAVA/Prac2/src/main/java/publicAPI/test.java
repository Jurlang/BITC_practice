package publicAPI;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		String answer = "";
		String my_string = "Program29b8UYP";
		String overwrite_string = "merS123";
		int s = 7;

		char[] a = my_string.toCharArray();
		char[] b = overwrite_string.toCharArray();

		for(int i = s ; i < b.length + s ; i++){
			a[i] = b[i-s];
		}

		answer = String.valueOf(a);

		System.out.println(answer);
	}

}
