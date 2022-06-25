/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author yc_ke
 */
public class Manager extends Employee {
   public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail){
       Writer output;
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time

           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
       removeEmptyLineFromFile();
       
   }
    public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail1,String mail2){
       Writer output;
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time
           
           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail1+"&&&"+mail2);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
       removeEmptyLineFromFile();
   }
    public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail1,String mail2,String mail3){
       Writer output;
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time
           
           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail1+"&&&"+mail2+"&&&"+mail3);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
       removeEmptyLineFromFile();
   }
    public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail1,String mail2,String mail3,String mail4){
       Writer output;
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time
           
           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail1+"&&&"+mail2+"&&&"+mail3+"&&&"+mail4);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
      removeEmptyLineFromFile(); 
   }
    public static void addEmployeeFile(String ıd,String name,String surname,String position,String userName,String password ,String mail1,String mail2,String mail3,String mail4,String mail5){
       Writer output;
       try {
           output = new BufferedWriter(new FileWriter("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt", true));  //clears file every time
           
           output.append("\n"+ıd+"///"+name+"///"+surname+"///"+position+"///"+userName+"///"+password+"///"+mail1+"&&&"+mail2+"&&&"+mail3+"&&&"+mail4+"&&&"+mail5);
           output.close();       
       } catch (IOException ex) {
           Logger.getLogger(FileOperations.class.getName()).log(Level.SEVERE, null, ex);
       }
    removeEmptyLineFromFile();   
   }
   public static void removeEmployeeFile(String ıd,String name) throws IOException {
        File inputFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
        File tempFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\TempEmployees.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String Identity =ıd+"///"+name+"///";
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
          // trim newline when comparing with Identity
           String trimmedLine = currentLine.trim();
           if(trimmedLine.contains(Identity)) continue;
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
                   System.out.println("You should make true form to your editvalue");
               }
                                    
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
   
   }
   public static void addEmployeeMail(String ıd,String name,String Mail) throws FileNotFoundException, IOException{
        File inputFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
        File tempFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\TempEmployees.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String Identity =ıd+"///"+name+"///";
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
          // trim newline when comparing with Identity
           String trimmedLine = currentLine.trim();
           if(trimmedLine.contains(Identity)){
               String [] values = trimmedLine.split("///");
                                                  
               String editedLine = values[0]+"///"+values[1]+"///"+values[2]+"///"+values[3]+"///"+values[4]+"///"+values[5]+"///"+values[6]+"&&&"+Mail;
               writer.write(editedLine.trim() + System.getProperty("line.separator"));
               System.out.println("Mail added.");
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
   }
   public static void RemoveEmployeeMail(String ıd,String name,String Mail) throws FileNotFoundException, IOException{
        File inputFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\Employees.txt");
        File tempFile = new File("C:\\Users\\yc_ke\\Documents\\NetBeansProjects\\E-MailProject\\Files\\TempEmployees.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String Identity =ıd+"///"+name+"///";
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
          // trim newline when comparing with Identity
           String trimmedLine = currentLine.trim();
           if(trimmedLine.contains(Identity)){
               String [] values = trimmedLine.split("///");
               String [] mails = values[6].split("&&&");
               values[6]="";
               
               for(int i=0;i<mails.length;i++){
                 if(Mail.equals(mails[i])){
                     System.out.println("mail found to be deleted");
                 }
                 else{
                  values[6]=values[6]+mails[i]+"&&&";
                 }
               }
               System.out.println(values[6]);
               
               values[6]=values[6].substring(0,values[6].length()-3);
                System.out.println(values[6]);
               String editedLine = values[0]+"///"+values[1]+"///"+values[2]+"///"+values[3]+"///"+values[4]+"///"+values[5]+"///"+values[6];
               writer.write(editedLine.trim() + System.getProperty("line.separator"));
               System.out.println("Mail removed.");
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
   }
} 
    

