package Main;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UpLow extends JFrame{
	private JTextField jt1,jt2;
	private JButton jb;
	private JRadioButton jr1,jr2;
	private Container c;
	private ButtonGroup bg;
	
	public static void main(String[] args) {
                    UpLow frame = new UpLow();
                    frame.setVisible(true);
    }
	
    public UpLow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 498, 500);
        setTitle("大小写转换");
        setLayout(null);
        
        c=this.getContentPane();
        
        jt1=new JTextField();
        jt1.setBounds(80,50,300,30);
        c.add(jt1);
        
        jb=new JButton("转换");
        jb.setBounds(80,150,100,30);
        jb.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e)
        	{
        		String s;
        		s=jt1.getText();
        		if (bg.getSelection().getActionCommand().equals("大写"))
        			s=s.toUpperCase();
        		else
        			s=s.toLowerCase();
        		
        		jt2.setText(s);
        	}
        });
        c.add(jb);
        
        jr1=new JRadioButton("大写");
        jr1.setActionCommand("大写");
        jr1.setSelected(true);
        jr1.setBounds(250,150,100,30);
        c.add(jr1);
        
        jr2=new JRadioButton("小写");
        jr2.setActionCommand("小写");
        jr2.setBounds(350,150,100,30);
        c.add(jr2);
        
        bg=new ButtonGroup();
        bg.add(jr1);
        bg.add(jr2);
        
        jt2=new JTextField();
        jt2.setEditable(false);
        jt2.setBounds(80,250,300,30);
        c.add(jt2);
    }

}