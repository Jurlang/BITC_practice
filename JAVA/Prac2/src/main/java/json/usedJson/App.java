package json.usedJson;

import json.usedGson.Employee;
import org.json.JSONArray;
import org.json.JSONObject;

public class App {
	public static void main(String[] args) {
		JSONObject jo = new JSONObject();
		jo.put("id", 1234);
		jo.put("name", "길동");
		jo.put("email", "1234@1234.com");
		System.out.println(jo);

		Employee emp = new Employee(1234,"길동","1234@1234.com");
		JSONObject class_TO_json = new JSONObject(emp); // getter setter 가 있어야함.
		System.out.println(class_TO_json);

		Employee emp1 = new Employee(1234,"길동","1234@1234.com");
		Employee emp2 = new Employee(1235,"헹수","1235@1235.com");

		JSONObject jo1 = new JSONObject(emp1);
		JSONObject jo2 = new JSONObject(emp2);

		JSONArray empArr = new JSONArray();
		empArr.put(jo1);
		empArr.put(jo2);

		JSONObject obj = new JSONObject();
		obj.put("employees", empArr);

		System.out.println(obj.toString(2));
	}
}
