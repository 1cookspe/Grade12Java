/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

/**
 *
 * @author spencercook
 */
public class Dudley extends Lock {
    // Class constants
    private static final int MAX = 59;
    private static final int NUM = 3;
    
    public Dudley() {
        super(MAX, NUM);
        this.fixed = true;
        this.type = "Dudley";
    }
    
}
