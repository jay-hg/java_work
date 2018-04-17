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
        props.put("mail.smtp.host", host); // 指定SMTP服务器
        props.put("mail.smtp.auth", "true"); // 指定是否需要SMTP验证
        try {
            Session mailSession = Session.getDefaultInstance(props);
            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from)); // 发件人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 收件人
            message.setSubject(subject); // 邮件主题
            message.setContent(content, "text/html;charset=utf-8");
            //message.setText(content); // 邮件内容
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
        sm.setHost("smtp.qq.com"); // 指定要使用的邮件服务器
        sm.setAccount("2468328461@qq.com", "tymm*wzqq5106"); // 指定帐号和密码
        /*
* @param String 发件人的地址
* 
* @param String 收件人地址
* 
* @param String 邮件标题
* 
* @param String 邮件正文
*/
        sm.send("2468328461@qq.com", "1175867101@qq.com", "hello", "<br>Hellor,World!<hr>");
    }
}