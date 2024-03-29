package Prac_Method;
// 출생연도에 따른 12간지 동물의 띠를 출력하도록.
public class M_09 {
	public static void main(String[] args) {
		printAnimal(1986);
		printAnimal(1990);
		printAnimal(2000);
	}
	public static void printAnimal(int year){
		String animal = switch (year % 12) {
			case 0 -> "원숭이";
			case 1 -> "닭";
			case 2 -> "개";
			case 3 -> "돼지";
			case 4 -> "쥐";
			case 5 -> "소";
			case 6 -> "호랑이";
			case 7 -> "토끼";
			case 8 -> "용";
			case 9 -> "뱀";
			case 10 -> "말";
			case 11 -> "양";
			default -> "ERROR!";
		};

//		switch (year % 12){
//			case 0:
//				animal = "원숭이";
//				break;
//			case 1:
//				animal = "닭";
//				break;
//			case 2:
//				animal = "개";
//				break;
//			case 3:
//				animal = "돼지";
//				break;
//			case 4:
//				animal = "쥐";
//				break;
//			case 5:
//				animal = "소";
//				break;
//			case 6:
//				animal = "호랑이";
//				break;
//			case 7:
//				animal = "토끼";
//				break;
//			case 8:
//				animal = "용";
//				break;
//			case 9:
//				animal = "뱀";
//				break;
//			case 10:
//				animal = "말";
//				break;
//			case 11:
//				animal = "양";
//				break;
//			default:
//				animal = "ERROR!";
//				break;
//		}
		System.out.printf("%d년 => %s띠\n", year, animal);
	}
}
