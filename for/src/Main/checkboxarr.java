package Main;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class checkboxarr extends JFrame{
	
	public static void main(String[] args)
	{
		checkboxarr cha=new checkboxarr();
		cha.setVisible(true);
	}

	public checkboxarr()
	{
		this.setTitle("复选框数组");
		this.setBounds(100, 100, 409, 331);
		this.setLayout(new GridLayout(0,4));
		Container c=this.getContentPane();
		
		String[] labels = { "足球", "篮球", "魔术", "乒乓球", "看电影", "魔兽世界", "CS战队",
                "羽毛球", "游泳", "旅游", "爬山", "唱歌", "写博客", "动物世界", "拍照", "弹吉他",
                "读报纸", "飙车", "逛街", "逛商场", "麻将", "看书", "上网看资料", "新闻", "军事",
                "八卦", "养生", "饮茶" };
		JCheckBox cbox[]=new JCheckBox[labels.length];
		for (int i=0;i<labels.length;i++)
		{
			cbox[i]=new JCheckBox(labels[i]);
			c.add(cbox[i]);
		}
		
	}
}
