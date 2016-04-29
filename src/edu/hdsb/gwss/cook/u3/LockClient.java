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
public class LockClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MasterLock master = new MasterLock();
        for (int i = 0; i < master.combo.length; i++) {
            System.out.println(master.combo[i]);
        }
        while (!master.openLock() && !master.isBricked()) {
        if (master.openLock()) {
            System.out.println("Opened!");
        }
        }
        
       
    }
    
}
