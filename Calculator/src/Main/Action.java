package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

//��Ϊ��Ӧ�¼�
public class Action implements ActionListener{
//��Ա count�Ķ���io�Ķ��󡢰�ť���ƺ��ı�
	static Count count = new Count();
	static IO io = new IO();
	String jbName;
	String jbText;
	
	public Action(String text,String name)
	{
		jbText = text;
		jbName = name;
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		if (jbName.equals("Add"))
		{
			View.Show(io.toShowIn(jbText));
			count.ResponseSympol(jbName);
		}
		else if (jbName.equals("Sub"))
		{
			View.Show(io.toShowIn(jbText));
			count.ResponseSympol(jbName);
		}
		else if (jbName.equals("Mul"))
		{
			View.Show(io.toShowIn(jbText));
			count.ResponseSympol(jbName);
		}
		else if (jbName.equals("Div"))
		{
			View.Show(io.toShowIn(jbText));
			count.ResponseSympol(jbName);
		}
		else if (jbName.equals("Point"))
		{
			JOptionPane.showMessageDialog(null, "�Բ����ݲ�֧��С������");
		}
		else if (jbName.equals("Equal"))
		{
			io.Num=count.compute();
			View.Show(io.toShowOut());
			io.Initialization();
		}
		else if (jbName.equals("AC"))
		{
			io.Initialization();
			
			View.Show(io.toText);
		}
		else if (jbName.equals("Back_Space"))
		{
			io.Back_Space();
			View.Show(io.toText);
			count.NumInitialization();
		}
		else 
		{
			View.Show(io.toShowIn(jbText));
			io.forCount(jbText);
			count.firstNum = io.InputNum();
		}
	}
}
