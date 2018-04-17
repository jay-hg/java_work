package study.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Socket s=new Socket("127.0.0.1",6666);
		Socket s2=new Socket("127.0.0.1",6666);
		DataInputStream dis = new DataInputStream(s.getInputStream());
		System.out.println(dis.readUTF());
		dis.close();
		s.close();
	}

}
