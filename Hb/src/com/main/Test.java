package com.main;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Test extends JFrame
{
	private JLabel jl;
	private JLabel jl2;
	private JTextField jt;
	private JButton jb;
	private Container c;
	
	public static void main(String[] args)
	{
		Test t=new Test();
		t.setVisible(true);
	}
	public Test()
	{
		setTitle("�ж�����");
		setBounds(100,100,500,300);
		
		c=getContentPane();
		setLayout(null);
		
		jl=new JLabel("���������ֵ��");
		jl.setBounds(100, 100,100, 30);
		c.add(jl);
		
		jt=new JTextField(100);
		jt.setBounds(200,100,100,30);
		c.add(jt);
		
		jl2=new JLabel("Ԫ");
		jl2.setBounds(300,100,50,30);
		c.add(jl2);
		
		jb=new JButton("�ж�");
		jb.setBounds(200,200,100,30);
		c.add(jb);
		jb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String s=jt.getText();
				String num="[0-9]+";
				if (s.matches(num))
					JOptionPane.showMessageDialog(null, 
							"�������ֵ��ȷ��", 
							"", 
							JOptionPane.ERROR_MESSAGE);
				else 
				{
					
					JOptionPane.showMessageDialog(null, 
							"�������ֵ����", 
							"ע��", 
							JOptionPane.ERROR_MESSAGE);
					jt.setText("");
				}
			}
		});
	}
	

}
