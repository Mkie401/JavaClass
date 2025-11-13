package com.ispan.tutor;

import java.util.HashSet;
import java.util.Set;

public class Hole35 {
	public static void main(String[] args) {
		Set set = new HashSet();
		System.out.println(set.size());
		set.add(123);
		set.add(12.3);
		set.add("Hole");
		set.add(123);
		System.out.println(set.size());
		System.out.println(set);
	}

}
