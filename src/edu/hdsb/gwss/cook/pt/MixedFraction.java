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
public class MixedFraction extends Fraction {
    

    public MixedFraction(int numerator, int denominator, int wholeNumber) {
        super(numerator + (wholeNumber * denominator), denominator);
    }
        
    @Override
    public String toString() {
        int wholeNumber = this.numerator / this.denominator;
        int newNumber = this.numerator - (this.denominator * wholeNumber);
        return wholeNumber + "   " + newNumber + " / " + this.denominator;
    }
    
}
