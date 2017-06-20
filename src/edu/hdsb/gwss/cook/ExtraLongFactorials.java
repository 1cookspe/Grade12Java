/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author 1cookspe
 */
public class ExtraLongFactorials {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter a number: ");
//        int factorial = input.nextInt();
//        
//        BigInteger answer = BigInteger.valueOf(1);
//        for (int i = factorial; i > 1; i--) {
//            answer = answer.multiply(BigInteger.valueOf(i));
//        }
//        System.out.println(answer);
        
        factorials();
        
    }
    
    public static void factorials() {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        BigInteger multiple = BigInteger.valueOf(number);
        for (int i = number; i > 1; i--) {
            multiple = multiple.multiply(BigInteger.valueOf(i));
        }
        System.out.println(multiple);
    }
    
}
