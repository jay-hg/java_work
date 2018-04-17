package com.study.gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class KeyTest extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new KeyTest();
	}

	public KeyTest() {
		setTitle("key test...");
		setLayout(null);
		setBounds(300,200,500,500);
		setVisible(true);
		
		addKeyListener (new KT());
	}
	
	class KT extends KeyAdapter {
		public void keyPressed(KeyEvent e)  {
			if (e.getKeyCode() == KeyEvent.VK_B) {
				System.out.println("∞¥œ¬¡Àb");
			}
		}
	}
}
