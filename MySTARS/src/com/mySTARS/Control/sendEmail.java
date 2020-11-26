package com.mySTARS.Control;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class sendEmail {
	public static void sendmail(String toEmail, String subject, String body){
		try
	    {			
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("bobr4661@gmail.com", "Catdog123");
				}
			};	
			
			Session session = Session.getInstance(props, auth);
		
			MimeMessage msg = new MimeMessage(session);
			//set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));

			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(body, "UTF-8");

	      	msg.setSentDate(new Date());

	      	msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
	      	System.out.println("Constructing email");
    	  	Transport.send(msg);  

	      	System.out.println("EMail Sent Successfully!!");
	    }
	   	catch (Exception e) {
	   		e.printStackTrace();
	   	}
	}
}
