package Test;

public class Dlx {
public static void main(String[] args)
{
	int width=5;
	int x=1,y=1;
	
	for (int i=1;i<(2*width-1)*(2*width-1);i++)
	{
		if (y<=width)
		{
			if (x>=width-y+1 && x<=width+y-1)
				System.out.print("*");
			else System.out.print(" ");
		}
		else
		{
			if (x>y-width && x<3*width-y)
				System.out.print("*");
			else System.out.print(" ");
		}
		
		x++;
		if (x==(2*width))
		{
			System.out.println();
			y++;
			x=1;
		}
	}
}
}
