package study.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("�������Ѿ�������");
		ServerSocket ss = new ServerSocket(6666);
		while (true)
		{
			Socket s=ss.accept();
			System.out.println("A client connected!");
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("��ӭ����  Hagen World!");
			dos.flush();
			dos.close();
			s.close();
		}

	}

}
