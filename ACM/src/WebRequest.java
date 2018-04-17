
import java.net.*;
import java.io.*;
import java.security.cert.*;
import javax.net.ssl.*;

/* ����Http/HttpsЭ��,������ҳ��ͬһ��������,cookie����  */

public class WebRequest
{
/*
	public static void main(String[] args) 
	{
		WebRequest req = new WebRequest();

		//�ֲ���������ӣ�(������ ����Э��ͷ����վ)
		req.open("GET","Http://xxx","utf8");//������
		req.setRequestHeader("host","xxx");//����Э��ͷ *��ѡ
		req.send();//��������
		System.out.println(req.responseText());//��ȡ����ֵ
	
		//�ϳ�һ���������ӣ�(����Э��ͷ)
		System.out.println(req.get("Http://xxx","utf8"));
	}
*/

	private class HttpsHandler {
		public void trustAllHttpsCertificates() throws Exception {
			TrustManager[] tm_array = new TrustManager[1];
			TrustManager tm = new MyTrustManager();
			tm_array[0] = tm;
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, tm_array, null);
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		}
		private class MyTrustManager implements TrustManager, X509TrustManager {
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}
			public boolean isServerTrusted(X509Certificate[] certs) {
				return true;
			}
			public boolean isClientTrusted(X509Certificate[] certs) {
				return true;
			}
			public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
				return;
			}
			public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
				return;
			}
		}
	}
	

	private String cookie;
	private String charset;
	private String method;
	private HttpURLConnection http;
	private HttpsURLConnection https;
	private boolean isHttps;

	public static String mid(String value,String left,String right)
	{
		int index = value.indexOf(left)+left.length();
		return value.substring(index,value.indexOf(right,index));
	}

	public static String decode(String value,String charset)
	{
		try{
			return URLDecoder.decode(value,charset);
		}catch(Exception e){return null;}
	}

	public static String encode(String value,String charset)
	{
		try{
			return URLEncoder.encode(value,charset);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}

	/*[������] method = GET / POST , url = �����ʵ���ַ , charset = �ַ�������*/
	public boolean open(String method,String url,String charset)
	{
		this.method = method;
		this.charset = charset;

		try{
			URL __url = new URL(url);
			if(url.toLowerCase().startsWith("https://"))
			{
				this.isHttps = true;
				HttpsHandler httpsH = new HttpsHandler();
				httpsH.trustAllHttpsCertificates();
				HostnameVerifier hv = new HostnameVerifier(){
					public boolean verify(String urlHostName, SSLSession session) {
						return true;
					}
				};
				HttpsURLConnection.setDefaultHostnameVerifier(hv);
				https = (HttpsURLConnection)__url.openConnection();
				https.setDoInput(true);
				https.setDoOutput(true);
				https.setRequestMethod(method);
				https.setFollowRedirects(true);
				if(null != cookie)
				{
					https.setRequestProperty("Cookie",cookie);
				}
			}
			else
			{
				this.isHttps = false;
				http = (HttpURLConnection)__url.openConnection();
				http.setDoInput(true);
				http.setDoOutput(true);
				http.setRequestMethod(method);
				http.setFollowRedirects(true);
				if(null != cookie)
				{
					http.setRequestProperty("Cookie",cookie);
				}
			}
		}catch(Exception e){return false;}
		return true;
	}

	/*[������] method = GET | POST , url = �����ʵ���ַ , charset = �ַ������� , proxy = ���������*/
	public boolean open(String method,String url,String charset,Proxy proxy)
	{
		this.method = method;
		this.charset = charset;

		try{
			URL __url = new URL(url);
			if(url.toLowerCase().startsWith("https://"))
			{
				this.isHttps = true;
				HttpsHandler httpsH = new HttpsHandler();
				httpsH.trustAllHttpsCertificates();
				HostnameVerifier hv = new HostnameVerifier(){
					public boolean verify(String urlHostName, SSLSession session) {
						return true;
					}
				};
				HttpsURLConnection.setDefaultHostnameVerifier(hv);
				https = (HttpsURLConnection)__url.openConnection(proxy);
				https.setDoInput(true);
				https.setDoOutput(true);
				https.setRequestMethod(method);
				https.setFollowRedirects(true);
				if(null != cookie)
				{
					https.setRequestProperty("Cookie",cookie);
				}
			}
			else
			{
				this.isHttps = false;
				http = (HttpURLConnection)__url.openConnection(proxy);
				http.setDoInput(true);
				http.setDoOutput(true);
				http.setRequestMethod(method);
				http.setFollowRedirects(true);
				if(null != cookie)
				{
					http.setRequestProperty("Cookie",cookie);
				}
			}
		}catch(Exception e){return false;}
		return true;
	}

	/*[����requestЭ��ͷ] key = �� , value = ֵ*/
	public void setRequestHeader(String key,String value)
	{
		if(this.isHttps)
			https.setRequestProperty(key,value);
		else
			http.setRequestProperty(key,value);
	}
	
	/*[��������] GET����,�����޲�send()*/
	public boolean send()
	{
		try{
		if(this.isHttps)
			https.connect();
		else
			http.connect();
		}catch(Exception e){return false;}
		return true;
	}

	/*[��������] POST����,���ô���send(),�������ı�����*/
	public boolean send(String postData)
	{
		try{
			if(this.isHttps)
			{
				https.connect();
				OutputStreamWriter bos = new OutputStreamWriter(https.getOutputStream(),charset);
				bos.write(postData);
				bos.flush();
			}
			else
			{
				http.connect();
				OutputStreamWriter bos = new OutputStreamWriter(http.getOutputStream(),charset);
				bos.write(postData);
				bos.flush();

			}
		}catch(Exception e){return false;}
		return true;
	}

	/*[��������] POST����,���ô���send(),�������ļ��ϴ�*/
	public boolean send(byte[] postData)
	{
		try{
			if(this.isHttps)
			{
				https.connect();
				BufferedOutputStream bos = new BufferedOutputStream(https.getOutputStream());
				bos.write(postData);
				bos.flush();
			}
			else
			{
				http.connect();
				BufferedOutputStream bos = new BufferedOutputStream(http.getOutputStream());
				bos.write(postData);
				bos.flush();
			}
		}catch(Exception e){return false;}
		return true;
	}

	/*[��������] �ı����� , һ����htmlԴ���� / ajax���󷵻�ֵ / .. */
	public String responseText()
	{
		StringBuilder sb = new StringBuilder();
		try{
			if(this.isHttps)
			{
				if(https.getResponseCode() == 200)
				{
					BufferedReader bis = new BufferedReader(new InputStreamReader(https.getInputStream(),charset));
					String line = null;
					while((line = bis.readLine())!=null)
					{
						sb.append(line);
						sb.append("\n");
					}
					bis.close();
					cookie = this.getCookie();
					return sb.toString();
				}
			}
			else
			{
				if(http.getResponseCode() == 200)
				{
					BufferedReader bis = new BufferedReader(new InputStreamReader(http.getInputStream(),charset));
					String line = null;
					while((line = bis.readLine())!=null)
					{
						sb.append(line);
						sb.append("\n");
					}
					bis.close();
					cookie = this.getCookie();
					return sb.toString();
				}
			}
		}catch(Exception e){return null;}
		return null;
	}

	/*[��������] �ֽ�����,���ڻ�ȡ�ļ�*/
	public byte[] responseBody()
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try{
			if(this.isHttps)
			{
				if(https.getResponseCode() == 200)
				{
					BufferedInputStream bis = new BufferedInputStream(https.getInputStream());
					byte[] b = new byte[1024];
					int length = -1;
					while((length = bis.read(b))!=-1)
					{
						bos.write(b,0,length);
						bos.flush();
					}
					bis.close();
					bos.close();
					cookie = this.getCookie();
					return bos.toByteArray();
				}
			}
			else
			{
				if(http.getResponseCode() == 200)
				{
					BufferedInputStream bis = new BufferedInputStream(http.getInputStream());
					byte[] b = new byte[1024];
					int length = -1;
					while((length = bis.read(b))!=-1)
					{
						bos.write(b,0,length);
						bos.flush();
					}
					bis.close();
					bos.close();
					cookie = this.getCookie();
					return bos.toByteArray();
				}

			}
		}catch(Exception e){return null;}
		return null;		

	}

	/*[����responseЭ��ͷ] ���ڻ�ȡcookie����Ϣ */
	public String getResponseHeader(String key)
	{
		if(this.isHttps)
			return https.getHeaderField(key);
		else
			return http.getHeaderField(key);
	}

	/*[����Set-Cookie] ���ڻ�ȡcookie��Ϣ*/
	public String getCookie()
	{
		if(this.isHttps)
			return https.getHeaderField("Set-Cookie");
		else
			return http.getHeaderField("Set-Cookie");
	}

	
	/*�����ǲ���Э��ͷ,�ϳ�һ�������󷽷�*/
	public String get(String url,String charset)
	{
		this.open("GET",url,charset);
		this.send();
		return this.responseText();
	}
	
	public String post(String url,String postData,String charset)
	{
		this.open("POST",url,charset);
		this.send(postData);
		return this.responseText();
	}

	public String post(String url,byte[] postData,String charset)
	{
		this.open("POST",url,charset);
		this.send(postData);
		return this.responseText();
	}

	public byte[] file(String url)
	{
		this.open("GET",url,null);
		this.send();
		return this.responseBody();
	}

}
