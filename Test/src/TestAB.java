
public class TestAB {

	public static void main(String[] args) {
		A a = new B();
		a.m1();
	}

}

class A {
	private void m1(){}
}

class B extends A{
	public void m1(){}
}