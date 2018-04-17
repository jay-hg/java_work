package util;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.utils.URIBuilder;

public class GenerateUtil {
	//生成准考证号
	public static List<String> generateNum(int star, int end) {
		if(star > end) return null;
		List<String> strs = new ArrayList<String>();
		StringBuilder sb = null,sb2 = null;
		for(int i=star;i<end;i++) {
			sb = new StringBuilder("3510101722");
			if(i<10) sb.append("00").append(i);
			else if(i<100) sb.append("0").append(i);
			else sb.append(i);
			for(int j=1;j<31;j++) {
				sb2 = new StringBuilder();
				if(j<10) sb2.append("0");
				sb2.append(j);
				sb2.insert(0, sb);
				strs.add(sb2.toString());
			}
		}
		
		return strs;
	}
	
	//生成URI
	public static URI getURI(String zkzh) throws URISyntaxException {
		URI uri = new URIBuilder().setScheme("http").setHost("www.chsi.com.cn")
				.setPath("/cet/query")
				.setParameter("zkzh", zkzh)
				.setParameter("xm","蔡和桂").build();
		return uri;
	}
}
