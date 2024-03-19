package Method_Prac;

/*
A+ >= 95
A0 >= 90
B+ >= 80
B0 >= 70
C+ 나머지

주어진 성적 변수에 대한 학점을 반환
 */
public class M_06 {
	public static void main(String[] args) {
		int score1 = 96;
		int score2 = 85;
		int score3 = 76;

		System.out.printf("%d점 -> %s\n", score1, grade(score1));
		System.out.printf("%d점 -> %s\n", score2, grade(score2));
		System.out.printf("%d점 -> %s\n", score3, grade(score3));
	}

	public static String grade(int score){
		if(score >= 95){
			return "A+";
		}else if(score >= 90) {
			return "A0";
		}else if(score >= 80){
			return "B+";
		}else if(score >= 70){
			return "B0";
		}else{
			return "C+";
		}
	}
}
