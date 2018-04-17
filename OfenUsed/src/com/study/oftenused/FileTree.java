package com.study.oftenused;

import java.io.File;

public class FileTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("g:/บฺยํสำฦต/");
		System.out.println(f.getName());
		tree (f, 1);
	}

	public static void tree(File f, int level) {
		String preStr = "";
		
		for (int i=0; i<level; i++) {
			preStr += " ";
		}
		
		File[] childs = f.listFiles();
		for (int i=0; i<childs.length; i++) {
			System.out.println(preStr + childs[i].getName());
			if (childs[i].isDirectory()) {
				tree (childs[i], level+1);
			}
		}
	}
}
