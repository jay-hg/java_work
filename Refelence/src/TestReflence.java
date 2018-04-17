import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class TestReflence {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String str = "T";
		Class c = Class.forName(str);
		Object o = c.newInstance();
		
		Method[] methods = c.getMethods();
		
		for (Method m:methods) {
			if (m.getName().equals("mm")) {
				m.invoke(o);
			} 
			else if (m.getName().equals("gg")) {
				for (Class parTypes : m.getParameterTypes()) {
					System.out.println(parTypes.getName());
				}
				m.invoke(o, 1, 1);
			}
		}
	}
}

class T {
	static {
		System.out.println("T loaded!");
	}
	
	public T() {
		System.out.println("T constructed!");
	}
	
	public void mm() {
		System.out.println("mm() has is being used!");
	}
	
	public void gg(int x, int y) {
		System.out.println(x+y);
	}
}

class T1 {
	
}