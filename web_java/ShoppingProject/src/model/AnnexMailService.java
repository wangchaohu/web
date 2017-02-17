package model;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Created by wangchaohu on 2017/2/17.
 */

public class AnnexMailService {


    public static boolean sendMail(String subject, String toMail,
                                   String content, String... files) {
        boolean isFlag = false;
        try {

            String smtpFromMail = "2603653389@qq.com";  //账号
            String pwd = "huangfei"; //密码
            int port = 25; //端口
            String host = "smtp.qq.com"; //端口

            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props);
            session.setDebug(false);

            MimeMessage message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(smtpFromMail, "QQ邮件测试"));
                message.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(toMail));
                message.setSubject(subject);
                message.addHeader("charset", "UTF-8");

                /*添加正文内容*/
                Multipart multipart = new MimeMultipart();
                BodyPart contentPart = new MimeBodyPart();
                contentPart.setText(content);

                contentPart.setHeader("Content-Type", "text/html; charset=GBK");
                multipart.addBodyPart(contentPart);

                /*添加附件*/
                for (String file : files) {
                    File usFile = new File(file);
                    MimeBodyPart fileBody = new MimeBodyPart();
                    DataSource source = new FileDataSource(file);
                    fileBody.setDataHandler(new DataHandler(source));
                    sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
                    fileBody.setFileName("=?GBK?B?"
                            + enc.encode(usFile.getName().getBytes()) + "?=");
                    multipart.addBodyPart(fileBody);
                }

                message.setContent(multipart);
                message.setSentDate(new Date());
                message.saveChanges();
                Transport transport = session.getTransport("smtp");

                transport.connect(host, port, smtpFromMail, pwd);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
                isFlag = true;
            } catch (Exception e) {
                isFlag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isFlag;
    }
}
