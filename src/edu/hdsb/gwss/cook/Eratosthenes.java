/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook;

/**
 *
 * @author 1cookspe
 */
public class Eratosthenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 2; i < 1000; i++) {
            if (isPrime(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    public static boolean isPrime(int number) {
        final int[] POSSIBLE_DIVISORS = {2, 3, 5, 7};

        for (int i = 0; i < POSSIBLE_DIVISORS.length; i++) {

            if ((number % POSSIBLE_DIVISORS[i] == 0) && (number != POSSIBLE_DIVISORS[i])) {
                return false;

            }
        }
        return true;
    }

}
