package Prac_JAVA_API;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
Stringtokenizer 를 사용해
문자열을 나누기
 */
public class JA_03 {
	public static void main(String[] args) {
		Tokenizer tkn = new Tokenizer("치킨,피자,보쌈,족발,초밥,떡볶이,탕수육", ",");
		ArrayList<String> token = tkn.tokenizing();
		System.out.println(token);
	}
}

class Tokenizer{
	String str;
	String st;

	public Tokenizer(String str, String st) {
		this.str = str;
		this.st = st;
	}

	ArrayList<String> tokenizing(){
		StringTokenizer tkn = new StringTokenizer(this.str, this.st);
		ArrayList<String> tokenStr = new ArrayList<>();
		while(tkn.hasMoreTokens()){
			tokenStr.add(tkn.nextToken());
		}
		return tokenStr;
	}
}
