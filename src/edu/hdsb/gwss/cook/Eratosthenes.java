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
        // VARIABLES
        boolean numbers[] = new boolean[1000]; 
        

    }
    
    public static boolean isPrime(int number) {
        if (number % 2 == 0) {
            return false;
        } else if (number % 3 == 0) {
            return false;
        } else if (number % 5 == 0) {
            return false;
        } else if (number % 7 == 0) {
            return false;
        } else if (number % 11 == 0) {
            return false;
        } else if (number % 13 == 0) {
            return false;
        } else if (number % 17 == 0) {
            return false;
        } else if (number % 19 == 0) {
            return false;
        } else if (number % 23 == 0) {
            return false;
        }
        return true;
    }
    
}
