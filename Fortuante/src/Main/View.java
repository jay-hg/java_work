package Main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View {
	JFrame jf=new JFrame("抽取幸运观众");
	Container c=jf.getContentPane();
	
	public JButton jb=new JButton("抽取");
	public JButton jb2=new JButton("退出");
	public JLabel jla1=new JLabel("输入在场观众姓名按回车");
	public static JLabel jla2=new JLabel("选取观众人员：");
	public static JTextField jt=new JTextField(800);
	public JTextArea jta=new JTextArea();
	//String names[]={"关羽","张飞","赵云","黄忠","马超","关羽","张飞","赵云","黄忠","马超","关羽","张飞","赵云","黄忠","马超","关羽","张飞","赵云","黄忠","马超"};
	JList jl=new JList();
	String name[]=new String[3];
	String temp[]=new String[3];
	
	JScrollPane js=new JScrollPane(jl);
	
	public void do_textPressed_down(KeyEvent e)
	{
		System.out.println("dsfwagrea");
	}
	public View()
	{
		jf.setLayout(null);
		jf.setSize(1000,600);
		
		
		jt.addKeyListener(new KeyAdapter(){
			@Override
            public void keyPressed(KeyEvent e)
            {
				if (e.getKeyChar()=='\n')
				{
					String s=jt.getText();
					if (s==null)
						return;
					if (name[name.length-1] != null)
					{
						temp=name;
						name=new String[2*name.length];
						for (int i=0;i<temp.length;i++)
						{
							name[i]=temp[i];
						}
					}
					for (int i=0;i<name.length;i++)
					{
						if (name[i]==null)
						{
						name[i]=s;
						break;
						}
					}
					jl.setListData(name);
					jt.selectAll();
				}
				
            }
		});
		c.add(jb);
		jb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int r=0;
				for (int i=0;i<name.length;i++)
				{
					if (name[i] != null)
						r=i+1;
				}
				r=(int)(r*Math.random());
				if (name[r]==null)
					return;
				else
				jta.setText("恭喜"+name[r]+"成为幸运观众，他将获得过期酸奶一箱");
			}
		});
		c.add(jb2);
		c.add(jt);
		c.add(jla1);
		c.add(jla2);
		c.add(jta);
		c.add(js);
		
		jla1.setBounds(30, 50, 200, 30);
		jt.setBounds(30, 100, 200, 30);
		js.setBounds(30, 160, 200, 350);
		jb.setBounds(800, 400, 100, 30);
		jb2.setBounds(800, 460, 100, 30);
		jla2.setBounds(300, 50, 400, 30);
		jta.setBounds(300, 100, 400, 410);
		jf.setVisible(true);
	}

}
