package com.ispan.apis;

import java.util.ArrayList;

public class Student1 {
	// 初始化 學號 學生名 分數
private int number;
private String name;
private int score;

public  Student1(int number, String name, int score) {
	this.number = number;
	this.name = name;
	this.score = score;
}
//建立一個可使用的物件
public void studentInfo() {
	System.out.println("學號: " + number + " 姓名: " + name + " 分數: " + score);
}

class StudentManager {
	ArrayList<Student1> stuList = new ArrayList<>();
	
	// 建立一個可使用的物件
	public void addStudent(Student1 s) {
		stuList.add(s);
	}
}
}
