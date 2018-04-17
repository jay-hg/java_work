import java.awt.Color;
import java.awt.Graphics;
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
	
	private void deleteFromTail() {
		tail.prev.next = tail.prev;
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
	
	public void draw(Graphics g) {
		move(); 
		
		if (size == 1) {
			Node node = head;
			node.draw(g);
		} else {
			for (Node node = head; node.next != null; node = node.next) {
				node.draw(g);
			}
		}
	}

	private void move() {
		addToHead();
		deleteFromTail();
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
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT :
			head.dir = Dir.L;
			break;
		case KeyEvent.VK_UP :
			head.dir = Dir.U;
			break;
		case KeyEvent.VK_RIGHT :
			head.dir = Dir.R;
			break;
		case KeyEvent.VK_DOWN :
			head.dir = Dir.D;
			break;
		}
	}
}
