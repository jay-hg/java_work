package study.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		byte[] byt=new byte[1024];
		byt="Hello world!".getBytes();
		DatagramPacket dp = new DatagramPacket(byt,byt.length,
				new InetSocketAddress("127.0.0.1",8888));
		DatagramSocket ds=new DatagramSocket(9999);
		ds.send(dp);
		ds.close();

	}

}
