package Prac_Class;
/*
* 아이템 정보를 적어넣고,
* 그 아이템들을 배열에 넣어
* 정보들을 출력한다.
*/
public class C_05 {
	public static void main(String[] args) {
		Item storm = new Item("스톰 브레이커", 600);
		Item gauntlet = new Item("인피니티 건틀렛", 999);
		Item bow = new Item("호크아이의 활", 50);
		Item shield = new Item("캡틴아메리카의 방패", 50);

		Item[] items = { storm, gauntlet, bow, shield };

		for(int i = 0; i < items.length ; i++){
			System.out.println(items[i].toString());
		}
	}
}

class Item{
	String name;
	int power;

	Item(String name, int power){
		this.name = name;
		this.power = power;
	}

	public String toString(){
		return String.format("Item { name : %s , power : %d }", name, power);
	}
}
