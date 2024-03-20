package Prac_Class;
/*
Miner 클래스를 만들어 출력 결과를 얻으세요.
*/
public class C_03 {
	public static void main(String[] args) {
		Miner malon = new Miner("말런");
		Miner gloria = new Miner("글로리아");

		malon.mine();
		malon.mine();
		malon.mine();
		gloria.mine();
		gloria.mine();

		System.out.println(malon.toString());
		System.out.println(gloria.toString());

	}
}

class Miner{
	String name;
	int coins;

	Miner(String name){
		this.name = name;
		this.coins = 0;
	}

	public String toString(){
		return String.format("Miner { name : %s , coins : %d }", name, coins);
	}

	public void mine(){
		coins += 1;
	}
}