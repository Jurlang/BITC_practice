package ch07_JavaMoreSkill.JMS_am_test;

import ch07_JavaMoreSkill.JMS_am.JMS_accessModifier;

public class JMS_accessModifier_test extends JMS_accessModifier{
	public static void main(String[] args) {
		JMS_accessModifier_test variable_test = new JMS_accessModifier_test();
//		default_test.default_variable = "이것은 안됨"; ( default 는 같은 패키지까지 )
		variable_test.protected_variable = "test"; // 상속 받은 클래스에서 사용가능 ( protected )
	}
}
