package com.adnaloy.librosykekas.basics;

import com.adnaloy.librosykekas.basics.interfaces.EditorialFabLocal;
import com.adnaloy.librosykekas.basics.interfaces.SendMailLocal;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;




/**
 * Session Bean implementation class SendMail
 */
@Stateless(mappedName = "SendMail")
@Local(SendMailLocal.class)
@LocalBean
public class SendMail implements SendMailLocal {
	
    // Recipient's email ID needs to be mentioned.
    private static final String to = "makegarcia57@gmail.com";
    // Sender's email ID needs to be mentioned
    private static final String from = "librosykekas@gmail.com";
    // Assuming you are sending email from localhost
    private static final String host = "smtp.gmail.com";
    
    private static final String port = "587";
    
    
    private String subject;
    private String text;
    

    public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	/**
     * Default constructor. 
     */
    public SendMail() {
        // TODO Auto-generated constructor stub
    }
    
    public void doIt() {
    	
    	// Get system properties
        Properties properties = System.getProperties();
        
        // Setup mail server
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		
		
        // Get the default Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("librosykekas@gmail.com", "junioari17");
            }

        });
        
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(text);

            // Send message
            Transport.send(message);

         } catch (MessagingException mex) {
            mex.printStackTrace();
         }
    }

}