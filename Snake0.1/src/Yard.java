import javax.swing.JFrame;


public class Yard extends JFrame{
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

}
