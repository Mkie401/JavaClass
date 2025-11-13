package com.ispan.tutor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Hole53 {

	public static void main(String[] args) {
		try(
				// 簡化的寫法
			BufferedReader br = new BufferedReader(
					new FileReader("dir1/trash.csv"));
			) {
			
			String line;
			while ( (line = br.readLine()) != null) {
				// 切成陣列
				String[] data = line.split(",");
				System.out.printf("%s : %s : %s : %s\n", data[0], data[1], data[2], data[8]);
			}
		}catch(Exception e) {
			System.out.println(e);
		}

	}

}
