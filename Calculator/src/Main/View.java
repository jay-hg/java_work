package Main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//��ʾ�����棬��Ӧ��ť�¼�
public class View extends JFrame{
//�������ڡ��ı��򡢰�ť����Ӧ���
	static int width=400;
	static int heigth=300;
	int count=18;
	
	JFrame jf = new JFrame("������");
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

	//�����Ӧ�¼�
		for (int i=0;i<count;i++)
		{
			aB[i]=new Action(jb[i].getText(),jb[i].getName());
			jb[i].addActionListener(aB[i]);
		}
	//���ý���
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
	//�����Ӧ����
		jf.setSize(width, heigth);
		jf.setVisible(true);
	}
	
	//дһ������jt���ݵķ�����Ϊ��Ҫ������
	public static void Show(String toShow)
	{
		jt.setText(toShow);
	}
	
}
