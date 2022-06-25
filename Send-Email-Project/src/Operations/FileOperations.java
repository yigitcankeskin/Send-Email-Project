/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yc_ke
 */

public class FileOperations {
   public static void createFile(){
          File file = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");

        try {
            if(file.createNewFile()){
                System.out.println("File Created");
            }else{
                System.out.println("File Already Exists!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
   } 
   public static void getFileInformations(){
        File file = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");

        if(file.exists()){
            System.out.println("File Name : "+ file.getName());
            System.out.println("File Path : "+ file.getAbsolutePath());
            System.out.println("File Writable: "+ file.canWrite());
            System.out.println("File Readable: "+ file.canRead());
            System.out.println("File Length: "+ file.length()+" KB");
        }
    }
   public static Collection<Employee> readEmployeeFile(){
        File file = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
        
        ArrayList<Employee> empList = new ArrayList<Employee>();
       
        System.out.println("File Contents= ");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()){
                Employee emp = new Employee();
                emp.mails = new ArrayList<String>();
                String line = reader.nextLine();
                String[] values = line.split("///");
                emp.ıd=values[0];
                emp.name=values[1];
                emp.surname=values[2];
                emp.position=values[3];
                emp.userName=values[4];
                emp.Password=values[5];;
                values=values[6].split("&&&");
               for(int i = 0 ; i<values.length;i++){
                   emp.mails.add(values[i].trim());
               }
               empList.add(emp);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for(int i=0;i<empList.size();i++){
          System.out.println("ID : "+empList.get(i).ıd+"  Name   :"+empList.get(i).name+"   Surname   :"+empList.get(i).surname+"   Mails   :"+empList.get(i).mails);
        
        }
       
   return empList; 
   }
   
   public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail){
       Writer output;
       if(ıd.equals("")||name.equals("")||surname.equals("")||!(position.equals("Employee")||position.equals("Manager"))||userName.equals("")||password.equals("")||!mail.contains(".com")||!mail.contains("@")){
           JOptionPane.showMessageDialog(null, "You should make true form to your values",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
       }
       else{
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time

           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       removeEmptyLineFromFile();
       }
   }
    public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail1,String mail2){
       Writer output;
        System.out.println("calisti2");
        if(ıd.equals("")||name.equals("")||surname.equals("")||!(position.equals("Employee")||position.equals("Manager"))||userName.equals("")||password.equals("")||!mail1.contains(".com")||!mail1.contains("@")||!mail2.contains(".com")||!mail2.contains("@")){
           JOptionPane.showMessageDialog(null, "You should make true form to your values",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
       }
       else{
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time
           
           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail1+"&&&"+mail2);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
       removeEmptyLineFromFile();
       }
   }
    public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail1,String mail2,String mail3){
       Writer output;
       if(ıd.equals("")||name.equals("")||surname.equals("")||!(position.equals("Employee")||position.equals("Manager"))||userName.equals("")||password.equals("")||!mail1.contains(".com")||!mail1.contains("@")||!mail2.contains(".com")||!mail2.contains("@")||!mail3.contains(".com")||!mail3.contains("@")){
           JOptionPane.showMessageDialog(null, "You should make true form to your values",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
       }
       else{
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time
           
           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail1+"&&&"+mail2+"&&&"+mail3);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
       removeEmptyLineFromFile();
       }
   }
    public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail1,String mail2,String mail3,String mail4){
       Writer output;
        if(ıd.equals("")||name.equals("")||surname.equals("")||!(position.equals("Employee")||position.equals("Manager"))||userName.equals("")||password.equals("")||!mail1.contains(".com")||!mail1.contains("@")||!mail2.contains(".com")||!mail2.contains("@")||!mail3.contains(".com")||!mail3.contains("@")||!mail4.contains(".com")||!mail4.contains("@")){
           JOptionPane.showMessageDialog(null, "You should make true form to your values",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
       }
        else{
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time
           
           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail1+"&&&"+mail2+"&&&"+mail3+"&&&"+mail4);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
      removeEmptyLineFromFile(); 
        }
   }
    public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail1,String mail2,String mail3,String mail4,String mail5){
       Writer output;
         if(ıd.equals("")||name.equals("")||surname.equals("")||!(position.equals("Employee")||position.equals("Manager"))||userName.equals("")||password.equals("")||!mail1.contains(".com")||!mail1.contains("@")||!mail2.contains(".com")||!mail2.contains("@")||!mail3.contains(".com")||!mail3.contains("@")||!mail4.contains(".com")||!mail4.contains("@")||!mail5.contains(".com")||!mail5.contains("@")){
           JOptionPane.showMessageDialog(null, "You should make true form to your values",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
       }
        else{
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time
           
           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail1+"&&&"+mail2+"&&&"+mail3+"&&&"+mail4+"&&&"+mail5);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
    removeEmptyLineFromFile();  
        }
   }
   public static void removeEmployeeFile(String ıd,String name) throws IOException {
        File inputFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
        File tempFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\TempEmployees.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String Identity =ıd+"///"+name+"///";
        String currentLine;
        boolean succesfull3=false;
        while((currentLine = reader.readLine()) != null) {
          // trim newline when comparing with Identity
           String trimmedLine = currentLine.trim();
           if(trimmedLine.contains(Identity)){
               succesfull3=true;
               continue;
           }
           if(!currentLine.isEmpty())
           writer.write(currentLine + System.getProperty("line.separator"));
             }
         writer.close(); 
         reader.close(); 
         boolean succesfull1 = inputFile.delete();
         if(succesfull1==false){
             System.out.println("File could not be deleted");
         }
         boolean successful2 = tempFile.renameTo(inputFile);
         if(successful2==false){
             System.out.println("File's name could not be changed");
         }
         if(succesfull3==false){
             JOptionPane.showMessageDialog(null, "Please Control values",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
         }
       
       /*
       String Identity =ıd+"///"+name+"///";
         File file = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("File "+file.getName()+" not created successfully");
                }
            }
            File tempFile = new File(file.getAbsolutePath() + ".txt");
          try(Scanner scanner = new Scanner(file)) {
              try (PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {

                  
                  String line;
                  while (scanner.hasNextLine()) {
                      line = scanner.nextLine();
                      if (!line.trim().contains(Identity)) {

                          pw.println(line.toString().trim());
                          pw.flush();
                      }
                  }
                  file.deleteOnExit();
                  if (!file.exists()) {
                      System.out.println("Could not delete file");
                      return;
                  }
                  
                  File file2 = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt.txt");
                  File file3 = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
                   boolean flag = file2.renameTo(file3);
    
                   if (flag == true) {
                   System.out.println("File Successfully Rename");
                     }
                    else {
                   System.out.println("Operation Failed");
        }
                  //Path source = Paths.get(tempFile.getPath().toString().trim());
                 //Files.move(source, source.resolveSibling(file.getPath().toString().trim()),
                 //StandardCopyOption.REPLACE_EXISTING);
              }
          }
        catch (IOException e)
        {
            System.out.println("IO Exception Occurred");
        }
       
       */

    }
   public static void removeEmptyLineFromFile(){
       try {
           Scanner file;
           PrintWriter writer;
           
           file = new Scanner(new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt"));
           writer = new PrintWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\TempEmployees.txt");
           File inputFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
           File tempFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\TempEmployees.txt");
           while (file.hasNext()) {
               String line = file.nextLine();
               if (!line.isEmpty()) {
                   writer.write(line);
                   writer.write("\n");
               }
           }
           
           file.close();
           writer.close();
           
           boolean succesfull1 = inputFile.delete();
         if(succesfull1==false){
             System.out.println("File could not be deleted<<RemoveEmptyLineFromFile");
         }
         boolean successful2 = tempFile.renameTo(inputFile);
         if(successful2==false){
             System.out.println("File's name could not be changed<<RemoveEmptyLineFromFile");
         }         
       } catch (FileNotFoundException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
       

        
   }
   public static void editEmployeeFile(String ıd,String name,String newName,boolean editname,boolean editsurname,boolean editposition,boolean editusername,boolean editpassword) throws FileNotFoundException, IOException{
        File inputFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
        File tempFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\TempEmployees.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        newName=newName.trim();
        String Identity =ıd.trim()+"///"+name.trim()+"///";
        String currentLine;
        boolean succesfull3=false;
        while((currentLine = reader.readLine()) != null) {
          // trim newline when comparing with Identity
           String trimmedLine = currentLine.trim();
           if(trimmedLine.contains(Identity)){
               String [] values = trimmedLine.split("///");
               if(editname==true)
                   values[1]=newName;
               else if(editsurname==true)
                   values[2]=newName;
               else if(editposition==true)
                   values[3]=newName;
               else if(editusername==true)
                   values[4]=newName;   
               else if(editpassword=true)
                   values[5]=newName;
               else{
                   JOptionPane.showMessageDialog(null, "You should make true form to your editvalue",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
                   System.out.println("You should make true form to your editvalue");
                   continue;
               }
               succesfull3=true;                  
               String editedLine = values[0]+"///"+values[1]+"///"+values[2]+"///"+values[3]+"///"+values[4]+"///"+values[5]+"///"+values[6];
               writer.write(editedLine + System.getProperty("line.separator"));
               //BURADASIN
               //BURADASIN
               System.out.println("Employee is changed");
           }
           else if (!currentLine.isEmpty())
           writer.write(currentLine + System.getProperty("line.separator"));
             }
           
         writer.close(); 
         reader.close(); 
         
         boolean succesfull1 = inputFile.delete();
         if(succesfull1==false){
             System.out.println("File could not be deleted");
         }
         boolean successful2 = tempFile.renameTo(inputFile);
         if(successful2==false){
             System.out.println("File's name could not be changed");
         }
         if(succesfull3==false){
             JOptionPane.showMessageDialog(null, "You should make true form to your editvalue",
      "Hey!", JOptionPane.ERROR_MESSAGE); 
         }
   }
   public static void addEmployeeMail(String ıd,String name,String Mail) throws FileNotFoundException, IOException{
        File inputFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
        File tempFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\TempEmployees.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String Identity =ıd+"///"+name+"///";
        String currentLine;
        boolean process=false;

        while((currentLine = reader.readLine()) != null) {
          // trim newline when comparing with Identity
           String trimmedLine = currentLine.trim();
           if(trimmedLine.contains(Identity)){
               String [] values = trimmedLine.split("///");
                                                  
               String editedLine = values[0]+"///"+values[1]+"///"+values[2]+"///"+values[3]+"///"+values[4]+"///"+values[5]+"///"+values[6]+"&&&"+Mail;
               writer.write(editedLine.trim() + System.getProperty("line.separator"));
               process=true;
           }
           else if (!currentLine.isEmpty())
           writer.write(currentLine + System.getProperty("line.separator"));
             }
           
         writer.close(); 
         reader.close(); 
         
         boolean succesfull1 = inputFile.delete();
         if(succesfull1==false){
              JOptionPane.showMessageDialog(null, "File could not be deleted",
      "Hey!", JOptionPane.ERROR_MESSAGE);
             System.out.println("File could not be deleted");
         }
         boolean successful2 = tempFile.renameTo(inputFile);
         if(successful2==false){
             JOptionPane.showMessageDialog(null, "File's name could not be changed",
      "Hey!", JOptionPane.ERROR_MESSAGE);
             System.out.println("File's name could not be changed");
         }
         if(process==false){
             JOptionPane.showMessageDialog(null, "ID or Name wrong. pls check!",
      "Hey!", JOptionPane.ERROR_MESSAGE);
             System.out.println("ID or Name wrong. pls check.");
         }
         else{
             System.out.println("Added");
         }
   }
   public static void RemoveEmployeeMail(String ıd,String name,String Mail) throws FileNotFoundException, IOException{
        File inputFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
        File tempFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\TempEmployees.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String Identity =ıd+"///"+name+"///";
        String currentLine;
        boolean process=false;
        boolean process2=false;
        while((currentLine = reader.readLine()) != null) {
          // trim newline when comparing with Identity
           String trimmedLine = currentLine.trim();
           if(trimmedLine.contains(Identity)){
               process=true;
               String [] values = trimmedLine.split("///");
               String [] mails = values[6].split("&&&");
               values[6]="";
               
               for(int i=0;i<mails.length;i++){
                 if(Mail.equals(mails[i])){
                     System.out.println("mail found to be deleted");
                     process2=true;
                 }
                 else{
                  values[6]=values[6]+mails[i]+"&&&";
                 }
               }
              
               values[6]=values[6].substring(0,values[6].length()-3);
                
               String editedLine = values[0]+"///"+values[1]+"///"+values[2]+"///"+values[3]+"///"+values[4]+"///"+values[5]+"///"+values[6];
               writer.write(editedLine.trim() + System.getProperty("line.separator"));
               
           }
           else if (!currentLine.isEmpty())
           writer.write(currentLine + System.getProperty("line.separator"));
             }
            if(process==true&&process2==true){
                JOptionPane.showMessageDialog(null, "Mail Removed",
      "Hey!", JOptionPane.INFORMATION_MESSAGE);
               System.out.println("Mail removed.");
             }
             
               else if (process==true&&process2==false){
                     JOptionPane.showMessageDialog(null, "Mail is wrong.Check Mail text",
      "Hey!", JOptionPane.ERROR_MESSAGE);    
                   System.out.println("Mail is wrong.Check Mail text");
               }
               else if (process==false&&process2==false){
               JOptionPane.showMessageDialog(null, "Name and Id may be worng.Check text!",
      "Hey!", JOptionPane.ERROR_MESSAGE);    
                System.out.println("Name and Id may be worng.Check text");
               }
           
         writer.close(); 
         reader.close(); 
         
         boolean succesfull1 = inputFile.delete();
         if(succesfull1==false){
             JOptionPane.showMessageDialog(null, "File's name could not be changed!",
      "Hey!", JOptionPane.ERROR_MESSAGE);
             System.out.println("File could not be deleted");
         }
         boolean successful2 = tempFile.renameTo(inputFile);
         if(successful2==false){
             JOptionPane.showMessageDialog(null, "File's name could not be changed!",
      "Hey!", JOptionPane.ERROR_MESSAGE);
             System.out.println("File's name could not be changed");
         }    
   }
}
