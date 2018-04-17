package com.lw.util;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

public class WindowUtil {
    // �������С���ó�500��309
    public static Dimension getSize() {
        return new Dimension(500, 309);
    }
    
    // ���㴰�������ʾʱ���Ͻ�����
    public static Point getLocation() {
        Toolkit toolKit = Toolkit.getDefaultToolkit();// ���Toolkitʵ��
        Dimension screenSize = toolKit.getScreenSize();// �����ʾ����С
        if ((screenSize.width < getSize().width) || (screenSize.height < getSize().height)) {
            JOptionPane.showMessageDialog(null, "��ʾ���ֱ�������Ϊ500��309", "", JOptionPane.WARNING_MESSAGE);
            System.exit(0);// ��ֹ����
        }
        int x = (screenSize.width - getSize().width) / 2;// �������ϽǺ�����
        int y = (screenSize.height - getSize().height) / 2;// �������Ͻ�������
        return new Point(x, y);
    }
}
