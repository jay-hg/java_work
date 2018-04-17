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
		Pattern p = Pattern.compile("((迅雷账号共享)|(爱密码共享迅雷账号))[\\w || \\:]+((首发分享密码)|(网络首发密码))[0-9]+");
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
		
		String regex = "((a.b)|(a月b日)|(a月b号)|(b号))";
		regex = regex.replaceAll("a", month);
		regex = regex.replaceAll("b", day);
		System.out.println(regex);
		
		String reg = "<a\\s+href=\"([\\w\\.\\-]+)\"\\s+title=\"\\P{InGreek}*"+regex+"\\P{InGreek}*\"\\P{InGreek}*>";
		System.out.println(reg);
		
		URL url = new URL("http://521xunlei.com/portal.php?mobile=no");
		HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();
		// 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在  
	    // http正文内，因此需要设为true, 默认情况下是false;  
	    urlConn.setDoOutput(true);  
	  
	    // 设置是否从httpUrlConnection读入，默认情况下是true;  
	    urlConn.setDoInput(true);  
	  
	    // Post 请求不能使用缓存  
	    urlConn.setUseCaches(false);  
	  
	    // 设定传送的内容类型是可序列化的java对象  
	    // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)  
	    urlConn.setRequestProperty("Content-type","application/x-java-serialized-object");  
	  
	    // 设定请求的方法为"POST"，默认是GET  
	    urlConn.setRequestMethod("POST");  
	  
	    // 连接，上面对urlConn的所有配置必须要在connect之前完成，  
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
