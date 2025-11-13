package com.ispan.apis;

import java.util.ArrayList;

public class Studentmanager extends Student1{
public Studentmanager(int number, String name, int score) {
		super(number, name, score);
		// TODO Auto-generated constructor stub
	}
ArrayList<Student1> stuList = new ArrayList<>();
	
	// 建立一個可使用的物件
	public void addStudent(Student1 s) {
		stuList.add(s);
}
	public void showAll() {
		  for (Student1 s : stuList) {
	            s.studentInfo();
	        }
	}
}
