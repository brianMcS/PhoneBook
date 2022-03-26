/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.phonebook;

import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author brian
 */
public class Tree {

    private TreeNode root;

    // Construct an empty Tree of integers
    public Tree() {
        root = null;
    }

    // Insert a new node in the binary search tree. If the root node is null, create the    
    // root node here. Otherwise, call the insert method of class TreeNode.
    public synchronized void insertNode(Contact d) {
        if (root == null) {
            root = new TreeNode(d);
        } else {
            root.insert(d);
        }
    }
    // Preorder Traversal - visit each node in the tree in preorder.
    // Pre:	The binary tree to which root points has been created
    // Post:	The function Visit has been performed on every entry in the binary    	tree in preorder sequence. 

    public synchronized void preorderTraversal() {
        preorderHelper(root);
    }

    // Recursive method to perform preorder traversal
    private void preorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data.toString() + " ");
        preorderHelper(node.left);
        preorderHelper(node.right);
    }
// Inorder Traversal - visit each node in the tree in inorder.
    // Pre:	The binary tree to which root points has been created
    // Post:	The function Visit has been performed on every entry in the binary    	tree in inorder sequence. 

    public synchronized void inorderTraversal() {
        inorderHelper(root);
    }

    // Recursive method to perform inorder traversal
    private void inorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left);
        System.out.print(node.data + " ");
        inorderHelper(node.right);
    }
    // Postorder Traversal - visit each node in the tree in postorder.
    // Pre:	The binary tree to which root points has been created
    // Post:	The function Visit has been performed on every entry in the binary    	tree in postorder sequence. 

    public synchronized void postorderTraversal() {
        postorderHelper(root);
    }

    // Recursive method to perform postorder traversal
    private void postorderHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        postorderHelper(node.left);
        postorderHelper(node.right);
        System.out.print(node.data.toString() + " ");
    }
    
    
    //search
    public synchronized ArrayList search(String s){
        ArrayList list = new ArrayList<Contact>();
        searchHelper(root, s, list);
        return list;
    }
    
    //recursive method to search(inorder traversal)
    private void searchHelper(TreeNode node, String s, ArrayList list){
        if(node == null){
            return;
        }
        searchHelper(node.left,s,list);
        if(node.data.fName.startsWith(s)){
            list.add(node);
        }else if(node.data.lName.matches(s)){
            list.add(node);
        }
        searchHelper(node.right,s,list);
    }
    
    
    public void delete(Contact item) {
        TreeNode marker = root, parent = null, child = root, temp;

        while ((marker != null) && (marker.data.fName != item.fName)) {
            parent = marker;

            if (item.fName.compareTo(marker.data.fName) < 0) {
                marker = marker.left;
            } else {
                marker = marker.right;
            }
        } // end of while

        if (marker == null) {
            System.out.println("Cannot delete: item not in tree");
        }

        // Delete root node
        if (parent == null) {
            if (marker.right == null) {
                root = marker.left;
            } else if (marker.left == null) {
                root = marker.right;
            } else {
                for (temp = marker, child = marker.left; child.right != null;
                        temp = child, child = child.right);
                if (child != marker.left) {
                    temp.right = child.left;
                    child.left = root.left;
                }
                child.right = root.right;
                root = child;
            } // end else
        } // end of if         
        // Delete internal node
        else if (marker.right == null) {
            if (parent.left == marker) {
                parent.left = marker.left;
            } else {
                parent.right = marker.left;
            }
        } else if (marker.left == null) {
            if (parent.left == marker) {
                parent.left = marker.right;
            } else {
                parent.right = marker.right;
            }
        } else {
            for (temp = marker, child = marker.left; child.right != null; temp = child, child = child.right);
            if (child != marker.left) {
                temp.right = child.left;
                child.left = marker.left;
            }

            child.right = marker.right;
            if (parent.left == marker) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } // end of else
    } // end of delete
   
}
