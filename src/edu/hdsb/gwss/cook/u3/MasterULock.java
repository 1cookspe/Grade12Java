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
public class MasterULock extends Lock {
    // Class constants
    private static final int MAX = 9;
    private static final int NUM = 4;
    
    public MasterULock() {
        super(MAX, NUM);
        this.fixed = false;
        this.type = "MasterU";
    }
}
