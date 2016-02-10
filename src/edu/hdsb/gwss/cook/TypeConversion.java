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
        
        System.out.println("A long cannot be converted to a boolean.");
        
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
        System.out.println("----------------------------------------------");
        
        d = 2.6534;
        
        System.out.println("A double cannot be converted to a string.");
        
        // DOUBLE TO CHAR
        c = (char) d;
        System.out.println(d + " --> " + c);
        
        // DOUBLE TO INT
        i = (int) d;
        System.out.println(d + " --> " + i);
        
        // DOUBLE TO LONG
        l = (long) d;
        System.out.println(d + " --> " + l);
        
        // DOUBLE TO STRING
        s = "" + d;
        System.out.println(d + " --> " + s);
        
        // -------------------------------------------------------------------
        // STRING CONVERSIONS
        
        s = "1234";
        
        // STRING TO BOOLEAN
        System.out.println("A string cannot be converted to a boolean.");
        
        // STRING TO CHAR
        System.out.println("A string cannot be converted to a char.");
        
        // STRING TO INT
        i = Integer.valueOf(s);
        System.out.println(s + " --> " + i);
        
        // STRING TO LONG
        l = Long.parseLong(s);
        System.out.println(s + " --> " + l);
        
        // STRING TO DOUBLE
        d = Double.parseDouble(s);
        System.out.println(s + " --> " + d);
        
        System.out.println("----------------------------------------------");
        // -------------------------------------------------------------------
        // BOOLEAN CONVERSIONS
        boolean b = true;
        
        // BOOLEAN TO INT
        i = (b) ? 1 : 0;
        System.out.println(b + " --> " + i);
        
        // BOOLEAN TO LONG
        l = (b) ? 1 : 0;
        System.out.println(b + " --> " + l);
        
        // BOOLEAN TO DOUBLE
        d = (b) ? 1 : 0;
        System.out.println(b + " --> " + d);
        
        // BOOLEAN TO STRING
        s = Boolean.toString(b);
        System.out.println(b + " --> " + s);
        
        // -------------------------------------------------------------------
        // CHAR CONVERSIONS
        System.out.println("----------------------------------------------");
        c = 'R';
        
        // CHAR TO BOOLEAN
        System.out.println("A char cannot be converted to a boolean");
        
        // CHAR TO INT
        i = (int) c;
        System.out.println(c + " --> " + i);
        
        // CHAR TO LONG
        l = (long) c;
        System.out.println(c + " --> " + l);
        
        // CHAR TO DOUBLE
        d = (double) c;
        System.out.println(c + " --> " + d);
        
        // CHAR TO STRING
        s = Character.toString(c);
        System.out.println(c + " --> " + s);
        
        // -------------------------------------------------------------------
        // INT CONVERSIONS
        System.out.println("----------------------------------------------");
        
        // INT TO BOOLEAN
        System.out.println("An int cannot be converted to a boolean.");
        
        // INT TO CHAR
        c = (char) i;
        System.out.println(i + " --> " + c);
        
        // INT TO LONG
        l = (long) i;
        System.out.println(i + " --> " + l);
        
        // INT TO DOUBLE
        d = (double) i;
        System.out.println(i + " --> " + d);
        
        // INT TO STRING
        s = Integer.toString(i);
        System.out.println(i + " --> " + d);
        
    }
    
}
