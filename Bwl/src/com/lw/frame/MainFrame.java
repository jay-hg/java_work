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
        try {// 设置窗体外观
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainFrame frame = new MainFrame();// 创建窗体对象
                    frame.setVisible(true);// 设置窗体可见
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
        setTitle("备忘录模块");// 设置窗体标题
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭窗体时退出程序
        
        JMenuBar menuBar = new JMenuBar();// 创建菜单条
        setJMenuBar(menuBar);// 应用菜单条
        
        JMenu memoManagementMenu = new JMenu("备忘录管理");// 创建菜单
        memoManagementMenu.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        menuBar.add(memoManagementMenu);// 应用菜单
        
        JMenuItem addMemoMenuItem = new JMenuItem("增加备忘录");// 创建菜单项
        addMemoMenuItem.addActionListener(new ActionListener() {// 监听菜单项事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_addMemoMenuItem_actionPerformed(e);
                    }
                });
        addMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        memoManagementMenu.add(addMemoMenuItem);// 应用菜单项
        
        JMenuItem modifyMemoMemuItem = new JMenuItem("修改备忘录");// 创建菜单项
        modifyMemoMemuItem.addActionListener(new ActionListener() {// 监听菜单项事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_modifyMemoMemuItem_actionPerformed(e);
                    }
                });
        modifyMemoMemuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        memoManagementMenu.add(modifyMemoMemuItem);// 应用菜单项
        
        JMenuItem queryMemoMenuItem = new JMenuItem("查询备忘录");// 创建菜单项
        queryMemoMenuItem.addActionListener(new ActionListener() {// 监听菜单项事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_queryMemoMenuItem_actionPerformed(e);
                    }
                });
        queryMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        memoManagementMenu.add(queryMemoMenuItem);// 应用菜单项
        
        JMenuItem deleteMemoMenuItem = new JMenuItem("删除备忘录");// 创建菜单项
        deleteMemoMenuItem.addActionListener(new ActionListener() {// 监听菜单项事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_deleteMemoMenuItem_actionPerformed(e);
                    }
                });
        deleteMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        memoManagementMenu.add(deleteMemoMenuItem);// 应用菜单项
        
        JMenu toolMenu = new JMenu("小工具");// 创建菜单
        toolMenu.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        menuBar.add(toolMenu);// 应用菜单
        
        JMenuItem notepadMenuItem = new JMenuItem("记事本");// 创建菜单项
        notepadMenuItem.addActionListener(new ActionListener() {// 监听菜单项事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_notepadMenuItem_actionPerformed(e);
                    }
                });
        notepadMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        toolMenu.add(notepadMenuItem);// 应用菜单项
        
        JMenuItem calculatorMemoMenuItem = new JMenuItem("计算器");// 创建菜单项
        calculatorMemoMenuItem.addActionListener(new ActionListener() {// 监听菜单项事件
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        do_calculatorMemoMenuItem_actionPerformed(e);
                    }
                });
        calculatorMemoMenuItem.setFont(new Font("微软雅黑", Font.PLAIN, 15));// 设置字体
        toolMenu.add(calculatorMemoMenuItem);// 应用菜单项
        
        contentPane = new JPanel() {
            /**
             * 
             */
            private static final long serialVersionUID = 2179076594345705736L;
            
            @Override
            public void paint(Graphics g) {
                super.paint(g);// 调用父类构造方法
                Graphics2D g2 = (Graphics2D) g;// 获得Graphics2D对象
                String str = "备忘录模块";// 设置要显示的字符串
                Font font = new Font("隶书", Font.BOLD | Font.ITALIC, 40);// 创建新字体
                g2.setFont(font);// 应用字体
                for (int i = 0; i < str.length(); i++) {
                    g2.setColor(Color.GRAY); // 设置前景色
                    g2.drawString(str.charAt(i) + "", 50 + i * font.getSize(), 50 + i * font.getSize()); // 在指定位置绘制文本
                    g2.drawString(str.charAt(i) + "", 370 - i * font.getSize(), 50 + i * font.getSize()); // 在指定位置绘制文本
                }
                for (int i = 0; i < str.length(); i++) {
                    g2.setColor(Color.MAGENTA); // 设置前景色
                    g2.drawString(str.charAt(i) + "", 40 + i * font.getSize(), 40 + i * font.getSize()); // 在指定位置绘制文本
                    g2.drawString(str.charAt(i) + "", 360 - i * font.getSize(), 40 + i * font.getSize()); // 在指定位置绘制文本
                }
            }
        };
        setContentPane(contentPane);// 应用面板
        
        setLocation(WindowUtil.getLocation());// 设置窗体显示位置
        setSize(WindowUtil.getSize());// 设置窗体大小
    }
    
    // 处理“添加备忘录”菜单项事件
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
    
    // 处理“修改备忘录”菜单项事件
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
    
    // 处理“查询备忘录”菜单项事件
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
    
    // 处理“删除备忘录”菜单项事件
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
    
    // 处理“记事本”菜单项事件
    protected void do_notepadMenuItem_actionPerformed(ActionEvent e) {
        Runtime runTime = Runtime.getRuntime();// 获得Runtime类型对象
        try {
            runTime.exec("notepad");// 执行notepad命令打开记事本
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    
    // 处理“计算器”菜单项事件
    protected void do_calculatorMemoMenuItem_actionPerformed(ActionEvent e) {
        Runtime runTime = Runtime.getRuntime();// 获得Runtime类型对象
        try {
            runTime.exec("calc");// 执行calc命令打开计算器
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
