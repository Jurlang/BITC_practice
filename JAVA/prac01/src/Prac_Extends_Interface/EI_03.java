package Prac_Extends_Interface;
/*
본문의 출력 결과를 보고 아래의 코드를 수정하시오
- 각국 통화 화폐
 */
public class EI_03 {
	public static void main(String[] args) {
		KRW krw = new KRW(1500, "원");
		USD usd = new USD(100.50, "달러");
		EUR eur = new EUR(260.87, "유로");
		JPY jpy = new JPY(1400, "엔");

		Currency[] currencies = {krw, usd, eur, jpy};

		for(Currency c : currencies){
			System.out.println(c.toString());
		}
	}
}

class Currency{
	private double amount;
	private String notation;

	Currency(double amount, String notation){
		this.amount = amount;
		this.notation = notation;
	}
	public String toString(){
		return String.format(getClass().getSimpleName() + " : %.2f %s", amount, notation);
	}
}

class KRW extends Currency {
	KRW( double amount, String notation) {
		super(amount, notation);
	}
}

class USD extends Currency {
	USD( double amount, String notation) {
		super(amount, notation);
	}
}

class EUR extends Currency {
	EUR( double amount, String notation) {
		super(amount, notation);
	}
}

class JPY extends Currency{
	JPY( double amount, String notation){
		super(amount, notation);
	}
}