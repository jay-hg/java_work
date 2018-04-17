package Main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//显示主界面，响应按钮事件
public class View extends JFrame{
//创建窗口、文本框、按钮、相应面板
	static int width=400;
	static int heigth=300;
	int count=18;
	
	JFrame jf = new JFrame("计算器");
	Container c = jf.getContentPane();
	Action aB[] = new Action[count];
	
	public static JTextField jt = new JTextField(20);
	JButton jb[] = new JButton[count];
	JPanel numPanel = new JPanel(new GridLayout(4,3,3,3));
	JPanel sidePanel = new JPanel(new GridLayout(3,2,3,3));
	JPanel textPanel = new JPanel();
	
	public View()
	{
		for (int i=0;i<10;i++)
		{
			jb[i] = new JButton(""+i);
			jb[i].setName("i");
		}
		jb[10]=new JButton("+");
		jb[11]=new JButton("-");
		jb[12]=new JButton("*");
		jb[13]=new JButton("/");
		jb[14]=new JButton(".");
		jb[15]=new JButton("=");
		jb[16]=new JButton("AC");
		jb[17]=new JButton("Back_Space");
		
		jb[10].setName("Add");
		jb[11].setName("Sub");
		jb[12].setName("Mul");
		jb[13].setName("Div");
		jb[14].setName("Point");
		jb[15].setName("Equal");
		jb[16].setName("AC");
		jb[17].setName("Back_Space");

	//添加相应事件
		for (int i=0;i<count;i++)
		{
			aB[i]=new Action(jb[i].getText(),jb[i].getName());
			jb[i].addActionListener(aB[i]);
		}
	//布置界面
		textPanel.add(jt);
		
		for (int i=9;i>0;i--)
		{
			numPanel.add(jb[i]);
		}
		numPanel.add(jb[14]);
		numPanel.add(jb[0]);
		numPanel.add(jb[15]);
		
		sidePanel.add(jb[10]);
		sidePanel.add(jb[11]);
		sidePanel.add(jb[12]);
		sidePanel.add(jb[13]);
		sidePanel.add(jb[16]);
		sidePanel.add(jb[17]);
		
		c.add(textPanel,BorderLayout.NORTH);
		c.add(numPanel,BorderLayout.CENTER);
		c.add(sidePanel,BorderLayout.EAST);
	//最后相应设置
		jf.setSize(width, heigth);
		jf.setVisible(true);
	}
	
	//写一个设置jt内容的方法，为需要者所用
	public static void Show(String toShow)
	{
		jt.setText(toShow);
	}
	
}
