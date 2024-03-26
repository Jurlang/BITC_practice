package ch07_JavaMoreSkill.JMS_am;

public class JMS_accessModifier_test{
	public static void main(String[] args) {
		JMS_accessModifier a = new JMS_accessModifier();
//		a.secret - 접근 불가 ( private )
		a.default_variable = "이것은 디폴트"; // - 접근 가능 ( default )
		a.protected_variable = "이것은 프로텍티드"; // - 접근 가능 ( protected )
	}
}

