package com.lw.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.lw.bean.MemoBean;
import com.lw.dao.JdbcHelper;
import com.lw.util.ValidationUtil;
import com.lw.util.WindowUtil;

public class MemoAddtionFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -8951877525199787116L;
    private JPanel contentPane;
    private JTextField usernameTextField;
    private JTextField memotypeTextField;
    private JTextField memotimeTextField;
    private JTextField titleTextField;
    private JTextArea contentTextArea;
    
    /**
     * Create the frame.
     */
    public MemoAddtionFrame() {
        setTitle("���ӱ���¼");// ���ô������
        contentPane = new JPanel();// �������
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// Ӧ�����
        
        JPanel othersPanel = new JPanel();// �������
        contentPane.add(othersPanel, BorderLayout.NORTH);// Ӧ�����
        othersPanel.setLayout(new GridLayout(2, 1, 5, 5));// Ϊ����������񲼾�
        
        JPanel nttPanel = new JPanel();// �������
        nttPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
        FlowLayout fl_nttPanel = (FlowLayout) nttPanel.getLayout();// �����岼��
        fl_nttPanel.setAlignment(FlowLayout.LEFT);// ����пؼ����������
        othersPanel.add(nttPanel);// Ӧ�����
        
        JLabel usernameLabel = new JLabel("������");// ������ǩ
        usernameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(usernameLabel);// Ӧ�ñ�ǩ
        
        usernameTextField = new JTextField();// �����ı���
        usernameTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(usernameTextField);// Ӧ���ı���
        usernameTextField.setColumns(6);// �����ı������
        
        JLabel memotypeLabel = new JLabel("���ͣ�");// ������ǩ
        memotypeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(memotypeLabel);// Ӧ�ñ�ǩ
        
        memotypeTextField = new JTextField();// �����ı���
        memotypeTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(memotypeTextField);// Ӧ���ı���
        memotypeTextField.setColumns(6);// �����ı������
        
        JLabel memotimeLabel = new JLabel("ʱ�䣺");// ������ǩ
        memotimeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(memotimeLabel);// Ӧ�ñ�ǩ
        
        memotimeTextField = new JTextField();// �����ı���
        memotimeTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(memotimeTextField);// Ӧ���ı���
        memotimeTextField.setColumns(6);// �����ı������
        
        JPanel titlePanel = new JPanel();// �������
        titlePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
        FlowLayout fl_titlePanel = (FlowLayout) titlePanel.getLayout();// �����岼��
        fl_titlePanel.setAlignment(FlowLayout.LEFT);// ����пؼ����������
        othersPanel.add(titlePanel);// Ӧ�����
        
        JLabel titleLabel = new JLabel("���⣺");// ������ǩ
        titleLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        titlePanel.add(titleLabel);// Ӧ�ñ�ǩ
        
        titleTextField = new JTextField();// �����ı���
        titleTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        titlePanel.add(titleTextField);// Ӧ���ı���
        titleTextField.setColumns(28);// �����ı������
        
        JPanel contentPanel = new JPanel();// �������
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
        FlowLayout fl_contentPanel = (FlowLayout) contentPanel.getLayout();// �����岼��
        fl_contentPanel.setAlignment(FlowLayout.LEFT);// ����пؼ����������
        contentPane.add(contentPanel, BorderLayout.CENTER);// Ӧ�����
        
        JLabel contentLabel = new JLabel("���ݣ�");// ������ǩ
        contentLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        contentPanel.add(contentLabel);// Ӧ�ñ�ǩ
        
        contentTextArea = new JTextArea();// �����ı���
        contentTextArea.setColumns(28);// �����ı�������
        contentTextArea.setLineWrap(true);// �����ı����Զ�����
        contentTextArea.setRows(5);// �����ı�������
        contentTextArea.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        JScrollPane contentScrollPane = new JScrollPane(contentTextArea);// ʹ���ı���������������
        contentPanel.add(contentScrollPane);// Ӧ�ù�������
        
        JPanel buttonPanel = new JPanel();// �������
        buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// �������ı߿�
        contentPane.add(buttonPanel, BorderLayout.SOUTH);// Ӧ�����
        
        JButton saveButton = new JButton("����");// ���������桱��ť
        saveButton.addActionListener(new ActionListener() {// ������ť�¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_saveButton_actionPerformed(e);
                    }
                });
        saveButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        buttonPanel.add(saveButton);// Ӧ�ð�ť
        
        JButton clearButton = new JButton("���");// ��������ա���ť
        clearButton.addActionListener(new ActionListener() {// ������ť�¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_clearButton_actionPerformed(e);
                    }
                });
        clearButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        buttonPanel.add(clearButton);// Ӧ�ð�ť
        
        JButton returnButton = new JButton("����");// ���������ء���ť
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_returnButton_actionPerformed(e);
            }
        });
        returnButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        buttonPanel.add(returnButton);// Ӧ�ð�ť
        
        setLocation(WindowUtil.getLocation());// ���ô�����ʾλ��
        setSize(WindowUtil.getSize());// ���ô����С
    }
    
    // ���������桱��ť�¼�
    protected void do_saveButton_actionPerformed(ActionEvent e) {
        String username = usernameTextField.getText().trim();
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "��������Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String title = titleTextField.getText().trim();
        if (title.isEmpty()) {
            JOptionPane.showMessageDialog(this, "���ⲻ��Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String content = contentTextArea.getText().trim();
        if (content.isEmpty()) {
            JOptionPane.showMessageDialog(this, "���ݲ���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String memotype = memotypeTextField.getText().trim();
        if (memotype.isEmpty()) {
            JOptionPane.showMessageDialog(this, "���Ͳ���Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String memotime = memotimeTextField.getText().trim();
        if (memotime.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ʱ�䲻��Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!ValidationUtil.validateTimeFormat(memotime)) {
            JOptionPane.showMessageDialog(this, "���ڸ�ʽΪ2010-12-22��ʽ��", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        MemoBean memo = new MemoBean();// ����MemoBean
        memo.setUsername(username);
        memo.setTitle(title);
        memo.setContent(content);
        memo.setMemotype(memotype);
        memo.setMemotime(memotime);
        int result = JdbcHelper.save(memo);// ���汸��¼��Ϣ
        if (result >= 0) {
            JOptionPane.showMessageDialog(this, "����¼���ӳɹ���");
            return;
        } else {
            JOptionPane.showMessageDialog(this, "����¼����ʧ�ܣ�");
            return;
        }
    }
    
    // ��������ա���ť�¼�
    protected void do_clearButton_actionPerformed(ActionEvent e) {
        usernameTextField.setText("");
        titleTextField.setText("");
        contentTextArea.setText("");
        memotypeTextField.setText("");
        memotimeTextField.setText("");
    }
    
    // ���������ء���ť�¼�
    protected void do_returnButton_actionPerformed(ActionEvent e) {
        dispose();
    }
}