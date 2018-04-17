package Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {

	public static void main(String[] args) {
		/*p("ab#".matches("..."));
		Pattern pa = Pattern.compile("[a-z](3)");
		Matcher m = pa.matcher("ghf");
		p(m.matches());
		p("fgh".matches("[a-z]{3}"));*/
		
		//p("%".matches("[^#%]"));
		//p(" \n".matches("^[\\s && [^\\n]]\\n$"));
		//p("kfjguhkl@qq.com".matches("[\\w[.-]]+[@][\\w[.-]]+\\.[cC][oO][mM]$"));
		/*Pattern p = Pattern.compile("\\d{3,5}");
		String s = "123-34567-234-32";
		Matcher m = p.matcher(s);
		p(m.find());
		p(m.find());
		p("start:"+m.start()+"end:"+m.end());
		p(m.find());
		m.reset();
		p(m.find());
		p(m.find());
		p(m.find());
		p(m.lookingAt());*/
		
		/*Pattern p = Pattern.compile("java",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("java i love JAVA you hate JAva sdagr");
		StringBuffer sbf = new StringBuffer();
		int i = 0;
		while(m.find()) {
			i++;
			if (i%2 == 0) {
				m.appendReplacement(sbf, "JAVA");
			} else {
				m.appendReplacement(sbf, "java");
			}
		}
		m.appendTail(sbf);
		p(sbf);*/
		
		Pattern p = Pattern.compile("([\\w]*)(@(.*))");
		Matcher m = p.matcher("chg1243@qq.com");
		m.find();
		p(m.group());
		p(m.group(1));
		p(m.group(2));
		p(m.group(3));
	}
	
	public static void p(Object o) {
		System.out.println(o);
	}
}
