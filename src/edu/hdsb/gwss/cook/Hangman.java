/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 1cookspe
 */
public class Hangman {
static String solve = "";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // VARIABLES
        Scanner input = new Scanner(System.in);
        String[][] categories = {
            {"THE X FILES", "THE WALKING DEAD", "GAME OF THRONES"},
            {"AVENGERS", "STAR WARS", "GHOSTBUSTERS"},
            {"TOM CRUISE", "BRAD PITT", "LEONARDO DICAPRIO"},
            {"ANGELIA JOLIE", "JENNIFER LAWRENCE", "ANNE HATHAWAY"}
        };
        int category = (int) (Math.random() * categories.length);
        int selection = (int) (Math.random() * categories[category].length);
        String selectedCategory = "";
        int numWords = 1;
        int guessesLeft = 7;
        int lettersLeft = categories[category][selection].length();

        switch (category) {
            case 0:
                selectedCategory = "TV SHOWS";
                break;
            case 1:
                selectedCategory = "MOVIES";
                break;
            case 2:
                selectedCategory = "ACTORS";
                break;
            case 3:
                selectedCategory = "ACTRESSES";
                break;
        }

        System.out.println("Category: " + selectedCategory);

        solve = categories[category][selection];
        for (int i = 0; i < solve.length(); i++) {
            if (solve.charAt(i) != ' ') {
                System.out.print("-");
            } else {
                numWords++;
                System.out.print(" ");
            }
        }
        System.out.println("\nNumber of Words: " + numWords);
        
        while (guessesLeft > 0 && lettersLeft > 0) {
            System.out.println("You have " + guessesLeft + " guesses left.");
            System.out.print("Guess a letter: ");
            String let = input.nextLine().toUpperCase();
            char letter = let.charAt(0);
            if (phraseContains(letter) == 0) {
                System.out.println("Incorrect!");
                guessesLeft--;
            } else {
                System.out.println("Correct!");
                lettersLeft -= phraseContains(letter);
                System.out.println(phraseContains(letter));
            }
            System.out.println("You have " + lettersLeft + " letters left.");
        }

    }
    
    public static int phraseContains(char letter) {
        int numLetters = 0;
        for (int i = 0; i < solve.length(); i++) {
            if (solve.charAt(i) == letter) {
                numLetters++;
            }
        }
        return numLetters;
    }

}
