package com.ispan.tutor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class Hole74 {

	public static void main(String[] args) {
		Person person = new Person() {
			@Override
			public void speak() {
				System.out.println("123");
			}
		};
		person.speak();
		person.eat();
		sayhello();
	}
	@Hole741
	public static void sayhello() {
		System.out.println("Hello!!");
		
		Method[] ms = Hole74.class.getDeclaredMethods();
		for (Method m : ms) {
			System.out.println(m.getName());
			if(m.isAnnotationPresent(Hole741.class)) {
				Hole741 h741 = m.getAnnotation(Hole741.class);
				System.out.println(h741.values());
			}
		}
	}
}
interface Person {
	void speak();
	default void sleep() {System.out.println("Zzz...");}
	default void eat() {System.out.println("Zzz...");}
	default void eat(int a) {System.out.println("Zzz...");}
}

@Retention(RetentionPolicy.RUNTIME) // 執行時期生效 => 反射類別
@Target(ElementType.METHOD)         // 用在方法
@interface Hole741 {
	String values() default "hole741";
}