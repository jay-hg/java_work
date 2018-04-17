package servlet;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import util.Parse;
import Entity.FormEntity;
/*
 * ��½
 * ץȡurl
 * ����ÿ��urlץȡ�������
 * ���浽session��
 * ��commitOne.jspд�ؿͻ��� */
public class SubmitServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        this.doPost(request, response);  
    }  
      
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    	String path = request.getContextPath();
    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    	
    	//���񴦼���ÿ��url�����id
    	String id = request.getParameter("id");
    	//��chrome��cookie֮�л�ȡ
    	String sessionId = request.getParameter("sessionId");
    	
    	HttpSession session = request.getSession();
    	session.setAttribute("cookie", sessionId);
    	
    	String url = "http://59.77.226.35/student/jscp/TeaList.aspx?bj=score&id="+id;
    	HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
    	CloseableHttpClient httpClient = httpClientBuilder.build();
    	HttpGet httpGet = new HttpGet(url);
    	httpGet.addHeader(new BasicHeader("Cookie",sessionId));
    	LinkedList<FormEntity> entityList = new LinkedList<FormEntity>(); 
    	try {
    		HttpResponse httpResponse = httpClient.execute(httpGet);
    		HttpEntity entity = httpResponse.getEntity();
    		String content = EntityUtils.toString(entity);
    		System.out.println(content);
    		Parse.getCourseUrl(content, entityList);
    		for(FormEntity fe:entityList) {
    			content = Parse.getHTML(fe.getPageUrl(), httpClient, sessionId);
    			Parse.getFormPara(content, fe);
    		}
    		
    		session.setAttribute("forms", entityList);
    	} catch (ClientProtocolException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}  finally {
    		httpClient.close();
    	}
    	response.sendRedirect(basePath+"commitOne.jsp");
    }  
}
