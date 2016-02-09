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
public class TypeConversion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // LONG CONVERSIONS 
        long l = 94286;
        
        // LONG TO CHAR
        char c = (char) l;
        System.out.println(l + " --> " + c);
        
        // LONG TO INT
        int i = (int) l;
        System.out.println(l + " --> " + i);
        
        // LONG TO DOUBLE
        double d = (double) l;
        System.out.println(l + " --> " + d);
        
        // LONG TO STRING
        String s = "" + l;
        System.out.println(l + " --> " + s);
        
        // ---------------------------------------------------------------------------
        // DOUBLE CONVERSIONS
        
        d = 2.6534;
        
        // DOUBLE TO CHAR
        c = (char) d;
        System.out.println(d + " --> " + c);
        
    }
    
}
