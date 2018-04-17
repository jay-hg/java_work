package Main;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Sort extends JFrame{
	int width=1000;
	int height=600;
	public static JFrame jf=new JFrame("对输入数字进行排序：");
	Container c=jf.getContentPane();
	JPanel jp=new JPanel();
	JTextField jtf=new JTextField(3*width/4);
	JTextArea jta=new JTextArea();
	JButton jb=new JButton("排序");
	
	String text;
	String[] text_num;
	int num[];
	
	public Sort()
	{
		jf.setSize(width, height);
		
		jp.setBorder(new TitledBorder(null,"输入数组内容，空格为数组元素分隔符",
				TitledBorder.LEADING,TitledBorder.TOP,
				null, new Color(59, 59,59)));
		jp.setLayout(null);
		jp.add(jtf);
		jp.add(jta);
		jp.add(jb);
		
		jtf.setBounds(50, 80, 3*width/4, 30);
		
		jb.setBounds(450, 160, 100, 30);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				do_inputarr_sort();
			}
		});
		
		jta.setEditable(false);
		jta.setBounds(50, 220, 3*width/4, height/2);
		
		c.add(jp);
	}

	public static void main(String[] args)
	{
		jf.setVisible(true);
		new Sort();
	}
	
	public void do_inputarr_sort()
	{
		text=jtf.getText();
		text_num=text.split(" {1,}");
		
		num=new int[text_num.length];
		jta.setText("数组原有内容："+ "\n\t");
		for (int i=0;i<text_num.length;i++)
		{
			num[i]=Integer.valueOf(text_num[i]);
			jta.append(num[i]+" ");
		}
		jta.append("\n\t排序后数数组内容\n\t");
		String s1=text_num.toString();
		System.out.println(s1);
		Arrays.sort(num);
		System.out.println();
		for (int i=0;i<text_num.length;i++)
		{
			jta.append(num[i]+" ");
		}
		
	}
}
