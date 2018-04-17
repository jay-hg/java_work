

import java.util.regex.*;
import java.util.*;
import java.io.*;

public class HeadImg
{

	//ȡ�������а�����,��˳�򷵻����֣�kw(����) pn(�ڼ�ҳ)
	public List<String> phb(String kw,int pn)
	{
		if(pn < 1)
			pn = 1;

		List<String> list = new ArrayList<String>();

		kw = WebRequest.encode(kw,"gbk");

		WebRequest req = new WebRequest();

		String html = req.get("http://tieba.baidu.com/f/like/furank?kw="+kw+"&pn="+pn,"gbk");

		Matcher m = Pattern.compile("username=\"(.*?)\"").matcher(html);

		while(m.find())
		{
			list.add(m.group(1));
		}

		return list;
	}

	public String imgSrc(String username)
	{
		username = WebRequest.encode(username,"gbk");

		System.out.print(username + "\t");

		WebRequest req = new WebRequest();

		String html = req.get("http://tieba.baidu.com/i/data/panel?un="+username,"gbk");

		return WebRequest.mid(html,"<img class=\"head_img\" src=\"","\"");
	}

	public void toFile(String filename,byte[] b)
	{
		try{
		FileOutputStream fos = new FileOutputStream(filename);
		fos.write(b);
		fos.flush();
		fos.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{

		WebRequest req = new WebRequest();
		HeadImg hi = new HeadImg();

		List<String> listName = hi.phb("Java",2);

		for(String s:listName)
		{
			//���ݻ�Ա��ȡ��ͼƬ��ַ
			String username = WebRequest.decode(s,"gbk");

			String src = hi.imgSrc(username);

			System.out.println(src);
			
			hi.toFile("d:/test/"+username+".jpg",req.file(src));

		}
		
	
		
	}



}