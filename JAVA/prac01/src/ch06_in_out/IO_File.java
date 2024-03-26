package ch06_in_out;

import java.io.*;

public class IO_File {
	public static void main(String[] args) throws IOException {
		FileOutputStream output = new FileOutputStream("./src/ch06_in_out/FileOutputStream.txt");
		for(int i = 0; i < 10; i++){
			String data = (i+1) + " 번째 줄입니다.\r\n";
			output.write(data.getBytes());
		}
		output.close();

		FileWriter fw = new FileWriter("./src/ch06_in_out/FileWriter.txt");
		for(int i = 0; i < 10; i++){
			String data = (i+1) + " 번째 줄입니다.\r\n";
			fw.write(data);
		}
		fw.close();

		PrintWriter pw = new PrintWriter("./src/ch06_in_out/PrintWriter.txt");
		for(int i = 0; i < 10; i++){
			String data = (i+1) + " 번째 줄입니다.";
			pw.println(data);
		}
		pw.close();

		FileWriter fw2 = new FileWriter("./src/ch06_in_out/FileWriter.txt", true);
		for ( int i = 0 ; i < 10 ; i++){
			String data = "추가 입력 입니다.\r\n";
			fw2.write(data);
		}
		fw2.close();

		PrintWriter pw2 = new PrintWriter(new FileWriter("./src/ch06_in_out/PrintWriter.txt", true));
		for ( int i = 0 ; i < 10 ; i++){
			String data = "추가 입력 입니다.";
			pw2.println(data);
		}
		pw2.close();

		byte[] b = new byte[1024];
		FileInputStream input = new FileInputStream("./src/ch06_in_out/FileOutputStream.txt");
		input.read(b);
		System.out.println("FileInputStream : " + new String(b));
		input.close();

		BufferedReader br = new BufferedReader(new FileReader("./src/ch06_in_out/FileOutputStream.txt"));
		while(true){
			String line = br.readLine();
			if(line == null) break;
			System.out.println("BufferedReader : " + line);
		}
		br.close();
	}
}
