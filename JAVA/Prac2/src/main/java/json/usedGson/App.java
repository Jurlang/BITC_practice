package json.usedGson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;

public class App {
	public static void main(String[] args) {
		Gson gson = new Gson();

		Employee emp = new Employee(123, "길동", "abcd@abcd.com");
		String class_To_json = gson.toJson(emp);
		System.out.println(class_To_json);

		String json_To_class = "{\"id\":123,\"name\":\"길동\",\"email\":\"abcd@abcd.com\"}";
		Employee emp2 = gson.fromJson(json_To_class, Employee.class);
		System.out.println(emp2);

		List<Employee> empArr = Arrays.asList(emp, emp2);
		String list_To_json = gson.toJson(empArr);
		System.out.println(list_To_json);

		String json_To_list = "[{\"id\":123,\"name\":\"길동\",\"email\":\"abcd@abcd.com\"},{\"id\":123,\"name\":\"길동\",\"email\":\"abcd@abcd.com\"}]";
		List<Employee> list = gson.fromJson(json_To_list, new TypeToken<List<Employee>>(){}.getType());
		System.out.println(list);
	}
}
