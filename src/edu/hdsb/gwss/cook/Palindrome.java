/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook;

import java.util.Scanner;

/**
 *
 * @author 1cookspe
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // VARIABLES
        Scanner input = new Scanner(System.in);
        String word;
        
        
        // ASK FOR INPUT
        System.out.print("Enter a word: ");
        word = input.nextLine().toUpperCase();
       
        
        // CHECK IF TWO WORDS MATCH 
        if (isaPalindrome(word)) {
            System.out.println("Therefore, \"" + word + "\" is a palindrome");
        } else {
            System.out.println("Therefore, \"" + word + "\" is not a palindrome");
        }
    }
    
    public static boolean isaPalindrome( String word ) {
        String backwards = "";
        for (int i = word.length(); i > 0; i--) {
            String character = word.substring(i - 1, i);
            //System.out.println(character);
            backwards += character;
        }
        
        // CHECK IF TWO WORDS MATCH 
        if (backwards.equals(word)) {
            System.out.println(word + " backwards is " + backwards);
            return true;
        } else {
            System.out.println(word + " backwards is " + backwards);
            return false;
        }
        
    }
    
}
