/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

/**
 *
 * @author Saldivar
 */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendMail {
    
        public static String to = "";
        public static String from = "noreply@shop.com";
        public static String messageMail = "Estimado cliente," + "\n\nUsted ha sido registrado!";
        public static String subject = "Bienvenido";
        public static String smtpServ = "smtp.gmail.com";
        public static String smtpPort = "587";
        
        public static void sendMail(String name,String to, String passwordUser){
                
		final String username = "correoproyectodad@gmail.com";
		final String password = "clavedeproyecto";
                messageMail += "\n\nHola " + name + "\n\nSu clave de acceso es: " + passwordUser;
                messageMail += "";
                
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtpServ);
		props.put("mail.smtp.port", smtpPort);

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(messageMail);
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
    
}
