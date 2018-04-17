package com.study.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

public class MousePoint extends JFrame {

	ArrayList<Point> points = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MousePoint();
	}

	public MousePoint() {
		points = new ArrayList<Point>(); 
		setTitle("drawing...");
		setLayout(null);
		setBounds(300,250,500,400);
		setVisible(true);
		this.addMouseListener(new ML());
	}
	
	public void paint (Graphics g) {
		Iterator i = points.iterator();
		Point p = new Point();
		g.setColor(Color.BLACK);
		for (;i.hasNext();) {
			p = (Point)i.next();
			g.fillOval(p.x, p.y, 10, 10);
		}
	}
	class ML extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			points.add(new Point(e.getX(), e.getY()));
			repaint();
		}
	}
}
