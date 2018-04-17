package com.lw.frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.lw.util.WindowUtil;

public class MainFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5882409605868365475L;
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {// ���ô������
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainFrame frame = new MainFrame();// �����������
                    frame.setVisible(true);// ���ô���ɼ�
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public MainFrame() {
        setTitle("����¼ģ��");// ���ô������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ùرմ���ʱ�˳�����
        
        JMenuBar menuBar = new JMenuBar();// �����˵���
        setJMenuBar(menuBar);// Ӧ�ò˵���
        
        JMenu memoManagementMenu = new JMenu("����¼����");// �����˵�
        memoManagementMenu.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        menuBar.add(memoManagementMenu);// Ӧ�ò˵�
        
        JMenuItem addMemoMenuItem = new JMenuItem("���ӱ���¼");// �����˵���
        addMemoMenuItem.addActionListener(new ActionListener() {// �����˵����¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_addMemoMenuItem_actionPerformed(e);
                    }
                });
        addMemoMenuItem.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        memoManagementMenu.add(addMemoMenuItem);// Ӧ�ò˵���
        
        JMenuItem modifyMemoMemuItem = new JMenuItem("�޸ı���¼");// �����˵���
        modifyMemoMemuItem.addActionListener(new ActionListener() {// �����˵����¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_modifyMemoMemuItem_actionPerformed(e);
                    }
                });
        modifyMemoMemuItem.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        memoManagementMenu.add(modifyMemoMemuItem);// Ӧ�ò˵���
        
        JMenuItem queryMemoMenuItem = new JMenuItem("��ѯ����¼");// �����˵���
        queryMemoMenuItem.addActionListener(new ActionListener() {// �����˵����¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_queryMemoMenuItem_actionPerformed(e);
                    }
                });
        queryMemoMenuItem.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        memoManagementMenu.add(queryMemoMenuItem);// Ӧ�ò˵���
        
        JMenuItem deleteMemoMenuItem = new JMenuItem("ɾ������¼");// �����˵���
        deleteMemoMenuItem.addActionListener(new ActionListener() {// �����˵����¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_deleteMemoMenuItem_actionPerformed(e);
                    }
                });
        deleteMemoMenuItem.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        memoManagementMenu.add(deleteMemoMenuItem);// Ӧ�ò˵���
        
        JMenu toolMenu = new JMenu("С����");// �����˵�
        toolMenu.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        menuBar.add(toolMenu);// Ӧ�ò˵�
        
        JMenuItem notepadMenuItem = new JMenuItem("���±�");// �����˵���
        notepadMenuItem.addActionListener(new ActionListener() {// �����˵����¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_notepadMenuItem_actionPerformed(e);
                    }
                });
        notepadMenuItem.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        toolMenu.add(notepadMenuItem);// Ӧ�ò˵���
        
        JMenuItem calculatorMemoMenuItem = new JMenuItem("������");// �����˵���
        calculatorMemoMenuItem.addActionListener(new ActionListener() {// �����˵����¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_calculatorMemoMenuItem_actionPerformed(e);
                    }
                });
        calculatorMemoMenuItem.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        toolMenu.add(calculatorMemoMenuItem);// Ӧ�ò˵���
        
        contentPane = new JPanel() {
            /**
             * 
             */
            private static final long serialVersionUID = 2179076594345705736L;
            
            @Override
            public void paint(Graphics g) {
                super.paint(g);// ���ø��๹�췽��
                Graphics2D g2 = (Graphics2D) g;// ���Graphics2D����
                String str = "����¼ģ��";// ����Ҫ��ʾ���ַ���
                Font font = new Font("����", Font.BOLD | Font.ITALIC, 40);// ����������
                g2.setFont(font);// Ӧ������
                for (int i = 0; i < str.length(); i++) {
                    g2.setColor(Color.GRAY); // ����ǰ��ɫ
                    g2.drawString(str.charAt(i) + "", 50 + i * font.getSize(), 50 + i * font.getSize()); // ��ָ��λ�û����ı�
                    g2.drawString(str.charAt(i) + "", 370 - i * font.getSize(), 50 + i * font.getSize()); // ��ָ��λ�û����ı�
                }
                for (int i = 0; i < str.length(); i++) {
                    g2.setColor(Color.MAGENTA); // ����ǰ��ɫ
                    g2.drawString(str.charAt(i) + "", 40 + i * font.getSize(), 40 + i * font.getSize()); // ��ָ��λ�û����ı�
                    g2.drawString(str.charAt(i) + "", 360 - i * font.getSize(), 40 + i * font.getSize()); // ��ָ��λ�û����ı�
                }
            }
        };
        setContentPane(contentPane);// Ӧ�����
        
        setLocation(WindowUtil.getLocation());// ���ô�����ʾλ��
        setSize(WindowUtil.getSize());// ���ô����С
    }
    
    // ������ӱ���¼���˵����¼�
    protected void do_addMemoMenuItem_actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MemoAddtionFrame frame = new MemoAddtionFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    // �����޸ı���¼���˵����¼�
    protected void do_modifyMemoMemuItem_actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MemoModificationFrame frame = new MemoModificationFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    // ������ѯ����¼���˵����¼�
    protected void do_queryMemoMenuItem_actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MemoQueryFrame frame = new MemoQueryFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    // ����ɾ������¼���˵����¼�
    protected void do_deleteMemoMenuItem_actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MemoDeletionFrame frame = new MemoDeletionFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    // �������±����˵����¼�
    protected void do_notepadMenuItem_actionPerformed(ActionEvent e) {
        Runtime runTime = Runtime.getRuntime();// ���Runtime���Ͷ���
        try {
            runTime.exec("notepad");// ִ��notepad����򿪼��±�
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    // �������������˵����¼�
    protected void do_calculatorMemoMenuItem_actionPerformed(ActionEvent e) {
        Runtime runTime = Runtime.getRuntime();// ���Runtime���Ͷ���
        try {
            runTime.exec("calc");// ִ��calc����򿪼�����
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
