
package com.ispan.tutor;

import java.util.HashMap;
import java.util.Set;

public class Hole39 {

	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap();
		person.put("name", "Hole");
		person.put("gender", true);
		person.put("age", 18);
		person.put("w", 80.4);
		//person.put("bike", new Bike());
		System.out.println(person.get("name"));
		System.out.println("-------------");
		
		Set<String> keys = person.keySet();
		for (String key : keys) {
			System.out.println(key + ":" + person.get(key));
		}
	}

}
