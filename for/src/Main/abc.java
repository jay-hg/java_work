package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class abc extends JFrame{
	
	private static final long serialVersionUID = -2577935223412903226L;
    private JPanel contentPane;
    private JTextField nameField;
    private JTextArea personnelArea;
    private JTextArea resultArea;
    
    public static void main(String[] args) {
    	abc frame=new abc();
    	frame.setVisible(true);
    }

    public abc(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 498, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setTitle("�������������ȡ���˹���");
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel
                .setBorder(new TitledBorder(
                        null,
                        "�����ڳ������������س�",
                        TitledBorder.LEADING, TitledBorder.TOP, null,
                        new Color(59, 59, 59)));
        panel.setBounds(10, 10, 174, 242);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 5));
        
        nameField = new JTextField();
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("�û������˻س�");
            }
        });
        panel.add(nameField, BorderLayout.NORTH);
        nameField.setColumns(10);
        
        JScrollPane scrollPane = new JScrollPane();
        panel.add(scrollPane);
        
        personnelArea = new JTextArea();
        personnelArea.setEditable(false);
        scrollPane.setViewportView(personnelArea);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null,
                "ѡȡ������Ա��",
                TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59,
                        59)));
        panel_1.setBounds(183, 10, 219, 242);
        contentPane.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane_1 = new JScrollPane();
        panel_1.add(scrollPane_1);
        
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        scrollPane_1.setViewportView(resultArea);
        
        JButton button = new JButton("��ȡ");
        button.addActionListener(new ActionListener()
        {                            
        	public void actionPerformed(ActionEvent e)
        	{                           
        		System.out.println("��ʼ��ȡ���˹���");
        	}
        });
        button.setBounds(407, 164, 63, 25);
        contentPane.add(button);
        
        JButton button_1 = new JButton("�˳�");
        
        button_1.setBounds(407, 215, 63, 25);
        contentPane.add(button_1);
    }
}
