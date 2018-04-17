package com.student.com;

public class Jiecheng {
	public static void main(String[] args)
	{
		long sum=0;
		
		for (int i=1;i<=20;i++)
		{
			long x=1;
			for (int j=1;j<=i;j++)
			{
				if (j>1)
					x *= (j-1);
			}
			sum += x;
		}
		System.out.println("原式的值为"+sum);
	}

}
