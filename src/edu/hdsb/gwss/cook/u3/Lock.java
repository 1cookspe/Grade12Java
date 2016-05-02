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
public abstract class Lock implements LockInterface {

    // Class variables
    public static int lastID = 0;

    // Instance variables
    protected boolean isOpen;
    protected int[] combo;
    protected int serialNumber; // Primary Key
    protected int failedAttempts;
    protected int max;
    protected boolean fixed;
    protected int numOfNumbers;
    private boolean comboSeen;
    protected String type;

    public Lock() {
        this.serialNumber = ++lastID;
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

    public int[] getCombo() {
        System.out.println("Attempting to get combination...");

        if (!this.comboSeen) {
            System.out.println("The combination is... ");
            this.comboSeen = true;
            return combo;
        }
        System.out.println("Sorry, you cannot see the combination at this time");
        return null;
    }

    public void setCombo(int[] combo) {
        System.out.println("Attempting to change combination...");
        if ((!this.fixed && this.isOpen) || this.combo == null) {
            this.combo = combo;
            System.out.print("Combination successfully changed to: ");
            for (int i = 0; i < combo.length; i++) {
                System.out.print(combo[i] + ", ");
            }
        } else {
            System.out.println("Sorry, the combination cannot be changed. ");
        }
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public String getType() {
        return this.type;
    }

    public int[] generateRandomCombo() {
        if (!this.comboSeen) {
            for (int i = 0; i < this.combo.length; i++) {
                this.combo[i] = (int) (Math.random() * this.max + 1);
            }
        }
        return this.combo;

    }

    public boolean openLock(int combo[]) {
        if (!this.isOpen && !isBricked()) {
            for (int i = 0; i < this.combo.length; i++) {
                if (combo[i] != this.combo[i]) {
                    this.failedAttempts++;
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
        if (this.failedAttempts >= 3) {
            return true;
        }
        return false;
    }

    public void lock() {
        this.isOpen = false;
        System.out.println("This " + this.type + " lock is locked");
    }

    public boolean equals(Lock lock) {
        if (lock == null) {
            return false;
        } else if (this.serialNumber == lock.getSerialNumber() && this.type.equals(lock.getType())) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (this.serialNumber > 0) {
            return true;
        } else if (this.combo.length == 0) {
            return false;
        }
        return false;
    }

    public String toString() {
        String isOpen = "";
        if (this.isOpen) {
            isOpen = "open";
        } else {
            isOpen = "closed";
        }

        String isFixed = "";
        if (this.fixed) {
            isFixed = "fixed";
        } else {
            isFixed = "configurable";
        }
        return "This " + this.type + " lock has a serial number of " + this.serialNumber + " and it is currently " + isOpen + ", with a " + isFixed + " combo. It has a maximum number of " + this.max + " with " + this.numOfNumbers + " possible numbers";
    }

}
