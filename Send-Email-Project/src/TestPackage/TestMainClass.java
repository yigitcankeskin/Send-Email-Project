/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestPackage;

import Operations.FileOperations;
import Operations.MailOperations;
import java.util.ArrayList;

/**
 *
 * @author yc_ke
 */
public class TestMainClass {
    public static void main(String []args) throws Exception{
        String Recepient ="yc_keskin_2000@hotmail.com";
        String myAccountEmail="yigitcankkeskin@gmail.com";
        String password="yK.35915728460";
        String host = "pop.gmail.com";
        String mailStoreType ="pop3";
        //TestSentClass.sendMail(Recepient,myAccountEmail,password);
        //TestRecieveClass.check(host, mailStoreType, myAccountEmail, password);
         
        MailOperations.checkAllMails(host, mailStoreType, myAccountEmail, password);
        
       
       
        /*FileOperations.createFile();
        FileOperations.getFileInformations();
        FileOperations.addEmployeeFile("03", "mert", "yurt", "employee", "mert123", "yurt123","yigitcankkeskin@gmail.com","sasd@gmail.com");
        FileOperations.removeEmployeeFile("03","mert");
        FileOperations.readEmployeeFile();
        FileOperations.editEmployeeFile("02","can", "password",false,false,false,false,true);
        FileOperations.addEmployeeMail("02", "can", "differentMail@gmail.com");
        FileOperations.RemoveEmployeeMail("02","can","yc.keski@gmail.com");
        */
}
}
 