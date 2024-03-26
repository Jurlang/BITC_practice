package ch07_JavaMoreSkill.JMS_am;

public class JMS_accessModifier {
	private String secret;
	private String name;
	private int age;
	String default_variable;
	protected String protected_variable;

	public JMS_accessModifier() {
	}

	public JMS_accessModifier(String secret, String name, int age) {
		this.secret = secret;
		this.name = name;
		this.age = age;
	}

	private String getSecret(){ return this.secret; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }

//	---------------------------------------------------------------

	public static void main(String[] args) {
		JMS_accessModifier p = new JMS_accessModifier();
		JMS_accessModifier h = new JMS_accessModifier("홍길동", "홍길동", 10);
		p.secret = "private";
		System.out.println("getSecret : " + p.getSecret());
		System.out.println(h.getName());

		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		System.out.println("c1.count : " + c1.count);
		System.out.println("c2.count : " + c2.count);
		System.out.println("c3.count : " + c3.count);
	}
}

class Counter{
	static int count = 0;

	public Counter() {
		count++;
		System.out.println("count : " + count);
	}
}