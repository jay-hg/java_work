package testHttpComponents;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class TestHttpComponents {
	public static void main(String[] args) {
		String zkzh = "3510101722019"+"02";
		URI uri = null;
		try {
			uri = new URIBuilder().setScheme("http").setHost("www.chsi.com.cn")
					.setPath("/cet/query")
					.setParameter("zkzh", zkzh)
					.setParameter("xm","³ÂÀ¤öÎ").build();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
		httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");  
        httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.9"); 
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        httpGet.setHeader("Referer", "http://www.chsi.com.cn/cet/");
        
        HttpClient client = new DefaultHttpClient();
		try {
			HttpResponse response = client.execute(httpGet);
			if(response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				//InputStream in = entity.getContent();
				//readResponse(in);
				
				String content = EntityUtils.toString(entity, "utf-8");
				System.out.println(content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readResponse(InputStream in) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
		String line = null;
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
