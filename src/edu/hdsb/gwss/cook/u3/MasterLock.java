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
public class MasterLock extends Lock {
    
    public MasterLock() {
       super(39, 3);
       this.fixed = true;
    }
    
    public MasterLock(int serialNumber) {
        this();
        this.serialNumber = serialNumber;
    }

    public MasterLock(int[] combo) {
        this();
        this.combo = combo;
    }
    
}
