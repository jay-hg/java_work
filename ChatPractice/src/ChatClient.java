import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class ChatClient extends Frame{
	TextField tfTxt = new TextField();
	TextArea taContent = new TextArea();
	DataOutputStream dos = null;
	Socket s = null;


	public static void main(String[] args) {
		new ChatClient().launcherFrame();
	}
	
	public void launcherFrame() {
		setLocation(400,300);
		setSize(400,400);
		
		add(tfTxt,BorderLayout.SOUTH);
		add(taContent,BorderLayout.NORTH);
		pack();
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					dos.close();
					s.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
			
		});
		
		tfTxt.addActionListener(new TF());
		setVisible(true);
		
		try {
			s = new Socket("127.0.0.1",8888);
			dos = new DataOutputStream(s.getOutputStream());
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	class TF implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String str = tfTxt.getText().toString();
			taContent.setText(str);
			tfTxt.setText("");
			
			
			try {
				dos.writeUTF(str);
				dos.flush();
			} catch (SocketException e1) {
				System.out.println("网络连接出现问题！请重试！");
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
			
		}
		
	}
}
