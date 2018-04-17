package com.summer.shopping;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    private String imagePath;
    
    @Override
	public void init(ServletConfig config) throws ServletException {
		imagePath = config.getInitParameter("imguploadpath");
	System.out.println(imagePath);
    }

	/**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");

		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=GB2312");
        response.setCharacterEncoding("gb2312");
        PrintWriter out=response.getWriter();
        
        out.println("请求内容的长度为："+request.getContentLength());
        out.println("请求内容的类型为："+request.getContentType());
         
        DiskFileItemFactory factory=new DiskFileItemFactory();
        factory.setSizeThreshold(4096);
         
        ServletFileUpload upload=new ServletFileUpload(factory);
        upload.setSizeMax(1000000);
        List<?> fileitems=null;
        try{
            fileitems=upload.parseRequest(request);
            Iterator<?> iterator=fileitems.iterator();
            String regex=".+\\\\(.+)$";
            String[] errortype={".exe",".com",".cgi",".asp"};
            Pattern p=Pattern.compile(regex);
            
            int id = -1;
            while(iterator.hasNext()){
                FileItem item=(FileItem) iterator.next();
                if(item.isFormField()) {
                	if(item.getFieldName().equals("id")) {
                		try {
                			id = Integer.parseInt(item.getString());
                		} catch(NumberFormatException e) {
                			e.printStackTrace();
                			out.println("确定图片ID操作出错");
                			return;
                		}
                	}
                } else {
                    String name=item.getName();
                    long size=item.getSize();
                    if(name==null||name.equals("")&&size==0)
                        continue;
                    Matcher m=p.matcher(name);
                    if(m.find()){
                        for(int temp=0;temp<errortype.length;temp++){
                            if(m.group(1).endsWith(errortype[temp]))
                                throw new IOException(name+":wrong type");
                        }
                        try{
                            item.write(new File(imagePath+id+".jpg"));
                            out.println(name+"  "+size+"<br/>");
                            out.println("上传成功");
                        }catch(Exception e){
                            out.println("333"+e);
                        }  
                    }
                    else{
                        throw new IOException("fail to upload");
                    }
                         
                }
            }
        }catch(IOException e){
            out.println("222"+e);
        }
        catch(FileUploadException e1){
            e1.printStackTrace();
            out.println("111"+e1);
        }
	}

}
