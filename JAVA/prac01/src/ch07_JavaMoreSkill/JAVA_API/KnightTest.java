package ch07_JavaMoreSkill.JAVA_API;

public class KnightTest {
	public static void main(String[] args) {
		System.out.println("[객체생성]");

		Knight knight1 = new Knight("똥키호테", 30);
		System.out.printf("\t%s\n", knight1);

		System.out.println("[똥키호테 hp +30]");

		knight1.setHp(knight1.getHp()+30);
		System.out.printf("\t%s\n", knight1);
	}
}

class Knight{
	private String name;
	private int hp;

	public Knight(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public int getHp() { return hp; }
	public void setHp(int hp) { this.hp = hp; }
	@Override
	public String toString() { return "Knight{" + "name='" + name + '\'' + ", hp=" + hp + '}'; }
}
