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
public class RecursiveFunctions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(sequenceOne(5, 3));
        System.out.println(sequenceOne(2, 2));
        System.out.println(sequenceOne(1, 4));
        System.out.println(sequenceOne(-5, -2));
        System.out.println("-------------------------------------------------------");
        System.out.println(sequenceTwo(1, 1));
        System.out.println(sequenceTwo(2, 1));
        System.out.println(sequenceTwo(5, 5));
        
    }
    
    public static int sequenceOne(int x, int y) {
        int number = 0;
        
        if (x < y) {
            number = -1 * sequenceOne(y, x);
        } else if (x > y) {
            number = 1 + sequenceOne(x - 1, y);
        } else if (x == y) {
            number = 0; 
        }
        
        return number;
    }
    
    public static int sequenceTwo(int m, int n) {
        int number = 0;
        
        if (m == 0) {
            number = n + 1;
        } else if (m > 0 && n == 0) {
            number = sequenceTwo(m - 1, 1);
        } else {
            number = sequenceTwo(m - 1, sequenceTwo(m, n - 1));
        }
        
        return number;
    }
    
}
