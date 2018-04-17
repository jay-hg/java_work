package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("202.108.22.5",80);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		pw.println("GET / HTTP/1.1");
		pw.println("Host: www.fzu.cn");
		pw.println("Content-Type: text/html");
		pw.println();
		pw.flush();
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = "";
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		
		br.close();
		pw.close();
		s.close();
	}
}