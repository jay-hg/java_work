package com.study;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	public static void main(String[] args)
	{
		File file = new File("c:/","hello.txt");
		file.exists();
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file.delete();
		try {
			FileReader fw=new FileReader(file);
			fw.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileInputStream fi=new FileInputStream(file);
		BufferedInputStream fbs = new BufferedInputStream(fi);
		fbs.read();
		
		BufferedOutputStream bos =new BufferedOutputStream();
		
		BufferedReader br=new BufferedReader();
		br.readLine();
		
		BufferedWriter bw=new BufferedWriter();
		bw.wait();
		
		public synchronized void abc(){}
	}

}
