package com.ispan.tutor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Hole59 {

	public static void main(String[] args) {
		// 在埠號8888 接收封包
		
			byte[] buf = new byte[1024];
			try (DatagramSocket socket = new DatagramSocket(8888);){
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				
				byte[] data = packet.getData();
				int len = packet.getLength();
				InetAddress urip = packet.getAddress();
				String mesg = new String(data,0, len);
				System.out.printf("%s : %s\n", urip.getHostAddress(), mesg);
				System.out.println("ok");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}


