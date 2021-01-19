package com.xiaofan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class Springboot10TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("文飞扬你好呀~");
        simpleMailMessage.setText("你这家伙又在玩游戏了？？");
        simpleMailMessage.setTo("594042358@qq.com");
        simpleMailMessage.setFrom("594042358@qq.com");
        mailSender.send(simpleMailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        // 一个复杂的邮件~
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // 正文
        helper.setSubject("雪山飞狐你好呀~plus");
        helper.setText("<p style='color:red'>你这家伙又在玩游戏了？？</p>", true);

        // 添加附件
        helper.addAttachment("abc.jpg", new File("C:\\Users\\59404\\Pictures\\images\\jar\\abc.jpg"));

        helper.setTo("594042358@qq.com");
        helper.setFrom("594042358@qq.com");


        mailSender.send(mimeMessage);
    }

}
