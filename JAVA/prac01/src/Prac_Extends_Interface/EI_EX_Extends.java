package Prac_Extends_Interface;

/*
*********상속 예제
	. 클래스 연속 확장하기.
 */
public class EI_EX_Extends {
	public static void main(String[] args) {
		Elf elf = new Elf("티란데", 100);
		HighElf high = new HighElf("말퓨리온", 160, 100);
		ElfLord lord = new ElfLord("마이에브", 230, 140, 100);

		Elf[] elves = {elf, high, lord};
		for(Elf _elf : elves){
			System.out.println(_elf);
		}
	}
}

class Elf{
	String name;
	int hp;

	public Elf(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "Elf{" +"name='" + name + '\'' +", hp=" + hp +'}';
	}
}
class HighElf extends Elf{
	int mp;

	public HighElf(String name, int hp, int mp) {
		super(name, hp);
		this.mp = mp;
	}

	@Override
	public String toString() {
		return "HighElf{"+"mp=" + mp +", name='" + name + '\'' +", hp=" + hp +'}';
	}
}
class ElfLord extends HighElf{
	int shield;

	public ElfLord(String name, int hp, int mp, int shield) {
		super(name, hp, mp);
		this.shield = shield;
	}

	@Override
	public String toString() {
		return "ElfLord{" +"shield=" + shield +", mp=" + mp +", name='" + name + '\'' +", hp=" + hp +'}';
	}
}