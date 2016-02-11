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
public class JavaBigDecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // VARIABLES
        Scanner input = new Scanner(System.in);
        double[] numbers = {9 , -100, 50, 0, 56.6, 90, 0.12, .12, 02.34, 000.000};
        
       
       boolean swap = true;
       double temp;
       
       while (swap) {
           swap = false;
           for (int i = 0; i < numbers.length - 1; i++) {
               if (numbers[i] < numbers[i + 1]) {
                   temp = numbers[i];
                   numbers[i] = numbers[i + 1];
                   numbers[i + 1] = temp;
                   swap = true;
               }
           }
       }
       
       for (int i = 0; i < numbers.length; i++) {
           System.out.println(numbers[i]);
       }
    }
    
}
