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
public class RoundingError {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // CONSTANTS
        Scanner input = new Scanner(System.in);

        // VARIABLES
        double number;
        double square;
        double root;
        double difference;
        
        // LOGIC
        // Ask for number
        System.out.print("Please enter a number: ");
        number = Integer.parseInt(input.nextLine());
        
        // Calculate square the square number and difference
        square = number * number;
        root = Math.sqrt(square);
        System.out.println("The square root of the square is " + root);
        difference = root - number;
        
        // Output
        System.out.println("The difference is " + difference);
    }
    
}
