package com.study.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AwtWindow extends JFrame implements ActionListener{

	JPanel jp;
	
	AwtWindow(String title, int x, int y, int width, int height, Color color) {
		setLayout(null);
		setBounds(x, y, width, height);
		setBackground(color);
		setTitle(title);
		
		jp = new JPanel();
		jp.setBounds(width/4, height/4, width/2, height/2);
		jp.setBackground(new Color(255,255,255));
		
		JButton jb = new JButton("press me");
		jb.addActionListener(this);
		
		add(jp);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AwtWindow("我的小窗口",
				200,200,500,300,
				new Color(0,0,0));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillRect(300, 250, 80, 100);
		g.setColor(c);
	}
}
