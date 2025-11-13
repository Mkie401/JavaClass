package com.ispan.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Hole57 {

	public static void main(String[] args) {
	try {
		InetAddress ip = InetAddress.getByName("192.168.1.10");
		System.out.println(ip.getHostAddress());
	} catch (UnknownHostException e) {
		System.out.println(e);
	}
	}

}
