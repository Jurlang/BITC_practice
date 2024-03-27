package ch07_JavaMoreSkill.JMS_Exception;

class FoolException2 extends Exception{

}

public class ExceptionEX {
	public void sayNick(String nick){
		try {
			if ("바보".equals(nick))
				throw new FoolException2();
			System.out.println("당신의 별명은 " + nick + " 입니다.");
		} catch (FoolException2 e) {
			System.err.println("당신의 별명은 " + "에러발생" + " 입니다.");
		}
	}
	public static void main(String[] args) {
		ExceptionEX sample = new ExceptionEX();
		sample.sayNick("바보");
		sample.sayNick("야호");
	}
}
