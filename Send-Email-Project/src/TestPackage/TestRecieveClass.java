/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.mail.util.MimeMessageParser;

/**
 *
 * @author yc_ke
 */
public class TestRecieveClass {
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
            System.out.println(messages.length);
             Message message = messages[i];
            System.out.println("Email Number "+ (i+1));
            System.out.println("Subject : "+message.getSubject());
            System.out.println("From : "+message.getFrom()[0]);
            System.out.println("Text : "+readPlainContent((MimeMessage) message));
            
            
           
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(TestRecieveClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        
    }
    public static String  readHtmlContent(MimeMessage message) throws Exception {
    return new MimeMessageParser(message).parse().getHtmlContent();
   }

    public static String readPlainContent(MimeMessage message) throws Exception {
    return new MimeMessageParser(message).parse().getPlainContent();
   }
    
}
