package com.ispan.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Hole45 {

	public static void main(String[] args) {
		String mesg = "Hello World\n";
		try {
			FileOutputStream fout = new FileOutputStream("dir1/file.txt", true);
			fout.write(mesg.getBytes());
			fout.close();
			System.out.println("ok");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
