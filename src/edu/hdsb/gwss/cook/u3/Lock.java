/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u3;

import java.util.Scanner;

/**
 *
 * @author spencercook
 */
public abstract class Lock {

    // Class variables
    public static int lastID = 0;
    private Scanner input;

    // Instance variables
    protected boolean isOpen;
    protected int[] combo;
    protected int serialNumber; // Primary Key
    protected int failedAttempts;
    protected int max;
    protected boolean fixed;
    protected int numOfNumbers;

    public Lock() {
        this.serialNumber = (int) Math.random() * 200000 + 1;
        input = new Scanner(System.in);
    }

    // PRIMARY CONSTRUCTOR
    public Lock(int max, int numOfNumbers) {
        this();
        this.numOfNumbers = numOfNumbers;
        this.max = max;
        this.combo = new int[numOfNumbers];
        this.combo = generateRandomCombo();
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

    public int[] generateRandomCombo() {
        for (int i = 0; i < this.combo.length; i++) {
            this.combo[i] = (int) (Math.random() * this.max + 1);
        }
        return this.combo;
    }

    public boolean openLock() {
        if (!this.isOpen) {
            for (int i = 0; i < this.combo.length; i++) {
                System.out.print("Enter number: ");
                if (input.nextInt() != this.combo[i]) {
                    System.out.println("Combination incorrect!");
                    return false;
                }
            }
        } else {
            System.out.println("Lock is already open");
        }
        this.isOpen = true;
        return true;
    }

    public boolean isBricked() {
        if (this.failedAttempts == 3) {
            return true;
        }
        return false;
    }
    
    public void lock() {
        this.isOpen = false;
    }

}
