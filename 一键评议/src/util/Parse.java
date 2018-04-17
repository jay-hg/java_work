package util;

import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import Entity.FormEntity;

public class Parse {
	//从爬取的页面获取表单的入口地址
	public static void getCourseUrl(String content,LinkedList<FormEntity> entityList) {
		Pattern pattern = Pattern.compile("href='(.+?)' target='_self'>开始评议");
		Matcher matcher = pattern.matcher(content);
		while(matcher.find()) {
			FormEntity fe = new FormEntity();
			fe.setPageUrl("http://59.77.226.35/student/jscp/"+matcher.group(1));
			System.out.println(fe.getPageUrl());
			entityList.add(fe);
		}
	}
	//从表单页面获取相应参数
	public static void getFormPara(String content,FormEntity formEntity) {
		Pattern patternUrl = Pattern.compile("action=\"(.+?)\".+?form1");
		Pattern patternParaV = Pattern.compile("name=\"__VIEWSTATE\".+?value=\"(.+?)\"");
		Pattern patternParaE = Pattern.compile("name=\"__EVENTVALIDATION\".+?value=\"(.+?)\"");
		Matcher matcherUrl = patternUrl.matcher(content);
		if(matcherUrl.find()) {
			formEntity.setDestUrl("http://59.77.226.35/student/jscp/"+matcherUrl.group(1));
			System.out.println(formEntity.getDestUrl());
		}
		
		Matcher matcherParaV = patternParaV.matcher(content);
		if(matcherParaV.find()) {
			formEntity.setParaV(matcherParaV.group(1));
			System.out.println(formEntity.getParaV());
		}
		
		Matcher matcherParaE = patternParaE.matcher(content);
		if(matcherParaE.find()) {
			formEntity.setParaE(matcherParaE.group(1));
			System.out.println(formEntity.getParaE());
		}
		System.out.println();
	}
	//获取网页源代码
	public static String getHTML(String url,HttpClient httpClient,String sessionId) {
		HttpGet httpGet = new HttpGet(url);
		httpGet.addHeader(new BasicHeader("Cookie",sessionId));
		String content = null;
    	try {
    		HttpResponse httpResponse = httpClient.execute(httpGet);
    		HttpEntity entity = httpResponse.getEntity();
    		System.out.println("contentType:"+entity.getContentType().toString());
    		content = EntityUtils.toString(entity,"utf-8");
    		
    	} catch (ClientProtocolException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} 
    	return content;
	}
}
