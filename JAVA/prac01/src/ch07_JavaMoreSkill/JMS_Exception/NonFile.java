package ch07_JavaMoreSkill.JMS_Exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NonFile {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("noneFile"));
			br.readLine();
			br.close();
		} catch (IOException e) {
			System.out.println("파일 못찾음");
		}

	}
}
