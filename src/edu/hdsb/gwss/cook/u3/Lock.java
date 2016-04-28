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
public abstract class Lock {
    // Instance variables
    private boolean isOpen;
    private int[] combo;
    private int serialNumber; // Primary Key
    private int failedAttempts;
    private int max;

    public Lock() {
        this.serialNumber = (int) Math.random() * 200000 + 1;
    }
    
    // PRIMARY CONSTRUCTOR
    public Lock(int max, int[] combo) { 
        this.combo = combo;
        this.max = max;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public int[] getCombo() {
        return combo;
    }

    public void setCombo(int[] combo) {
        this.combo = combo;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }
    
    public int[] generateRandomCombo(int max) {
        for (int i = 0; i < this.combo.length; i++) {
            this.combo[i] = (int) Math.random() * max + 1;
        }
        return this.combo;
    }
    
    
    
}
