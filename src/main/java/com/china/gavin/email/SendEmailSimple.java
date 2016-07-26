package com.china.gavin.email;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendEmailSimple {

    public static void sendEmail() {
        SimpleEmail email = new SimpleEmail();
        email.setDebug(true);
        email.setHostName("smtp.yeah.net");
        email.setAuthentication("codertest@yeah.net", "123456^%$#@!");
        
        try {
            email.setFrom("codertest@yeah.net");
            email.addTo("gordon.li@vipshop.com");
            //email.addCc(email); //抄送方
            // email.addBcc(email); //秘密抄送方
            email.setCharset("UTF-8");
            email.setSubject("commons-email测试邮件");
            email.setMsg("测试邮件的内容！！！");
            String sendResult = email.send();
            System.out.println("发送结果 = " + sendResult);
        } catch (EmailException e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        sendEmail();
    }
}
