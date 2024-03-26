package ch06_in_out;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO_Console {
	public static void main(String[] args) throws IOException {
		// InputStream 예제
		InputStream in = System.in;
		
		// InputStream 1개 단어 읽어오기
		int a;
		a = in.read();
		System.out.println(a);

		// InputStream 3개 단어 읽어오기
		int aa; int ab; int ac;
		aa = in.read();
		ab = in.read();
		ac = in.read();
		char ba = (char)aa;
		int[] ca = {in.read(), in.read(), in.read()};
		System.out.println(aa + "//" + ab + "//" + ac + "//" + ba);
		System.out.println(ca[0] + "//" + ca[1] + "//" + ca[2]);

		// byte 배열로 3 Byte 읽어오기
		byte[] da = new byte[3];
		in.read(da);
		System.out.println(da[0] + "//" + da[1] + "//" + da[2]);

		// InputStreamReader 예제
		InputStreamReader reader = new InputStreamReader(in);
		char[] ra = new char[3];
		reader.read(ra);
		System.out.println("InputStreamReader : " + ra[0] + "//" + ra[1] + "//" + ra[2]);

		// BufferedReader 예제
		BufferedReader buf = new BufferedReader(reader);
		String buf_str = buf.readLine();
		System.out.println("BufferedReader : " + buf_str);

		// Scanner 예제
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
		System.out.println(sc.nextInt());
		sc.close();

		// 출력 예제
		System.err.println("hello");
	}
}
