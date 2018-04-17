package Main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import util.GenerateUtil;
import util.LogUtil;
import util.ParseUtil;

public class GetScore {
	HttpGet httpGet = new HttpGet();
	HttpClient client = new DefaultHttpClient();
	HttpResponse response;
	public static void main(String[] args) {
		GetScore gs = new GetScore();
		gs.initHeader();
		
		LogUtil lu = new LogUtil();
		try {
			lu.read();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		StringBuilder sbLog = new StringBuilder();
		List<String> strs = GenerateUtil.generateNum(lu.params[0], lu.params[1]);
		int used = 0;
		try {
			for(String s:strs) {
				used ++;
				if(used<lu.params[2]) continue;
				if(used == 30) {
					used = 1;
					lu.params[0] ++;
				}
				lu.params[02] = used;
				URI uri = GenerateUtil.getURI(s);
				gs.httpGet.setURI(uri);
				gs.response = gs.client.execute(gs.httpGet);
				if(gs.response.getStatusLine().getStatusCode() == 200) {
					HttpEntity entity = gs.response.getEntity();
					
					String content = EntityUtils.toString(entity, "utf-8");
					boolean notFind = ParseUtil.parse(content);
					if(!notFind) {
						System.out.print("查到准考证号为："+s+"\n");
						break;
					}
					System.out.println(s+"已排除！");
					sbLog.append(s+"已排除！\n");
				}
			}
		} catch (Exception e) {
			sbLog.append(e.getMessage());
		} finally {
			try {
				lu.write();
				lu.log(sbLog.toString());
				lu.destroy();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("done!");
	}
	
	void initHeader() {
		httpGet.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
		httpGet.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");  
        httpGet.setHeader("Accept-Language", "zh-cn,zh;q=0.9"); 
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:34.0) Gecko/20100101 Firefox/34.0");
        httpGet.setHeader("Referer", "http://www.chsi.com.cn/cet/");
	}
}
