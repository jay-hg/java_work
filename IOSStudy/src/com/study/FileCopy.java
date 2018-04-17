package com.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileCopy {

	public static void main(String[] args) {
		String fromName="C:/Users/hgfy/jh.java";
		String toName="D:/new.java";
		try{
			copy(fromName,toName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void copy(String fromName,String toName) throws IOException
	{
		File fromFile = new File(fromName);
		File toFile = new File(toName);
		FileInputStream fromStream = new FileInputStream(fromFile);
		FileOutputStream toStream = new FileOutputStream(toFile,true);
		
		InputStreamReader ins = new InputStreamReader(fromStream);
		OutputStreamWriter ous = new OutputStreamWriter(toStream);
		
		BufferedReader bin = new BufferedReader(ins);
		BufferedWriter bout = new BufferedWriter(ous);
		
		String sl;
		while ((sl=bin.readLine()) != null)
		{
			bout.write(sl);
			bout.newLine();
		}
		
		bin.close();
		bout.close();
		ous.close();
		ins.close();
		fromStream.close();
		toStream.close();
	}
}
