package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseUtil {
	static Pattern pattern = Pattern.compile("�޷��ҵ�");
	static Pattern pattern2 = Pattern.compile("��֤��");
	public static boolean parse(String content) {
		Matcher matcher = pattern.matcher(content);
		Matcher matcher2 = pattern2.matcher(content);
		if(matcher.find()) return true;
		else if(matcher2.find()) {
			System.out.println("��Ҫ��֤�룡");
			return false;
		}
		return false;
	}
}
