package com.ispan.tutor;

public class Hole31 {

	public static void main(String[] args) {
		//Hole311 hole = new Hole311("Hole");
		//hole.setCh(90).setEng(54).setMath(30);
		//System.out.println(hole.score());

	}
class Hole311 {
	private String name;
	private int ch, eng, math;
	
	Hole311(String name){
		this.name =name;
	}
	
	public String getName() {
		return name;
	}
	public Hole311 setName(String name) {
		this.name = name;
		return this;
	}
	public int getCh() {
		return ch;
	}
	public Hole311 setCh(int ch) {
		this.ch = ch;
		return this;
	}
	public int getEng() {
		return eng;
	}
	public Hole311 setEng(int eng) {
		this.eng = eng;
		return this;
	}
	public int getMath() {
		return math;
	}
	public Hole311 setMath(int math) {
		this.math = math;
		return this;
	}
//	public int score() {
//		
//	}
	
}
}
