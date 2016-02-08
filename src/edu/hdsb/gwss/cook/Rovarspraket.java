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
public class Rovarspraket {
   static String word = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        word = input.nextLine();
        
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            switch (letter) {
                case 'a':
                    i++;
                    break;
                case 'e':
                    i++;
                    break;
                case 'i':
                    i++;
                    break;
                case 'o':
                    i++;
                    break;
                case 'u':
                    i++;
                    break;
                default:
                    consonant(letter , i);
            }
        }
    }
    
    public static void consonant(char letter, int i) {
        
    }
    
}
