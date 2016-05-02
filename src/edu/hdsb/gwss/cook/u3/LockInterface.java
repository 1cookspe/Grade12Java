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
public interface LockInterface {
    public boolean isOpen();
    
    public int[] getCombo();
    
    public void setCombo(int[] combo);
    
    public int getSerialNumber();
    
    public int getFailedAttempts();
    
    public String getType();
    
    public int[] generateRandomCombo();
    
    public boolean openLock(int combo[]);
    
    public boolean isBricked();
    
    public void lock();
    
    public boolean equals(Lock lock);
    
    public String toString();
}
