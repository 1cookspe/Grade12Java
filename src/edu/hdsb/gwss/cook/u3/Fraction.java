/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

/**
 *
 * @author 1cookspe
 */
public class Fraction {

    // OBJECT / INSTANCE VARIABLES

    private int num;
    private int den;

    public Fraction() {
        this.den = 1;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        if (den == 0) {
            System.out.println("Invalid denominator; setting to 1");
            this.den = 1;
        } else {
            this.den = den;
        }
    }

    @Override
    public String toString() {
        return "Fraction " + num + " / " + den;
    }

    public Fraction(int num, int den) {
        this.num = num;
        this.setDen(den);
    }
}
