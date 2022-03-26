/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phonebook;

import java.util.ArrayList;

/**
 *
 * @author brian
 */
public class controller {
    public static Tree BST =new Tree();
    
    public static void addNode(Contact cnt){
        BST.insertNode(cnt);
    }
      public static void deleteNode(Contact cnt){
        BST.delete(cnt);
    }
      
    public static void print(){
          BST.inorderTraversal();
    }

    static ArrayList<Contact> search(String text) {
       
        return BST.search(text);
    }

    // 
    static void clear() {
      BST=new Tree();
    }
}
