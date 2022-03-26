/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phonebook;

import javax.swing.JOptionPane;

/**
 *
 * @author brian
 */
public class Contact {
    
    String fName;
    String lName;
    String phoneNumber;

    public Contact(String fName, String lName, String phoneNumber) {
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    void display(){
        JOptionPane.showMessageDialog(null, "First Name: " +fName + "Last Name: " + lName + "Phone Number: "+ phoneNumber);
    }

    @Override
    public String toString() {
        return fName + " " + lName + "  Phone: "+ phoneNumber;
    }
    
    
}

