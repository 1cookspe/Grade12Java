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

    // GLOBAL VARIABLES
    final static char[] ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // VARIABLES
        Scanner input = new Scanner(System.in);
        String phrase;
        int rotationAmount;
        int enter;

        // ASK FOR INPUT
        System.out.print("Enter 1 for encryption, 2 for decryption: ");
        enter = Integer.parseInt(input.nextLine());
        System.out.print("Please enter a phrase: ");
        phrase = input.nextLine().trim().toUpperCase();
        System.out.print("Enter the rotation amount: ");
        rotationAmount = Integer.parseInt(input.nextLine());

        if (rotationAmount > 26) {
            rotationAmount -= 26;
        }

        switch (enter) {
            case 1:
                System.out.println("Your encryption key is " + change(phrase, rotationAmount, true));
                break;
            case 2:
                System.out.println("Your decryption key is " + change(phrase, rotationAmount, false));
                break;
            default:
                System.out.println("Invalid input");
        }

    }

    public static String change(String phrase, int rotationAmount, boolean encrypt) {
        String encrypted = "";

        if (!encrypt) {
            rotationAmount = 0 - rotationAmount;
            if (rotationAmount > -26) {
                rotationAmount += 26;
            }
        }

        // LOOP THROUGH WORD AND REPLACE LETTERS FROM THE ALPHABET ARRAY
        for (int i = 0; i < phrase.length(); i++) {
            char letter = phrase.charAt(i);
            if (letter != ' ') {
                int place = 0;
                for (int y = 0; y < ALPHABET.length; y++) {
                    if (letter == ALPHABET[y]) {
                        place = y;
                        y = ALPHABET.length + 1;
                    }

                }
                if (!((place + rotationAmount) >= ALPHABET.length)) {
                    if (!((place + rotationAmount) < 0)) {
                        encrypted += ALPHABET[place + rotationAmount];
                    } else {
                        int newPlace = ALPHABET.length + (place + rotationAmount);
                        encrypted += ALPHABET[newPlace];
                    }
                } else {

                    encrypted += ALPHABET[(place + rotationAmount) - ALPHABET.length];

                }
            } else {
                encrypted += ' ';
            }

        }
        return encrypted;
    }

}
