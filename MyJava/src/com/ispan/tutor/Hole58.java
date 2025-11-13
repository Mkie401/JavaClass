package com.ispan.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Hole58 {

	public static void main(String[] args) {
		String mesg = "Hello World";
		byte[] data = mesg.getBytes();
		try (DatagramSocket socket = new DatagramSocket();) {
			DatagramPacket packet = new DatagramPacket(data, data.length, 
				InetAddress.getByName("10.0.103.194"),8888);
				socket.send(packet);
				System.out.println("send ok");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
