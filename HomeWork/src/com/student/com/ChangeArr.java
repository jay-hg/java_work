package com.student.co  m;

import java.util.Arrays;

public class ChangeArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int example[]={8,6,47,2,58,6,4,8,6,1};
		System.out.println("之前数组：");
		for (int i=0;i<example.length;i++)
		{
			System.out.print(example[i]+" ");
		}
		
		System.out.println();
		
		int newArr[]=(new ChangeArr()).arrChange(example);
		System.out.println("交换后的数组：");
		for (int i=0;i<newArr.length;i++)
		{
			System.out.print(newArr[i]+" ");
		}
		
	}
	
	public int[] arrChange(int[] arr)
	{
		int Max=arr[0],Min=arr[0];
		int MaxIndex=0,MinIndex=0;
		
		for (int i=0;i<arr.length;i++)
		{
			if (Max <=arr[i])
			{
				Max=arr[i];
				MaxIndex=i;
			}
			
			if (Min >= arr[i])
			{
				Min=arr[i];
				MinIndex=i;
			}
			
			int temp=arr[0];
			arr[0]=Max;
			arr[MaxIndex]=temp;
			
			temp=arr[arr.length-1];
			arr[arr.length-1]=Min;
			arr[MinIndex]=temp;
			
		}
		return arr;
	}

}
