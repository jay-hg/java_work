package com.summer.shopping.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Mail {
    String host = "";
    String user = "";
    String password = "";
    public void setHost(String host) {
        this.host = host;
    }
    public void setAccount(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public void send(String from, String to, String subject, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host); // ָ��SMTP������
        props.put("mail.smtp.auth", "true"); // ָ���Ƿ���ҪSMTP��֤
        try {
            Session mailSession = Session.getDefaultInstance(props);
            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from)); // ������
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // �ռ���
            message.setSubject(subject); // �ʼ�����
            message.setContent(content, "text/html;charset=utf-8");
            //message.setText(content); // �ʼ�����
            message.saveChanges();
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(host, user, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Mail sm = new Mail();
        sm.setHost("smtp.qq.com"); // ָ��Ҫʹ�õ��ʼ�������
        sm.setAccount("2468328461@qq.com", "tymm*wzqq5106"); // ָ���ʺź�����
        /*
* @param String �����˵ĵ�ַ
* 
* @param String �ռ��˵�ַ
* 
* @param String �ʼ�����
* 
* @param String �ʼ�����
*/
        sm.send("2468328461@qq.com", "1175867101@qq.com", "hello", "<br>Hellor,World!<hr>");
    }
}