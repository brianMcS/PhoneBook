/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phonebook;

/**
 *
 * @author brian
 */
public class TreeNode {

    // package access members
    TreeNode left;   // left node
    Contact data;        // data item	          - data will differ depending on the application.
    TreeNode right;  // right node

    // Constructor: initialize data to d and make this a leaf node
    public TreeNode(Contact d) {
        data = d;
        left = right = null;  // this node has no children
    }

    // Insert a TreeNode into a Tree that contains nodes.( Ignore duplicate values).
    public synchronized void insert(Contact d) {
        if (d.fName.compareTo(data.fName)<0 ) {
            if (left == null) {
                left = new TreeNode(d);
            } else {
                left.insert(d);
            }
        } else if (d.fName.compareTo(data.fName)>0 || d.fName.compareTo(data.fName)==0) {
            if (right == null) {
                right = new TreeNode(d);
            } else {
                right.insert(d);
            }
        }
    }

    

}
