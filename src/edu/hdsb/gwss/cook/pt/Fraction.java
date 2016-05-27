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
public class Fraction implements FractionInterface {
    
    protected int numerator;
    protected int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator > 0 || denominator < 0) {
            this.denominator = denominator;
        } else {
            this.denominator = (int) Math.random() * 10 + 1;
        }
    }

    public double size() {
        return (double) this.numerator / this.denominator;
    }

    public Fraction larger(Fraction f) {
        return larger(this, f);
    }

    public Fraction larger(Fraction f, Fraction g) {
        if (f.size() > g.size() || f.equals(g)) {
            return f;
        }
        return g;
    }

    public Fraction times(Fraction f) {
        return times(this, f);
    }

    public Fraction times(Fraction f, Fraction g) {
        int newNumerator = f.numerator * g.numerator;
        int newDenominator = f.denominator * g.denominator;
        Fraction newFraction = new Fraction(newNumerator, newDenominator);
        return newFraction;
    }

    public void reduce() {
        int reducedBy = gcd(this.numerator, this.denominator);
        this.numerator = this.numerator / reducedBy;
        this.denominator = this.denominator / reducedBy;
    }

    public boolean equals(Fraction f) {
        if (this.size() == f.size()) {
            return true;
        }
        return false;
    }

    public void invert() {
        int tempNum = this.numerator;
        this.numerator = this.denominator;
        this.denominator = tempNum;
        
        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }
    
    public String toString() {
        return this.numerator + " / " + this.denominator;
    }
    
//    public MixedFraction toMixed() {
//        if (this.numerator > this.denominator) { 
//        int wholeNumber = this.numerator / this.denominator;
//        int newNumerator = this.numerator - this.denominator;
//        MixedFraction mixed = new MixedFraction(newNumerator, this.denominator, wholeNumber);
//        return mixed;
//        
//        } 
//        return null;
//    }
    
    public int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }
    
}
