package Main;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class View extends JFrame{
	JFrame jf=new JFrame("����Сֵ");
	Container c=jf.getContentPane();
	
	public JButton jb=new JButton("����");
	public JLabel jla1=new JLabel("�����ı������������������Կո�Ϊ�ָ���");
	public static JLabel jla2=new JLabel();
	public static JTextField jt=new JTextField(800);
	
	public View()
	{
		jf.setLayout(null);
		jf.setSize(1000,300);
		
		jb.addActionListener(new Action());
		c.add(jb);
		c.add(jt);
		c.add(jla1);
		c.add(jla2);
		
		jla1.setBounds(30, 50, 800, 30);
		jt.setBounds(30, 100, 800, 30);
		jb.setBounds(30, 160, 100, 30);
		jla2.setBounds(150, 160, 500, 30);
		jf.setVisible(true);
	}
}
