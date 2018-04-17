import java.util.ArrayList;
import java.util.List;


public class Tool {
	public static void main(String[] args) {
		System.out.println("hello world!");
	}
	
	public List<String> getName(String kw, int pn) {
		List<String> names = new ArrayList<String>();
		
		kw = WebRequest.encode(kw, "gbk");
		WebRequest req = new WebRequest();
		return names;
	}
}
