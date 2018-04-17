import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Egg {
	private int row;
	private int col;
	Yard yard;
	Random r = new Random();
	int colorFlag = 0;
	
	public Egg(Yard yard) {
		this.row = r.nextInt(Yard.ROWS-2)+2;
		this.col = r.nextInt(Yard.COLS);
		this.yard = yard;
	}
	
	public Rectangle getRect() {
		return new Rectangle(Yard.BLOCK_SIZE*col, Yard.BLOCK_SIZE*row, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
	}
	
	public void reAppear() {
		this.row = r.nextInt(Yard.ROWS-2)+2;
		this.col = r.nextInt(Yard.COLS);
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		if (colorFlag%2 == 0) {
			g.setColor(Color.green);
		} else {
			g.setColor(Color.red);
		}
		colorFlag ++;
		
		g.fillOval(Yard.BLOCK_SIZE*col, Yard.BLOCK_SIZE*row, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
		g.setColor(c);
	}
}
