package com.study.test;

public class Date implements Comparable{

	private int year;
	private int month;
	private int day;
	
	public static void main(String[] args) {
		Date[] days = new Date[5];
		days[0] = new Date(2006, 5, 4);
		days[1] = new Date(2006, 7, 4);
		days[2] = new Date(2008, 5, 4);
		days[3] = new Date(2004, 5, 9);
		days[4] = new Date(2004, 5, 4);

		Server<Date> s = new Server<Date>();
		System.out.println("ÅÅĞòÇ°£º");
		s.print(days);
		
		System.out.println("ÅÅĞòºó£º");
		s.BubbleSort(days);
		s.print(days);
	}

	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	

	@Override
	public int compareTo(Object o) {
		Date d = (Date)o;
		if (this.year > d.year)
			return 1;
		else if (this.year < d.year)
			return -1;
		else if (this.month > d.month)
			return 1;
		else if (this.month < d.month)
			return -1;
		else if (this.day > d.day)
			return 1;
		else if (this.day < d.day)
			return -1;
		else 
			return 0;
	}
	
	@Override
	public String toString() {
		return year+"-"+month+"-"+day;
	}
	
	
}
