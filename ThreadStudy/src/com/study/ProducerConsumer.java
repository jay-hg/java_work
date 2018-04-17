package com.study;

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Basket basket=new Basket();
		new Thread(new Producer(basket)).start();
		new Thread(new Consumer(basket)).start();

	}

}

class Buns
{
	private int ID;
	
	public Buns(int ID)
	{
		this.ID=ID;
	}
	
	@Override
	public String toString()
	{
		return ID+"�Ű���";
	}
}

class Basket
{
	public final static int MAX=6;
	private Buns[] arrBuns=new Buns[MAX];
	private int Index=0;
	
	public synchronized void push(Buns buns)
	{
		while (Index==arrBuns.length)
		{
			try 
			{
				this.wait();
			}catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.notifyAll();
		arrBuns[Index]=buns;
		System.out.println("������"+buns+"������"+(1+Index)+"������");
		Index++;
	}
	
	public synchronized Buns pop()
	{
		while (Index==0)
		{
			try 
			{
				this.wait();
			}catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		this.notifyAll();
		Index--;
		System.out.println("������"+arrBuns[Index]+"������"+Index+"������");
		return arrBuns[Index];
	}
}

class Producer implements Runnable
{
	private Basket basket;
	
	public Producer(Basket basket)
	{
		this.basket=basket;
	}
	
	public void run()
	{
		for (int i=1;i<=20;i++)
		{
			Buns buns=new Buns(i);
			basket.push(buns);
		}
	}
}

class Consumer implements Runnable
{
	private Basket basket;
	
	public Consumer(Basket basket)
	{
		this.basket=basket;
	}
	
	public void run()
	{
		for (int i=1;i<=20;i++)
		{
			Buns buns=basket.pop();
		}
	}
}