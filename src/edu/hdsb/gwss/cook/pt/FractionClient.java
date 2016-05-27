/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.pt;

/**
 *
 * @author 1cookspe
 */
public class FractionClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Improper fraction
        Fraction fraction = new Fraction(4, -7);
        fraction.reduce();
        //fraction.invert();
        System.out.println(fraction.size());
        System.out.println(fraction.toString());
        
        // MIXED FRACTION
        MixedFraction mixedFraction = new MixedFraction(1, 3, 3);
        System.out.println(mixedFraction.toString());
        assert(!mixedFraction.equals(fraction));
        mixedFraction.invert();
        System.out.println(mixedFraction.toString());
        System.out.println(mixedFraction.times(fraction));
    }
    
}
