/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u2;

/**
 *
 * @author 1cookspe
 */
public class FiveTerms {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sequenceOne(5));
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
    
}
