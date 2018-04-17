import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Snake {
	Node head;
	Node tail;
	int size;
	Node n = new Node(20,20,Dir.L);
	
	public Snake() {
		head = n;
		tail = n;
		size ++;
	}
	
	public Snake(int n) {
		this();
		for (int i=0; i<n; i++) {
			addToTail();
		}
	}
	
	private void deleteFromTail() {
		tail.prev.next = null;
		tail = tail.prev;
		size --;
	}

	private void addToHead() {
		Node n = null;
		switch(head.dir) {
		case L:
			n = new Node(head.row, head.col-1, head.dir);
			break;
		case U:
			n = new Node(head.row-1, head.col, head.dir);
			break;
		case R:
			n = new Node(head.row, head.col+1, head.dir);
			break;
		case D:
			n = new Node(head.row+1, head.col, head.dir);
			break;
		}
		
		n.next = head;
		head.prev = n;
		head = n;
		size ++;
	}

	private void addToTail() {
		Node n = null;
		switch(tail.dir) {
		case L:
			n = new Node(tail.row, tail.col+1, tail.dir);
			break;
		case U:
			n = new Node(tail.row+1, tail.col, tail.dir);
			break;
		case R:
			n = new Node(tail.row, tail.col-1, tail.dir);
			break;
		case D:
			n = new Node(tail.row-1, tail.col, tail.dir);
			break;
		}
		
		tail.next = n;
		n.prev = tail;
		tail = n;
		size ++;
	}
	
	public boolean eat(Egg egg) {
		if (head.getRect().intersects(egg.getRect())) {
			addToTail();
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		move(); 
		
		for (Node node = head; node.next != null; node = node.next) {
			node.draw(g);
		}
	}

	private void move() {
		addToHead();
		deleteFromTail();
	}
	
	public boolean checkDead() {
		if (head.row<2 || head.col<0 || head.row>Yard.ROWS || head.col>Yard.COLS) {
			return true;
		}
		
		for (Node n=head; n.next != null; n=n.next) {
			if (n == head) continue;
			if (head.getRect().intersects(n.getRect())) {
				return true;
			}
		}
		
		return false;
	}
	
	private class Node {
		int row,col;
		Dir dir;
		Node next;
		Node prev;
		
		public Node(int row, int col, Dir dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.black);
			g.fillRect(Yard.BLOCK_SIZE*col, Yard.BLOCK_SIZE*row, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
			g.setColor(c);
		}
		
		public Rectangle getRect() {
			return new Rectangle(Yard.BLOCK_SIZE*col, Yard.BLOCK_SIZE*row, Yard.BLOCK_SIZE, Yard.BLOCK_SIZE);
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT :
			if (head.dir != Dir.R) head.dir = Dir.L;
			break;
		case KeyEvent.VK_UP :
			if (head.dir != Dir.D) head.dir = Dir.U;
			break;
		case KeyEvent.VK_RIGHT :
			if (head.dir != Dir.L) head.dir = Dir.R;
			break;
		case KeyEvent.VK_DOWN :
			if (head.dir != Dir.U) head.dir = Dir.D;
			break;
		}
	}
}
