
public class ConsumerProducer {

	public static void main(String[] args) {
		Basket b = new Basket();
		new Thread(new Producer(b, 60)).start();
		new Thread(new Consumer(b)).start();
	}
}

class Consumer implements Runnable {
	Basket basket;
	
	public Consumer(Basket basket) {
		this.basket = basket;
	}
	
	@Override
	public void run() {
		Bun bun = null;
		while (basket.forSale ) {
			bun = basket.delete();
		}
	}
	
}

class Producer implements Runnable {
	Basket basket;
	int count;

	public Producer(Basket basket, int count) {
		this.basket = basket;
		this.count = count;
	}

	@Override
	public void run() {
		Bun bun = null;
		for (int i=0; i<count; i++) {
			bun = new Bun(i);
			basket.add(bun);
			
		}
		while (basket.index <= 0) {
			basket.forSale = false;
		}
	}
}

class Bun {
	int id;

	public Bun(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return id+"号包子";
	}
}

class Basket {
	public boolean forSale = true;
	public static int SIZE = 6;
	Bun[] buns = new Bun[SIZE];
	public int index;
	
	public Basket() {
		index = 0;
	}
	
	public synchronized void add(Bun bun) {
		while (index == Basket.SIZE) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.notifyAll();
		buns[index] = bun;
		index ++;
		System.out.println("生产了"+bun+"，篮子里还有"+index+"个");
	}
	
	public synchronized Bun delete() {
		while (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.notifyAll();
		index --;
		Bun bun = buns[index];
		buns[index] = null;
		System.out.println("消费了"+bun+"，篮子里还有"+index+"个");
		return bun;
	}
}