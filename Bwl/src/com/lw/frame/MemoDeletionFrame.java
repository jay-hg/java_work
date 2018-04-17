package com.lw.frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
import com.lw.util.WindowUtil;

public class MemoDeletionFrame extends JFrame {
    
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
    private List<MemoBean> results;
    private int index;
    
    /**
     * Create the frame.
     */
    public MemoDeletionFrame() {
        setTitle("ɾ������¼");// ���ô������
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
        usernameTextField.setColumns(6);// �����ı�����
        
        JLabel memotypeLabel = new JLabel("���ͣ�");// ������ǩ
        memotypeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(memotypeLabel);// Ӧ�ñ�ǩ
        
        memotypeTextField = new JTextField();// �����ı���
        memotypeTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(memotypeTextField);// Ӧ���ı���
        memotypeTextField.setColumns(6);// �����ı�����
        
        JLabel memotimeLabel = new JLabel("ʱ�䣺");// ������ǩ
        memotimeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(memotimeLabel);// Ӧ�ñ�ǩ
        
        memotimeTextField = new JTextField();// �����ı���
        memotimeTextField.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        nttPanel.add(memotimeTextField);// Ӧ���ı���
        memotimeTextField.setColumns(6);// �����ı�����
        
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
        titleTextField.setColumns(28);// �����ı�����
        
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
        
        JButton previousButton = new JButton("��һ��");// ��������һ������ť
        previousButton.addActionListener(new ActionListener() {// ������ť�¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_previousButton_actionPerformed(e);
                    }
                });
        previousButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        buttonPanel.add(previousButton);// Ӧ�ð�ť
        
        JButton nextButton = new JButton("��һ��");// ��������һ������ť
        nextButton.addActionListener(new ActionListener() {// ������ť�¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_nextButton_actionPerformed(e);
                    }
                });
        nextButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        buttonPanel.add(nextButton);// Ӧ�ð�ť
        
        JButton deleteButton = new JButton("ɾ��");// ������ɾ������ť
        deleteButton.addActionListener(new ActionListener() {// ������ť�¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_deleteButton_actionPerformed(e);
                    }
                });
        deleteButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        buttonPanel.add(deleteButton);
        
        JButton returnButton = new JButton("����");// ���������ء���ť
        returnButton.addActionListener(new ActionListener() {// ������ť�¼�
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_returnButton_actionPerformed(e);
                    }
                });
        returnButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));// ��������
        buttonPanel.add(returnButton);
        
        setLocation(WindowUtil.getLocation());// ���ô�����ʾλ��
        setSize(WindowUtil.getSize());// ���ô����С
        
        results = JdbcHelper.queryAll();// ������ݿ��б���ı���¼��Ϣ
        updateContent(index);
    }
    
    // ����MemoBean������д�ؼ�����
    private void updateContent(int index) {
        MemoBean memo = results.get(index);// ��õ�index������¼��Ϣ
        usernameTextField.setText(memo.getUsername());
        titleTextField.setText(memo.getTitle());
        contentTextArea.setText(memo.getContent());
        memotypeTextField.setText(memo.getMemotype());
        memotimeTextField.setText(memo.getMemotime());
    }
    
    // ������һ������ť�¼�
    protected void do_previousButton_actionPerformed(ActionEvent e) {
        if (index <= 0) {
            JOptionPane.showMessageDialog(this, "�Ѿ��ǵ�һ����¼��", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        updateContent(--index);
    }
    
    // ������һ������ť�¼�
    protected void do_nextButton_actionPerformed(ActionEvent e) {
        if (index >= (results.size() - 1)) {
            JOptionPane.showMessageDialog(this, "�Ѿ������һ����¼��", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        updateContent(++index);
    }
    
    // ����ɾ������ť�¼�
    protected void do_deleteButton_actionPerformed(ActionEvent e) {
        JdbcHelper.delete(results.get(index));
        results.remove(index);// ɾ����ǰ��¼
        if (index != 0) {
            index--;
        }
        if (results.size() == 0) {// ���������Ѿ�û�����ݣ�����ʾ�û�
            usernameTextField.setText("");
            titleTextField.setText("");
            contentTextArea.setText("");
            memotypeTextField.setText("");
            memotimeTextField.setText("");
            JOptionPane.showMessageDialog(this, "����¼Ϊ�գ�", "", JOptionPane.WARNING_MESSAGE);
            return;
        } else {// ����ʹ��ǰһ����¼���ؼ�
            updateContent(index);
            JOptionPane.showMessageDialog(this, "����¼ɾ���ɹ���", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
    
    // �������ء���ť�¼�
    protected void do_returnButton_actionPerformed(ActionEvent e) {
        dispose();
    }
}
