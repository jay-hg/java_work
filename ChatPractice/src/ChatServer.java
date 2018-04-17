import java.net.*;
import java.io.*;

public class ChatServer {
	
	ServerSocket ss;
	
	public static void main(String[] args) {
		new ChatServer().start();
	}

	public void start() {
		try {
			ss = new ServerSocket(8888);
		} catch (BindException e) {
			System.out.println("端口被占用");
			System.out.println("请关闭相关程序再重启此程序");
			System.exit(0);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			while (true) {
				Socket s = ss.accept();
				Client c = new Client(s);
				new Thread(c).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class Client implements Runnable {
		
		Socket s = null;
		DataInputStream dis = null;
		
		public Client(Socket s) {
			this.s = s;
System.out.println("a client connected!");
			try {
				dis = new DataInputStream(s.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			String str;
			try {
				while (true) {
					str = dis.readUTF();
					System.out.println(str);					
				}
			} catch (EOFException e) {
System.out.println("a client closed!");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (s != null)
					s.close();
					if (dis != null) dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
