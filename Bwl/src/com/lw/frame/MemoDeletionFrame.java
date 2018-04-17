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
        setTitle("删除备忘录");// 设置窗体标题
        contentPane = new JPanel();// 创建面板
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);// 应用面板
        
        JPanel othersPanel = new JPanel();// 创建面板
        contentPane.add(othersPanel, BorderLayout.NORTH);// 应用面板
        othersPanel.setLayout(new GridLayout(2, 1, 5, 5));// 为面板设置网格布局
        
        JPanel nttPanel = new JPanel();// 创建面板
        nttPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
        FlowLayout fl_nttPanel = (FlowLayout) nttPanel.getLayout();// 获得面板布局
        fl_nttPanel.setAlignment(FlowLayout.LEFT);// 面板中控件采用左对齐
        othersPanel.add(nttPanel);// 应用面板
        
        JLabel usernameLabel = new JLabel("姓名：");// 创建标签
        usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        nttPanel.add(usernameLabel);// 应用标签
        
        usernameTextField = new JTextField();// 创建文本域
        usernameTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        nttPanel.add(usernameTextField);// 应用文本域
        usernameTextField.setColumns(6);// 设置文本域宽度
        
        JLabel memotypeLabel = new JLabel("类型：");// 创建标签
        memotypeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        nttPanel.add(memotypeLabel);// 应用标签
        
        memotypeTextField = new JTextField();// 创建文本域
        memotypeTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        nttPanel.add(memotypeTextField);// 应用文本域
        memotypeTextField.setColumns(6);// 设置文本域宽度
        
        JLabel memotimeLabel = new JLabel("时间：");// 创建标签
        memotimeLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        nttPanel.add(memotimeLabel);// 应用标签
        
        memotimeTextField = new JTextField();// 创建文本域
        memotimeTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        nttPanel.add(memotimeTextField);// 应用文本域
        memotimeTextField.setColumns(6);// 设置文本域宽度
        
        JPanel titlePanel = new JPanel();// 创建面板
        titlePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
        FlowLayout fl_titlePanel = (FlowLayout) titlePanel.getLayout();// 获得面板布局
        fl_titlePanel.setAlignment(FlowLayout.LEFT);// 面板中控件采用左对齐
        othersPanel.add(titlePanel);// 应用面板
        
        JLabel titleLabel = new JLabel("主题：");// 创建标签
        titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        titlePanel.add(titleLabel);// 应用标签
        
        titleTextField = new JTextField();// 创建文本域
        titleTextField.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        titlePanel.add(titleTextField);// 应用文本域
        titleTextField.setColumns(28);// 设置文本域宽度
        
        JPanel contentPanel = new JPanel();// 创建面板
        contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
        FlowLayout fl_contentPanel = (FlowLayout) contentPanel.getLayout();// 获得面板布局
        fl_contentPanel.setAlignment(FlowLayout.LEFT);// 面板中控件采用左对齐
        contentPane.add(contentPanel, BorderLayout.CENTER);// 应用面板
        
        JLabel contentLabel = new JLabel("内容：");// 创建标签
        contentLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        contentPanel.add(contentLabel);// 应用标签
        
        contentTextArea = new JTextArea();// 创建文本区
        contentTextArea.setColumns(28);// 设置文本区列数
        contentTextArea.setLineWrap(true);// 设置文本区自动换行
        contentTextArea.setRows(5);// 设置文本区行数
        contentTextArea.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        JScrollPane contentScrollPane = new JScrollPane(contentTextArea);// 使用文本区创建滚动窗格
        contentPanel.add(contentScrollPane);// 应用滚动窗格
        
        JPanel buttonPanel = new JPanel();// 创建面板
        buttonPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));// 设置面板的边框
        contentPane.add(buttonPanel, BorderLayout.SOUTH);// 应用面板
        
        JButton previousButton = new JButton("上一条");// 创建“上一条”按钮
        previousButton.addActionListener(new ActionListener() {// 监听按钮事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_previousButton_actionPerformed(e);
                    }
                });
        previousButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        buttonPanel.add(previousButton);// 应用按钮
        
        JButton nextButton = new JButton("下一条");// 创建“下一条”按钮
        nextButton.addActionListener(new ActionListener() {// 监听按钮事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_nextButton_actionPerformed(e);
                    }
                });
        nextButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        buttonPanel.add(nextButton);// 应用按钮
        
        JButton deleteButton = new JButton("删除");// 创建“删除”按钮
        deleteButton.addActionListener(new ActionListener() {// 监听按钮事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_deleteButton_actionPerformed(e);
                    }
                });
        deleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        buttonPanel.add(deleteButton);
        
        JButton returnButton = new JButton("返回");// 创建“返回”按钮
        returnButton.addActionListener(new ActionListener() {// 监听按钮事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_returnButton_actionPerformed(e);
                    }
                });
        returnButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        buttonPanel.add(returnButton);
        
        setLocation(WindowUtil.getLocation());// 设置窗体显示位置
        setSize(WindowUtil.getSize());// 设置窗体大小
        
        results = JdbcHelper.queryAll();// 获得数据库中保存的备忘录信息
        updateContent(index);
    }
    
    // 根据MemoBean对象填写控件内容
    private void updateContent(int index) {
        MemoBean memo = results.get(index);// 获得第index条备忘录信息
        usernameTextField.setText(memo.getUsername());
        titleTextField.setText(memo.getTitle());
        contentTextArea.setText(memo.getContent());
        memotypeTextField.setText(memo.getMemotype());
        memotimeTextField.setText(memo.getMemotime());
    }
    
    // 处理“上一条”按钮事件
    protected void do_previousButton_actionPerformed(ActionEvent e) {
        if (index <= 0) {
            JOptionPane.showMessageDialog(this, "已经是第一条记录！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        updateContent(--index);
    }
    
    // 处理“下一条”按钮事件
    protected void do_nextButton_actionPerformed(ActionEvent e) {
        if (index >= (results.size() - 1)) {
            JOptionPane.showMessageDialog(this, "已经是最后一条记录！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
        updateContent(++index);
    }
    
    // 处理“删除”按钮事件
    protected void do_deleteButton_actionPerformed(ActionEvent e) {
        JdbcHelper.delete(results.get(index));
        results.remove(index);// 删除当前记录
        if (index != 0) {
            index--;
        }
        if (results.size() == 0) {// 如果表格中已经没有数据，则提示用户
            usernameTextField.setText("");
            titleTextField.setText("");
            contentTextArea.setText("");
            memotypeTextField.setText("");
            memotimeTextField.setText("");
            JOptionPane.showMessageDialog(this, "备忘录为空！", "", JOptionPane.WARNING_MESSAGE);
            return;
        } else {// 否则使用前一条记录填充控件
            updateContent(index);
            JOptionPane.showMessageDialog(this, "备忘录删除成功！", "", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }
    
    // 处理“返回”按钮事件
    protected void do_returnButton_actionPerformed(ActionEvent e) {
        dispose();
    }
}
