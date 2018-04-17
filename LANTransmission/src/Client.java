import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	String ip = "127.0.0.1";
	int serverPort = 8888;
	int serverUdpPort = 6666;

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Client().launch();
	}

	public void launch() throws UnknownHostException, IOException {
		Socket s = new Socket(ip,serverPort);
		//System.out.println("conn success");
		
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		//dos.writeUTF("hello server");
		
		byte[] bye = new byte[1024];
		//bye = "haha".getBytes();
		InetSocketAddress isa = new InetSocketAddress(ip,serverUdpPort);
		DatagramSocket ds = new DatagramSocket();
		DatagramPacket dp = new DatagramPacket(bye, bye.length, isa);
		//ds.send(dp);
		
		String parent = "C:/Users/hgfy/Desktop/";
		String name = "新建文本文档.txt";
		File f = new File(parent,name);
		String str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		while((str=br.readLine()) != null)  {
			dp = new DatagramPacket(str.getBytes(), str.getBytes().length, isa);
			ds.send(dp);
			System.out.println(str);
		}
		
		//bye = new byte[1024];
		//dp = new DatagramPacket(bye, bye.length, isa);
		//ds.send(dp);
		System.out.println("bbb");
		dos.writeInt(1);
	}
}
