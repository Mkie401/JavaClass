package com.ispan.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


import com.ispan.apis.Student;

public class Hole54 {

	public static void main(String[] args) {
		Student s1 = new Student("mike", 60, 88, 75);
		System.out.println(s1);
		try(
			ObjectOutputStream oout = new ObjectOutputStream(
				new FileOutputStream("dir1/s1.txt"))
			) {
			oout.writeObject(s1);
			System.out.println("save ok");
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
