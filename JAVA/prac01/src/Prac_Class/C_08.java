package Prac_Class;
/*
요구사항
클래스 : 영웅
필드 : 이름, 체력
메소드 : 펀치
*/
public class C_08 {
	public static void main(String[] args) {
		Hero arthas = new Hero("아서스");
		Hero leona = new Hero("레오나");

		Hero.battle(arthas, leona);
	}
}

class Hero{
	String name;
	int hp;

	public Hero(String name){
		this.name = name;
		this.hp = 30;
	}

	public void punch(Hero enemy){
		int damage = (int)(Math.random() * 10 +1);
		enemy.hp -= damage;
		System.out.printf("[ %s ]의 펀치 : %d \t ", this.name, damage);
	}

	public static void battle(Hero a, Hero b){
		boolean firstAttack = true;

		while(a.hp > 0 && b.hp > 0){
			if(firstAttack){
				a.punch(b);
				if(b.hp <= 0){
					System.out.printf("%s : %d / 30\n", b.name, b.hp);
					System.out.printf("%s 의 패배 입니다.\n", b.name);
				}
				else{
					System.out.printf("%s : %d / 30\n", b.name, b.hp);
				}
			}else{
				b.punch(a);
				if(a.hp <= 0){
					System.out.printf("%s : %d / 30\n", a.name, a.hp);
					System.out.printf("%s 의 패배 입니다.\n", a.name);
				}
				else{
					System.out.printf("%s : %d / 30\n", a.name, a.hp);
				}
			}
			firstAttack = !firstAttack;
		}
	}
}