package com.study;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		try
		{
			File f2=new File("G:/我的日记","file_study.txt");
			FileInputStream fr=new FileInputStream(f2);
			if (!f2.exists())
				f2.createNewFile();
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
