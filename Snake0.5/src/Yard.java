import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Yard extends Frame{
	Image offScreenImage = null;
	public static final int ROWS = 40;
	public static final int COLS = 40;
	public static final int BLOCK_SIZE = 15;
	int initialCount = Integer.parseInt(PropertyMgr.getProperty("initialCount"));
	Snake s = new Snake(initialCount);
	Egg egg = new Egg(this);
	private boolean gameOver = false;
	private int count = 0;
	
	public static void main(String[] args) {
		new Yard().launch();

	}

	private void launch() {
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		this.addKeyListener(new KeyMonitor());
		
		setLocation(200,100);
		setSize(ROWS*BLOCK_SIZE, COLS*BLOCK_SIZE);
		setVisible(true);
		
		new Thread(new PaintThread()).start();
	}
	
	@Override
	public void update(Graphics g) {
		if (this.offScreenImage == null) {
			this.offScreenImage = this.createImage(ROWS*BLOCK_SIZE, COLS*BLOCK_SIZE);
		}
		
		Graphics gOffScreen = offScreenImage.getGraphics();
		paint(gOffScreen);
		
		g.drawImage(offScreenImage, 0, 0, null);
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
		
		if (s.eat(egg)) {
			egg.reAppear();
			count += 5;
		}
		egg.draw(g);
		s.draw(g);
		
		if (s.checkDead()) {
			g.drawString("游戏结束", 100, 200);
			
			gameOver = true;
		}
		g.drawString("得分："+count, 10, 50);
	}
	
	private class PaintThread implements Runnable {

		@Override
		public void run() {
			try {
				while (!gameOver) {
					repaint();
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			s.keyPressed(e);
		}
		
	}
}
