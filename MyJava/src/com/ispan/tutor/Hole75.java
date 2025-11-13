package com.ispan.tutor;

import com.ispan.apis.User;

public class Hole75 {

	public static void main(String[] args) {
//		User user = new User();
//		user.setAge(0);
//		user.setName("Ass");
		
		User user = new User.Builder("tony")
				.id(1)
				.age(18)
				.gender(true)
				.build();
		
	}

}
