package com.test.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Certification
 */
@WebServlet("/Certification")
public class Certification extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static final int WIDTH = 60;
	private static final int HEIGHT = 20;
	private static final char[] codeSequence = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',         
        'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',         
        'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	
	Random random = new Random();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Certification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		
		response.setContentType("image/jpeg");
		
		char[] code = new char[4];
		for(int i=0;i<code.length;i++) {
			int ran = random.nextInt(codeSequence.length); 
			code[i] = codeSequence[ran];
		}
		
		BufferedImage img = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.gray);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.red);
		for(int i=0;i<code.length;i++) {
			g.drawChars(code, i, 1, 10*i+10, 10);
		}
		g.dispose();
		
		/*File file = new File("E:\\abc\\","test.jpg");
		ImageIO.write(img, "JPEG", file);*/
		ImageIO.write(img, "JPEG", response.getOutputStream());
	}

}
