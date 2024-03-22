package Prac_Extends_Interface;
/*
주어진 메인 메소드를 수행하여 출력 예와 같은 결과를 얻으려고 한다.
주어진 코드의 인터페이스와 클래스의 내용을 완성하라.
- 칭구 아이가~?
 */
public class EI_05 {
	public static void main(String[] args) {
		Artist kim = new Artist("뮤지션 김씨");
		Architect lee = new Architect("건축가 이씨");
		Developer park = new Developer("개발자 박씨");
		Lawyer choi = new Lawyer("변호사 최씨");

		Friend[] friends = { kim, lee, park, choi };
		for( Friend f : friends ){
			f.dearFriend();
		}
	}
}

interface Friend{
	void dearFriend();
}
class Artist implements Friend{
	private String name;
	public Artist(String name){
		this.name = name;
	}
	@Override
	public void dearFriend() {
		System.out.println(name + " -> 칭구 아이가 !");
	}
}
class Architect implements Friend{
	private String name;
	public Architect(String name){
		this.name = name;
	}
	@Override
	public void dearFriend() {
		System.out.println(name + " -> 칭구 아이가 !");
	}
}
class Developer implements Friend{
	private String name;
	public Developer(String name){
		this.name = name;
	}
	@Override
	public void dearFriend() {
		System.out.println(name + " -> 칭구 아이가 !");
	}
}
class Lawyer implements Friend{
	private String name;
	public Lawyer(String name){
		this.name = name;
	}
	@Override
	public void dearFriend() {
		System.out.println(name + " -> 칭구 아이가 !");
	}
}