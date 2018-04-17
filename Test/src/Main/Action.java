package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Action implements ActionListener{
	int beg=0;
	int end=0;
	public void actionPerformed(ActionEvent arg0)
	{
		String str=View.jt.getText();
		str=str.trim();
		String[] StrNum=str.split("\\s{1,}");
		int Num[]=new int[StrNum.length];
		int Min;
		for (int i=0;i<StrNum.length;i++)
		{
			Num[i]=Integer.valueOf(StrNum[i]);
		}
		Min=Num[0];
		for (int i=0;i<Num.length;i++)
		{
			
			if (Min>Num[i])
			{
				Min=Num[i];
			}
		}
		View.jla2.setText("最小值是："+Min);
	}

}
