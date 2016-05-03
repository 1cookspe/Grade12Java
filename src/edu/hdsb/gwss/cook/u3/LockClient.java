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
    static MasterLock master = new MasterLock();
    static MasterULock masterU = new MasterULock();
    static Dudley dudley = new Dudley();
    static Android android = new Android();

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

        assert (!android.equals(dudley));
    }

    public static void testMaster() {
        assert (master.getSerialNumber() == 1);
        assert(master.type.equals("Master"));

        printCombo(master);

        master.lock();
        assert (!master.isOpen);

        int[] userCombo = getInputCombo(master.combo);

        checkCombo(master, userCombo);

        System.out.println("Enter new combination: ");
        master.setCombo(getInputCombo(userCombo));
        assert (master.combo != userCombo);
        
        assert(master.isValid());

        System.out.println("\n" + master.toString());
    }

    public static void testMasterU() {
        assert (masterU.getSerialNumber() == 2);
        assert(masterU.failedAttempts == 0);

        printCombo(masterU);

        masterU.lock();

        int[] userCombo = getInputCombo(masterU.combo);

        checkCombo(masterU, userCombo);

        System.out.println("Enter new combination: ");
        System.out.println(masterU.isOpen);
        masterU.setCombo(getInputCombo(userCombo));
        
        assert(masterU.isValid());

        System.out.println("\n" + masterU.toString());

    }

    public static void testDudley() {
        assert (dudley.getSerialNumber() == 3);

        printCombo(dudley);

        dudley.lock();
        assert (!dudley.isOpen);
        
        int[] randomCombo = {5, 3, 7, 3};
        checkCombo(dudley, randomCombo);
        assert(dudley.failedAttempts == 1);

        int[] userCombo = getInputCombo(dudley.combo);

        checkCombo(dudley, userCombo);

        System.out.println("Enter new combination: ");
        dudley.setCombo(getInputCombo(userCombo));
        
        assert (dudley.combo != userCombo);
        
        assert(dudley.isValid());

        System.out.println("\n" + dudley.toString());
    }

    public static void testAndroid() {
        assert (android.getSerialNumber() == 4);
        assert(android.max == 9);
        
        int[] wrongCombo = {64, 32, 53, 22};

        printCombo(android);

        android.lock();
        
        checkCombo(android, wrongCombo);
        checkCombo(android, wrongCombo);
        checkCombo(android, wrongCombo);
        
        assert(android.isBricked());

        System.out.println("Enter new combination: ");
        System.out.println(android.isOpen);
        
        assert(android.isValid());

        System.out.println("\n" + android.toString());
    }

    public static int[] getInputCombo(int[] combo) {
        int[] proposedCombo = new int[combo.length];
        for (int i = 0; i < combo.length; i++) {
            System.out.print("Enter a number: ");
            int nextInt = Integer.parseInt(input.nextLine());
            if (nextInt >= 0 && nextInt == (int)nextInt) {
                proposedCombo[i] = nextInt;
            } else {
                System.out.println("Invalid input");
            }
        }
        return proposedCombo;
    }

    public static void printCombo(Lock lock) {
        int[] combo = lock.getCombo();
        for (int i = 0; i < combo.length; i++) {
            System.out.println(combo[i]);
        }
    }

    public static void checkCombo(Lock lock, int[] combo) {
        if (lock.openLock(combo)) {
            System.out.println("Opened!");
        } else {
            System.out.println("Combination incorrect!");
        }
    }

}
