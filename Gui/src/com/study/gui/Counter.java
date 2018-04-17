package com.study.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Counter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TFrame().launcherFrame();
	}

}

class TFrame extends JFrame {
	
	JTextField number1 = new JTextField(10);
	JTextField number2 = new JTextField(10);
	JTextField number3 = new JTextField(15);
	JLabel labelAdd = new JLabel("+");
	JButton jbEqual = new JButton("=");
	
	public void launcherFrame() {
		setLayout(new FlowLayout());
		add(number1);
		add(labelAdd);
		add(number2);
		add(jbEqual);
		jbEqual.addActionListener(new Manger(this));
		add(number3);
		pack();
		setVisible(true);
	}

	
}

class Manger implements ActionListener {
	
	TFrame tf = null;
	
	public Manger (TFrame tf) {
		this.tf = tf;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int n1 = Integer.parseInt(tf.number1.getText().toString());
		int n2 = Integer.parseInt(tf.number2.getText().toString());
		tf.number3.setText(n1+n2+"");
		
	}
}