package com.ispan.tutor;

import java.io.File;
import java.io.IOException;

public class Hole43 {

	public static void main(String[] args) {
		File file = new File("d:\\test2");
		if (file.exists()) {
			System.out.println("ok");
		}else {
			System.out.println("x");
			try {
				file.createNewFile();
				System.out.println("create ok");
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

}
