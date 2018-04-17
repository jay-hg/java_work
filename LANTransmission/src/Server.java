import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	int ssPort = 8888; 
	int udpPort = 6666;
	
	boolean end = false;

	DatagramSocket ds;
	TcpCommunity tc;
	public static void main(String[] args) throws IOException {
		new Server().launch();
	}

	public void launch() throws IOException {
		ServerSocket ss = new ServerSocket(ssPort);
		Socket s = ss.accept();
		//System.out.println("a client conn");
		
		DataInputStream dis = new DataInputStream(s.getInputStream());
		//System.out.println(dis.readUTF());
		
		byte[] bye = new byte[1024];
		ds = new DatagramSocket(udpPort);
		DatagramPacket dp = new DatagramPacket(bye,bye.length);
		//ds.receive(dp);
		//String str = new String(bye); 
		
		//System.out.println(str);
		File f = new File("F:/局域网传输接收盘/","abc.txt");
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(f));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
		tc = new TcpCommunity(dis);
		new Thread(tc).start();
		
		while (!end) {
			ds.receive(dp);
			//str = new String(bye); 
			//System.out.println(str);

			bw.write(new String(bye));
			bw.flush();
			//System.out.println("aaa");
		}
		
		//System.out.println(new String(bye));
	}
	
	class TcpCommunity implements Runnable{

		DataInputStream dis;
		
		public TcpCommunity(DataInputStream dis) {
			this.dis = dis;
		}
		
		@Override
		public void run() {
			try {
				while (true) {
					int i = dis.readInt();
					if (i == 1) {
						Server.this.end = true;
						System.out.println("ccc");
						Thread.sleep(100);
						//ds.close();
						return;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}


