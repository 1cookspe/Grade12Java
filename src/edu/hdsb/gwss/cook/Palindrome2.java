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
public class Palindrome2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // VARIABLES
        Scanner input = new Scanner(System.in);
        String sentence;
        int numPal = 0;

        // ASK FOR INPUT
        System.out.print("Enter a sentence: ");
        sentence = input.nextLine().toUpperCase();

        // TOKENIZE THE SENTENCE INTO SEPERATE WORDS
        StringTokenizer st = new StringTokenizer(sentence);
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            if( Palindrome.isaPalindrome(  word ) ) {
                System.out.println("Therefore, \"" + word + "\" is a palindrome");
                numPal++;
            }
            else {
                System.out.println("Therefore, \"" + word + "\" is not a palindrome");
            }
        }
            System.out.println("There are " + numPal + " palindromes in this sentence.");
    }

}
