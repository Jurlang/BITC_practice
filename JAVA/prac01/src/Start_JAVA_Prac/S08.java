package Start_JAVA_Prac;

public class S08 {
	public static void main(String[] args) {
		int totalSec = 7582;
		int hour = totalSec / 3600;
		int min = (totalSec-hour*3600) / 60;
		int sec = totalSec - hour*3600 - min*60;

		System.out.println(hour + " 시간 " + min + " 분 " + sec + " 초");
	}
}
