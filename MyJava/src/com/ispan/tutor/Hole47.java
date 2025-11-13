package com.ispan.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Hole47 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/file.txt");
//			int c1 = fin.read();
//			System.out.println(c1);
//			int c2 = fin.read();
//			System.out.println(c2);
		
			int c;
			while ( (c = fin.read()) != -1) {
				System.out.println((char)c);
			}
			
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("err1:" + e.toString());
		} catch (IOException e) {
			System.out.println("err2:" + e.toString());
		}

	}

}
