import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;


public class Yard extends JFrame{
	Image offScreenImage = null;
	public static final int ROWS = 40;
	public static final int COLS = 40;
	public static final int BLOCK_SIZE = 15;

	public static void main(String[] args) {
		new Yard().launch();

	}

	private void launch() {
		
		setLocation(200,100);
		setSize(ROWS*BLOCK_SIZE, COLS*BLOCK_SIZE);
		setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, ROWS*BLOCK_SIZE, COLS*BLOCK_SIZE);
		
		g.setColor(Color.DARK_GRAY);
		for (int i=1; i<ROWS; i++) {
			g.drawLine(0, BLOCK_SIZE*i, COLS*BLOCK_SIZE, BLOCK_SIZE*i);
		}
		
		for (int i=1; i<COLS; i++) {
			g.drawLine(BLOCK_SIZE*i, 0, BLOCK_SIZE*i, ROWS*BLOCK_SIZE);
		}
		g.setColor(c);
	}
	
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = createImage(COLS*BLOCK_SIZE, ROWS*BLOCK_SIZE);
			paint(g);
			g.drawImage(offScreenImage, 0, 0, null);
		}
	}
	
	private class PaintThread implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					repaint();
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
