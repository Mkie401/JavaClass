package com.ispan.tutor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Hole65 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://s.yimg.com/ny/api/res/1.2/QhVitzoeyuZgy5TBO_.5xg--/YXBwaWQ9aGlnaGxhbmRlcjt3PTk2MDtoPTYxMztjZj13ZWJw/https://media.zenfs.com/ko/nownews.com/813846ddf407a00b24173661097bf8b2");
			URLConnection conn = url.openConnection();
			
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			byte[] data = bin.readAllBytes();
			bin.close();
			
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("dir1/5.jpg"));
			bout.write(data);
			bout.flush();
			bout.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
