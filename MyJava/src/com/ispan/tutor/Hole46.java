package com.ispan.tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Hole46 {

	public static void main(String[] args) {
		try {
			File file = new File("dir1/file.txt");
			FileInputStream fin = new FileInputStream(file);
//			int c1 = fin.read();
//			System.out.println(c1);
//			int c2 = fin.read();
//			System.out.println(c2);
		
			byte[] buf = new byte[(int) file.length()];
			fin.read(buf);
			System.out.println(new String(buf));
			
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("err1:" + e.toString());
		} catch (IOException e) {
			System.out.println("err2:" + e.toString());
		}

	}

}
