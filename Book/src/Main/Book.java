package Main;

public class Book {
	private int prince;
	private String title;
	private String author;
	
	public static void main(String[] args)
	{
		Book b=new Book();
		b.setPrince(10);
		b.setTitle("java开发入门及项目实战");
		b.setAuthor("明日科技");
		System.out.println(b.getTitle());
		System.out.println(b.getAuthor());
		System.out.println(b.getPrince());
	}
	
	public Book()
	{

	}
	
	public Book(int p,String t,String a)
	{
		prince=p;
		title=t;
		author=a;
	}
	
	void setPrince(int p)
	{
		prince=p;
	}
	
	void setTitle(String t)
	{
		title=t;
	}
	
	void setAuthor(String a)
	{
		author=a;
	}
	
	int getPrince()
	{
		return prince;
	}
	
	String getTitle()
	{
		return title;
	}
	
	String getAuthor()
	{
		return author;
	}

}
