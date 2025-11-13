package com.ispan.apis;

public class User {
	private int id;
	private String name;
	private boolean gender;
	private int age;
	
//	public User() {}
//	public User(int id, String name, boolean gender, int age) {}
	
	private User(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.gender = builder.gender;
		this.age = builder.age;
	}
	
	public static Builder builder(String name) {
		return new Builder(name);
	}
	
	public static class Builder {
		private int id;
		private final String name;
		private boolean gender;
		private int age;
		
		public Builder(String name) {this.name = name;}
		
		public Builder id(int id) {this.id = id; return this;}
		//public Builder name(String name) {this.name = name; return this;}
		public Builder gender(boolean gender) {this.gender = gender; return this;}
		public Builder age(int age) {this.age = age; return this;}
		
		public User build() {
			return new User(this);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
