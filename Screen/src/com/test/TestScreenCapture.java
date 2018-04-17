package com.test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class TestScreenCapture extends JFrame{

	static File f;
	
	public static void main(String[] args) {
		String path = "G:/黑马视频/03阶段_马士兵_最新Oracle教程/笔记截图/";
		String name = "123.jpg";
		new TestScreenCapture();
		f = new File(path+name);

	}
	
	public TestScreenCapture() {
		setTitle("截图小工具");
		setLayout(null);
		setBounds(200,150,300,300);
		addKeyListener(new KL());
	}
	
	public static void ScreenCapture (b) {
		
		try {
			BufferedImage bi = (new Robot()).createScreenCapture(new Rectangle(0,0,1024,768));
			ImageIO.write(bi,"jpg",f);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class KL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == 'b') {
				ScreenCapture();
			}
		}
	}
}
