package ch05_object;
/*
Class : O_objectVariable
	- Method : main
		= Ch 05. 객체 지향 프로그래밍 ( 객체 변수 )
		= Ch 05. 객체 지향 프로그래밍 ( 메소드 )
*/
public class O_objectVariable {
	public static void main(String[] args) {
		Animal cat = new Animal();
		System.out.println(cat.name);

		cat.name = "냐옹이";
		System.out.println(cat.name);

		cat.setName("고양이");
		System.out.println(cat.name);

		Animal dog = new Animal();
		dog.setName("멍멍이");
		System.out.println(dog.name);
	}
}

/*
Class : Animal
	- Variable : Name(s)
	- Method : setName( String )
		= 필드변수 Name 에 값 저장.
 */
class Animal{
	String name;

	void setName(String name){
		this.name = name;
	}
}