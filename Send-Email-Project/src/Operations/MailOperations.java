/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import TestPackage.TestRecieveClass;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import org.apache.commons.mail.util.MimeMessageParser;

/**
 *
 * @author yc_ke
 */
public class MailOperations {
public static void sendMail(String Recepient,String Subject,String Text ) throws Exception{
        if(!Recepient.equals("")&&!Subject.equals("")&&!Text.equals("")&&Recepient.contains(".com")&&Recepient.contains("@")){
            
        
        String myAccountEmail="WRİTE YOUR MAİL";
        String password="*WRİTE YOUR PASSWORD* ";
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
            Message message = prepareMessage(session,myAccountEmail,Recepient,Subject,Text);
           
            Transport.send(message);
            System.out.println("Message sent succesfully.");
            JOptionPane.showMessageDialog(null, "Message sent succesfully.",
      "Hey!", JOptionPane.INFORMATION_MESSAGE); 
            
        }
        else if(Recepient.equals("")||Subject.equals("")||Text.equals("")){
           JOptionPane.showMessageDialog(null, "You cannot sent emply mail.",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
        }
        else{
             JOptionPane.showMessageDialog(null, "You Shold enter true form mail.",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
        }
    }
private static  Message prepareMessage(Session session, String myAccountEmail, String Recepient,String Subject,String Text) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(Recepient));
            message.setSubject(Subject);
            message.setText(Text);
             return message;  
            
             
        } catch (Exception ex) {
            Logger.getLogger(MailOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        return null;
            }
    
public static void check(String host , String storeType , String user , String password) throws Exception{
        
        try {
            
            
            System.out.println("Message is preparing.");
            Properties properties = new Properties();
            
            properties.put("mail.pop3.host", host );
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            
            Session emailSession = Session.getDefaultInstance(properties); // Bir oturum aç ve oturum için gerekli bilgileri properties nesnesinden al.

            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);
            //Folder object for open ınbox
            
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            
            //get the messages 
            Message messages [] = emailFolder.getMessages();
            
            int i = ((messages.length)-1);
            
             Message message = messages[i];
            System.out.println("Email Number "+ (i+1));
            System.out.println("Subject : "+message.getSubject());
            System.out.println("From : "+message.getFrom()[0]);
            System.out.println("Text : "+readPlainContent((MimeMessage) message));
            
            
           
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(TestRecieveClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       System.out.println("Message was created.");
        
    }
public static Message[] checkAllMails(String host , String storeType , String user , String password) throws Exception{
    Message messages [] = null;   
    try {
          System.out.println("Mails preparing..");
            Properties properties = new Properties();
            
            properties.put("mail.pop3.host", host );
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            
            Session emailSession = Session.getDefaultInstance(properties); // Bir oturum aç ve oturum için gerekli bilgileri properties nesnesinden al.

            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);
            //Folder object for open ınbox
            
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            
            //get the messages 
            messages = emailFolder.getMessages();
            /*for(int j=1;j<=messages.length;j++){
            int i = ((messages.length)-j);
            
            Message message = messages[i];
            /*System.out.println("Email Number "+ (i+1));
            System.out.println("Subject : "+message.getSubject());
            System.out.println("From : "+message.getFrom()[0]);
            System.out.println("Text : "+readPlainContent((MimeMessage) message));    
            }
            */
             System.out.println("Message was created.");
            return messages;
            
           
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(TestRecieveClass.class.getName()).log(Level.SEVERE, null, ex);
        }
       
 return messages;
        
    }
public static String  readHtmlContent(MimeMessage message) throws Exception {
    return new MimeMessageParser(message).parse().getHtmlContent();
   }
public static String readPlainContent(MimeMessage message) throws Exception {
    return new MimeMessageParser(message).parse().getPlainContent();
   }
}    

