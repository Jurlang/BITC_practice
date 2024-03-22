package Prac_Extends_Interface;
/*
뼈대코드를 참고하여
대마법사 클래스를 하나 더 만들어 속성을 추가하여
메소드를 추가 및 오버로딩하여 아래와 같은 결과를 만드시오.
- 대마법사
 */
public class EI_04 {
	public static void main(String[] args){
		GreatWizard gandalf = new GreatWizard("간달프", 100, 100, 100);
		System.out.println(gandalf.toString());
		gandalf.energeVolt();
	}
}

class Novice{
	protected String name;
	protected int hp;

	public Novice(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	@Override
	public String toString() {
		return String.format("[Novice] %s(HP: %d)", name, hp);
	}
}

class Wizard extends Novice{
	protected int mp;

	public Wizard(String name, int hp, int mp) {
		super(name, hp);
		this.mp = mp;
	}

	public void energeVolt(){
		System.out.printf("%s 의 에너지볼트 !\n", this.name);
	}
}

class GreatWizard extends Wizard{
	protected int shield;

	public GreatWizard(String name, int hp, int mp, int shield) {
		super(name, hp, mp);
		this.shield = shield;
	}

	@Override
	public void energeVolt() {
		System.out.printf("%s 의 에너지볼트 ! ( 대마법사 버프로 데미지 +30 추가)", name);
	}

	@Override
	public String toString() {
		return String.format("[대마법사] %s ( HP : %d , MP : %d , SHIELD : %d )", name, hp, mp, shield);
	}
}
