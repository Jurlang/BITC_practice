package Method_Prac;
/*
* 제공되는 코드를 분석하고 oneLine() 메소드를 변경하여
* 출력과 같은 결과를 얻으시오.
*/
public class M_01 {
	public static void main(String[] args) {
		System.out.println("Line 1");
		threeLines();
		System.out.println("Line 2");
	}
	public static void threeLines(){
		oneLine();
		oneLine();
		oneLine();
	}
	public static void oneLine(){
		System.out.println(">");
	}
}
