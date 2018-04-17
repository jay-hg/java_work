package Test;

public class KxLx {
	public static void main(String[] args)
	{
		int width=6;
		
		for (int i=0;i<2*width-1;i++)
		{
			if (i<width)
			{
				for (int j=0;j<2*width-1;j++)
				{
					if (j==width-i-1 || j==width+i-1)
						System.out.print("*");
					else System.out.print(" ");
					
				}
			}
			else
			{
				for (int j=0;j<2*width-1;j++)
				{
					if (j==i-width+1 || j==3*width-i-3)
						System.out.print("*");
					else System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
