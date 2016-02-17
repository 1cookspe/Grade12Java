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
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // VARIABLES
        Scanner input = new Scanner(System.in);
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String phrase = input.nextLine();
        
        for (int i = 0; i < phrase.length(); i++) {
            char letter = phrase.charAt(i);
            int place = 0;
            for (int y = 0; y < alphabet.length; y++) {
                if (letter == alphabet[y]) {
                    place = y;
                    y++;
                }
                
            }
            
            phrase = phrase.replace(letter, alphabet[place + 1]);
        }
        
        System.out.println(phrase);
    }
    
}
