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
		this.setTitle("��ѡ������");
		this.setBounds(100, 100, 409, 331);
		this.setLayout(new GridLayout(0,4));
		Container c=this.getContentPane();
		
		String[] labels = { "����", "����", "ħ��", "ƹ����", "����Ӱ", "ħ������", "CSս��",
                "��ë��", "��Ӿ", "����", "��ɽ", "����", "д����", "��������", "����", "������",
                "����ֽ", "쭳�", "���", "���̳�", "�齫", "����", "����������", "����", "����",
                "����", "����", "����" };
		JCheckBox cbox[]=new JCheckBox[labels.length];
		for (int i=0;i<labels.length;i++)
		{
			cbox[i]=new JCheckBox(labels[i]);
			c.add(cbox[i]);
		}
		
	}
}
