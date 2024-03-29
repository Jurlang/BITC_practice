package Homework_API;

import java.io.IOException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws IOException {
		WindSpeed data = new WindSpeed();
		Scanner in = new Scanner(System.in);
		System.out.print("안녕하세요. 부산시 풍향풍속 알리미 입니다.\n");
		System.out.println("---------------------------------------------------------------------------------");
		while(true) {
			data.getItem(selectIdx(in, data));
			if(!toBeContinue(in)) break;
		}
		in.close();
	}
	public static boolean toBeContinue(Scanner in){
		int _ans;
		while(true){
			System.out.print("다른 지역도 보시겠습니까 ? ( 1. 네 / 2. 아니오 ) : ");
			String ans = in.nextLine();
			try{
				_ans = Integer.parseInt(ans);
				if(_ans < 1 || _ans > 2) {
					System.out.println("잘못된 입력 값 입니다.");
				}else {
					if(_ans == 1){
						System.out.println("---------------------------------------------------------------------------------");
						return true;
					}
					else{
						System.out.println("부산시 풍향풍속 알리미를 이용해주셔서 감사합니다.");
						return false;
					}
				}
			}catch(NumberFormatException e){
				System.out.println("잘못된 입력 값 입니다.");
			}
		}
	}
	public static int selectIdx(Scanner in, WindSpeed data){
		data.getArea();
		System.out.println();
		System.out.println("---------------------------------------------------------------------------------");
		int _idx;
		while(true) {
			System.out.print("위의 보기 중 원하는 중심 구역의 번호를 입력해주세요. : ");
			String idx = in.nextLine();
			try {
				_idx = Integer.parseInt(idx);
				if (_idx < 0 || _idx >= data.getSize()) {
					System.out.println("잘못된 입력 값 입니다.");
				} else
					return _idx;
			} catch (NumberFormatException e) {
				System.out.println("잘못된 입력 값 입니다.");
			}
		}

	}
}
