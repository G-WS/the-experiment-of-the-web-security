import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.util.Properties;

public class Test {
    public void send() throws Exception {
        Properties p = new Properties();
        p.setProperty("mail.debug", "true");
        p.setProperty("mail.smtp.host", "smtp.163.com");
        p.setProperty("mail.transport.protocol", "smtp");
        p.setProperty("mail.smtp.auth", "true");
        MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
        mailSSLSocketFactory.setTrustAllHosts(true);
        p.put("mail.smtp.ssl.enable", "true");
        p.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);
        Session session = Session.getInstance(p);
        Transport transport = session.getTransport();
        transport.connect("smtp.163.com", "发送端的163邮箱", "BKWGHWJTNQJNFJNF");
        MimeMessage mimeMessage = new MimeMessage(session);
        mimeMessage.setFrom(new InternetAddress("发送端的163邮箱"));
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("接收端的邮箱"));
        mimeMessage.setSubject(“邮件主题");
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent("邮件正文", "text/html;charset = utf-8");
        MimeBodyPart mimeBodyPart1 = new MimeBodyPart();
        mimeBodyPart1.setDataHandler(new DataHandler(new FileDataSource("E:\\网络攻防\\smtp.txt")));
        mimeBodyPart1.setFileName(MimeUtility.encodeText("测试文件.txt"));
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(mimeBodyPart);
        mimeMultipart.addBodyPart(mimeBodyPart1);
        mimeMessage.setContent(mimeMultipart);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
    }

}
