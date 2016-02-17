/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1cookspe
 */
public class Palindrome3 {
static ArrayList<String> words = new ArrayList();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // VARIABLES
        Scanner input = new Scanner(System.in);
        String phrase = "";
        
        
        // INPUT
        System.out.print("Enter a phrase: ");
        phrase = input.nextLine().toUpperCase();
        
    }

    public static String palindromeCheck(String phrase) {
        StringTokenizer st = new StringTokenizer(phrase);
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if (Palindrome.isaPalindrome(word)) {
                words.add(Palindrome.backwards);
                return Palindrome.backwards;
                
            }
            
        }
        return "\"" + phrase + "\" is not a palindrome";
    }

}
