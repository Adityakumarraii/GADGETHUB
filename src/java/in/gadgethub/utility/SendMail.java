package in.gadgethub.utility;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class MyAuthenticator1 extends Authenticator {

    private String username, password;

    public MyAuthenticator1(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.username, this.password);
    }
}

public class SendMail {

    public static void main(String[] args) {
        final String username = "kumarraiaditya476@gmail.com"; // Replace with your email
        final String password = "ukde vxfm bddt mbki"; // Replace with your app password (if 2FA enabled)

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587"); // Use 587 for TLS
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS for security

        MyAuthenticator1 myAuth = new MyAuthenticator1(username, password);
        Session session = Session.getInstance(prop, myAuth);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));  // Set the sender's email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("kumarraiaditya476@gmail.com"));
            message.setSubject("Email testing");
            message.setText("Good morning");

            // Debugging: Uncomment if you want to see the session debug output
            // session.setDebug(true);

            Transport.send(message);
            System.out.println("Mail sent successfully");
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}