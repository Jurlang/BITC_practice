package Prac_Class;
/*
주어진 코드로 a -> b 계좌 이체
main 메소드에서 매회 3천원씩 송금할 수 없을때까지 진행
*/
public class C_07 {
	public static void main(String[] args) {
		Account a = new Account("123-45", 10000);
		Account b = new Account("234-56", 10000);

		boolean result = true;
		while (result){
			result = a.transfer(b, 3000);
		}

		System.out.println(a.toString());
		System.out.println(b.toString());
	}
}
class Account{
	String num; // 계좌
	int balance; // 잔액

	public Account(String num, int balance){
		this.num = num;
		this.balance = balance;
	}

	public String toString(){
		return String.format("Account { num : %s , balance : %d }", num, balance);
	}

	public boolean transfer(Account target, int amount){
		if (balance < amount) return false;
		else {
			balance -= amount;
			target.balance += amount;
			return true;
		}
	}
}