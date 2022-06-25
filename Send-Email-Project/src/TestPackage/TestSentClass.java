/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author yc_ke
 */
public class TestSentClass {
    public static void sendMail(String Recepient , String myAccountEmail , String password ) throws Exception{
        System.out.println("Message is preparing.");
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587   "); 

        
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password); //To change body of generated methods, choose Tools | Templates.
            }
        });
            Message message = prepareMessage(session,myAccountEmail,Recepient);
           
            Transport.send(message);
            System.out.println("Message sent succesfully.");
            
        
    }
    private static  Message prepareMessage(Session session, String myAccountEmail, String Recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(Recepient));
            message.setSubject("My first Mail From java app");
            message.setText("Hey There\n I'm Yigitcan Keskin And İts my first message from java app. I hope it dont happen last message from me. :) ");
             return message;  
            
             
        } catch (Exception ex) {
            Logger.getLogger(TestSentClass.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        return null;
            }
}
