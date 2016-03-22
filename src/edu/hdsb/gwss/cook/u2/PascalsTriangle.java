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
public class PascalsTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(term(4, 4));
        row(7);
    }
    
    public static int term(int row, int col) {
        int number = 1;
        
        // Check if value is outside (value of 1)
        if (row == col || col == 0) {
            number = 1;
        } else {
            //number = term
        }
        
        return number;
    }
    
    public static int row(int row) {
        int number = 1;
        
        
        
        return number;
    }
    
}
