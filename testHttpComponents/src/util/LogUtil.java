package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LogUtil {
	static String fileName = "C:/Users/hgfy/Desktop/temp.txt";
	static String logFileName = "C:/Users/hgfy/Desktop/准考证号.txt";
	FileInputStream in = null;
	BufferedReader br = null;
	FileOutputStream out = null;
	BufferedWriter bw = null;
	public int params[] = new int[4];
	
	public void write() throws IOException {
		out = new FileOutputStream(fileName);
		bw = new BufferedWriter(new OutputStreamWriter(out));
		for(int i=0;i<4;i++) {
			bw.write(params[i]+"");	
			bw.newLine();
		}
		bw.flush();
		System.out.println("写入完成！");
	}
	
	public void read() throws NumberFormatException, IOException {
		in = new FileInputStream(fileName);
		br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		int i = 0;
		while((line = br.readLine()) != null) {
			//System.out.println(line);
			if(i<4) params[i] = Integer.parseInt(line);
			i++;
		}
	}
	
	public void log(String s) throws IOException {
		out = new FileOutputStream(logFileName,true);
		bw = new BufferedWriter(new OutputStreamWriter(out));
		bw.newLine();
		bw.write(s);
		bw.flush();
	}
	
	public void destroy() throws IOException {
		if(br != null) br.close();
		if(in != null) in.close();
		if(out != null) out.close();
		if(bw != null) bw.close();
	}
}
