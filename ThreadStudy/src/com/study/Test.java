package com.study;

public class Test
{
	
	 /* 主方法
	 * 定义两条线程，观察同步运行
	 * @param args
	 */
	public static void main(String[] args)
	{
		Runnable r1=new Counter();
		Runnable r2=new Counter();
		
		Thread user1=new Thread(r1,"用户甲");
		Thread user2=new Thread(r2,"用户乙");
		
		user1.start();
		user2.start();
	}
}

class Counter implements Runnable
{
	private String user=null;
	
	public String getUser()
	{
		return user;
	}
	
	public void setUser(String name)
	{
		user=name;
	}
	@Override
	public void run()
	{ 
		int money=5000;
		while (true)
		{
			synchronized(this)
			{
				money=money-100;
				System.out.println("从账户取出100,账户剩余"+money);
				if (money==0)
					return;
				try
				{
					Thread.sleep(1);
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				
			}
		}
	}
}
/**
 * 
 */
	