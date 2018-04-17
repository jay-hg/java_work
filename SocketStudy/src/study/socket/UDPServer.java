package study.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

	public static void main(String[] args) throws IOException {
		byte[] byt = new byte[1024];
		DatagramSocket ds = new DatagramSocket(8888);
		DatagramPacket dp = new DatagramPacket(byt,byt.length);
		while (true)
		{
			ds.receive(dp);
			System.out.println("收到包了");
			System.out.println(new String(byt,0,dp.getLength()));			
		}

	}

}
