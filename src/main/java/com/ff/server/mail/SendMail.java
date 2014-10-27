package com.ff.server.mail;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 这里不做异常处理
 */
public class SendMail {
    public static void main(String[] args) throws Exception {
        // 发送器
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.163.com");
        sender.setPort(25); // 默认就是25
        sender.setUsername("max117@163.com");
        sender.setPassword("*****");
        sender.setDefaultEncoding("UTF-8");

        // 配置文件对象
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true"); // 是否进行验证
        Session session = Session.getInstance(props);
        sender.setSession(session); // 为发送器指定会话

        MimeMessage mail = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mail);
        helper.setTo("max117@163.com"); // 发送给谁
        helper.setSubject("测试邮件"); // 标题
        helper.setFrom("max117@163.com"); // 来自
        // 邮件内容，第二个参数指定发送的是HTML格式
        helper.setText("<font color='red'>这是一封测试邮件！</font>", true);

        sender.send(mail); // 发送

        System.out.println("邮件发送成功");
    }
}
