/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import java.util.ArrayList;

/**
 *
 * @author yc_ke
 */
public class Employee {
    public String ıd,name,surname,position,userName,Password;
    public ArrayList<String> mails=  new ArrayList<String>();
    
    
    public Employee() {
    }
    

    public Employee(String ıd, String name, String surname, String position, String userName, String Password) {
        this.ıd = ıd;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.userName = userName;
        this.Password = Password;
    }
}
