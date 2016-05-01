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
public class LockClient {

    static Scanner input;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        input = new Scanner(System.in);

        System.out.println("Testing Master Lock -----------------------------------------------");
        testMaster();
        System.out.println("Testing Dudley Lock -----------------------------------------------");
        testDudley();
        System.out.println("Testing MasterU Lock -----------------------------------------------");
        testMasterU();
        System.out.println("Testing Android Lock -----------------------------------------------");
        testAndroid();
    }

    public static void testMaster() {
        MasterLock master = new MasterLock();
        for (int i = 0; i < master.combo.length; i++) {
            System.out.println(master.combo[i]);
        }

        master.lock();

        int[] userCombo = getInputCombo(master.combo);

        if (master.openLock(userCombo)) {
            System.out.println("Opened!");
        } else {
            System.out.println("Combination incorrect!");
        }

        master.setCombo(userCombo);

        System.out.println(master.toString());
    }

    public static void testMasterU() {
        MasterULock masterU = new MasterULock();
        int[] thisCombo = masterU.getCombo();
        for (int i = 0; i < masterU.combo.length; i++) {
            System.out.println(thisCombo[i]);
        }
        
        
    }

    public static void testDudley() {

    }

    public static void testAndroid() {

    }

    public static int[] getInputCombo(int[] combo) {
        int[] proposedCombo = new int[combo.length];
        for (int i = 0; i < combo.length; i++) {
            System.out.print("Enter a number: ");
            proposedCombo[i] = input.nextInt();
        }
        return proposedCombo;
    }
    
    public static void printCombo(Lock lock) {
        
    }

}
