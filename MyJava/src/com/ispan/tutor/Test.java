package com.ispan.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Test{
	
	public static void main(String[] args){
		
		String mesg = "end"; // 
		byte[] data = mesg.getBytes();
		try (DatagramSocket socket = new DatagramSocket();){
			DatagramPacket pocket = new DatagramPacket(data, data.length, 
					InetAddress.getByName("127.0.0.1"),8888);
			socket.send(pocket);
			System.out.println("send ok");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}