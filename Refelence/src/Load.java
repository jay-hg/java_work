
public class Load {
	public static void main(String[] args) {
		new Load().launch();
	}
	
	private void launch() {
		new A();
		System.out.println("------------");
		new B();
		System.out.println(String.class.getClassLoader());
		System.out.println(Load.class.getClassLoader().getClass().getName());
		System.out.println(Load.class.getClassLoader().getParent().getClass().getName());
	}

	class A {
		
	}
	
	class B {
		
	}
}
