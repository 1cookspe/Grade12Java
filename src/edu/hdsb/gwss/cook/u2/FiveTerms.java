/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u2;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author 1cookspe
 */
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        for (int i = 1; i < 6; i++) {
            System.out.print(sequenceOne(i) + ", ");
        }
        
        System.out.print("\n");
        
        for (int i = 1; i < 6; i++) {
            System.out.print(sequenceTwo(i) + ", ");
        }

    }

    public static int sequenceOne(int n) {
        int number = 0;

        if (n > 2) {
            number = sequenceOne(n - 1) + sequenceOne(n - 2);
        } else if (n == 1) {
            number = 1;
        } else if (n == 2) {
            number = 3;
        }

        return number;
    }
    
    public static double sequenceTwo(double n) {
        double number = 2;
        
        if (n > 1) {
            number = Math.sqrt(3 * sequenceTwo(n - 1) + 4);
        } 
        
        NumberFormat formatter = new DecimalFormat("#0.00");
        return Double.parseDouble(formatter.format(number));

    }

}