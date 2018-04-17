import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GetAccount {
	private List<String> accounts = new LinkedList<String>();
	
	public static void main(String[] args) throws IOException {
		GetAccount ga = new GetAccount();
		//ga.printAccount();
		
		ga.printAccount(ga.getUrl());
		ga.writeToDeskTop();
		System.out.println("the end");
	}
	
	public void printAccount(String targeUrl) throws IOException {
		//File f = new File("C:/Users/hgfy/Desktop/abc.txt");
		//FileInputStream fis = new FileInputStream(f);
		InputStream is = getInputStream(targeUrl);
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		
		String temp;
		Pattern p = Pattern.compile("((Ѹ���˺Ź���)|(�����빲��Ѹ���˺�))[\\w || \\:]+((�׷���������)|(�����׷�����))[0-9]+");
		while((temp=br.readLine()) != null) {
			//System.out.println(temp);
			parseFile(temp,p);
		}
		
		br.close();
		is.close();
	}
	
	public void parseFile(String s, Pattern p) {
		Matcher m = p.matcher(s);
		while(m.find()) {
			System.out.println(m.group());
			accounts.add(m.group());
		}
	}
	
	public InputStream getInputStream(String targeUrl) throws IOException {
		URL url = new URL(targeUrl);
		URLConnection urlConn = url.openConnection();
		return urlConn.getInputStream();
	}
	
	public String getUrl() throws IOException {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("d");
		String day = df.format(date);
		df = new SimpleDateFormat("M");
		String month = df.format(date);
		
		String regex = "((a.b)|(a��b��)|(a��b��)|(b��))";
		regex = regex.replaceAll("a", month);
		regex = regex.replaceAll("b", day);
		System.out.println(regex);
		
		String reg = "<a\\s+href=\"([\\w\\.\\-]+)\"\\s+title=\"\\P{InGreek}*"+regex+"\\P{InGreek}*\"\\P{InGreek}*>";
		System.out.println(reg);
		
		URL url = new URL("http://521xunlei.com/portal.php?mobile=no");
		HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
		// �����Ƿ���httpUrlConnection�������Ϊ�����post���󣬲���Ҫ����  
	    // http�����ڣ������Ҫ��Ϊtrue, Ĭ���������false;  
	    urlConn.setDoOutput(true);  
	  
	    // �����Ƿ��httpUrlConnection���룬Ĭ���������true;  
	    urlConn.setDoInput(true);  
	  
	    // Post ������ʹ�û���  
	    urlConn.setUseCaches(false);  
	  
	    // �趨���͵����������ǿ����л���java����  
	    // (����������,�ڴ������л�����ʱ,��WEB����Ĭ�ϵĲ�����������ʱ������java.io.EOFException)  
	    urlConn.setRequestProperty("Content-type","application/x-java-serialized-object");  
	  
	    // �趨����ķ���Ϊ"POST"��Ĭ����GET  
	    urlConn.setRequestMethod("POST");  
	  
	    // ���ӣ������urlConn���������ñ���Ҫ��connect֮ǰ��ɣ�  
	    urlConn.connect();  
	    
		/*File f = new File("C:/Users/hgfy/Desktop/def.txt");
		FileInputStream is = new FileInputStream(f);*/
		InputStream is = urlConn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"GB2312"));
		
		Pattern p = Pattern.compile(reg);
		String line;
		boolean run = true;
		String targeUrl = "";
		while((line=br.readLine()) != null && run) {
			Matcher m = p.matcher(line);
			while(m.find()) {
				targeUrl = "http://521xunlei.com/"+m.group(1);
				System.out.println(targeUrl);
				run = false;
				break;
			}
			//System.out.println(line);
		}
		
		br.close();
		is.close();
		return targeUrl;
	}
	
	public void writeToDeskTop() throws IOException {
		File f = new File("C:/Users/hgfy/Desktop/abc.txt");
		FileOutputStream fos = new FileOutputStream(f);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		for(String s : accounts) {
			bw.write(s);
			bw.flush();
			bw.newLine();
		}
		
		bw.close();
		fos.close();
	}
}
