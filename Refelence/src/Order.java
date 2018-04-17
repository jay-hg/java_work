
public class Order {
	
	String name;
	int price;
	int count;

	public static void main(String[] args) {
		Order order = new Order();
		order.setName("apple");
		order.setCount(10);
		order.setPrice(2);
		
		System.out.println(order);
	}

	public int getTotalPrice() {
		return count * price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return getName()+"-"+getTotalPrice();
	}
}
