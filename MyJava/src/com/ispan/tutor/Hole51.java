package com.ispan.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Hole51 {

	public static void main(String[] args) {
		// 看需要多久
		long start = System.currentTimeMillis();
		// 自動關閉 小括號裡可以有多道敘述句
		try(
				FileInputStream fin = new FileInputStream("dir1/1.jpg");
				FileOutputStream fout = new FileOutputStream("dir3/1.jpg");
			) {
			
			int len; byte[] buf = new byte[4096];
			while ( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			
			System.out.println("ok:" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
