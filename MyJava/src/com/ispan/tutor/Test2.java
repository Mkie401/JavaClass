package com.ispan.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Test2 {

	public static void main(String[] args) {
		byte[] buf = new byte[2048]; // 設定信箱
		while (true) {
			try (DatagramSocket socket = new DatagramSocket(8888);){
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				System.out.println("wait");
				socket.receive(packet);
				System.out.println("receive ok");
				
				byte[] data = packet.getData();
				int len = packet.getLength();
				String mesg = new String(data, 0, len);
				System.out.println(mesg);
			if (mesg.equals("end")) {
					System.out.println("測試結束");
					break;
				}}catch (Exception e) {
				System.out.println(e);
			}}}}

	


