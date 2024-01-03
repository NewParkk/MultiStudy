package controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import user.dto.User;

public class AsyncTest {
	public static void main(String[] args) {
		// name: dev, age 28
		// {"name":"dev", "age":28}
		JSONObject jo1 = new JSONObject("{\"name\" : \"dev\", \"age\":28}");
		System.out.println(jo1);
		
		JSONObject jo2 = new JSONObject();
		jo2.put("name", "dev");
		jo2.put("age", 28);
		System.out.println(jo2.get("age"));
		
		
		
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "dev");
		map3.put("age", 28);
		
		JSONObject jo3 = new JSONObject(map3);
		System.out.println(jo3);
		
		
		//
		User user = new User(jo3.getString("name"), jo3.getInt("age"));
		System.out.println(user);
		
		// JSONArray
		JSONArray ja1 = new JSONArray();
		ja1.put("Servlet");
		ja1.put("JSP");

		JSONObject joa1 = new JSONObject();
		joa1.put("name", "dev");
		joa1.put("age", 28);
		joa1.put("skills", ja1);
		
		System.out.println(joa1);
		
		
		
		
		
	}
}