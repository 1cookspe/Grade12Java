/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author spencercook
 */
public class ReadInventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        StockItem stockItem1, stockItem2, stockItem3;
        
        File dataFile = new File("tuckShop.dat");
        
        FileInputStream fis = new FileInputStream(dataFile);
        ObjectInputStream input = new ObjectInputStream(fis);
        
        // cast object when read
        stockItem1 = (StockItem) input.readObject();
        stockItem2 = (StockItem) input.readObject();
        stockItem3 = (StockItem) input.readObject();
        
        // display objects
        System.out.println("Item 1 = " + stockItem1.toString());
        System.out.println("Item 2 = " + stockItem2.toString());
        System.out.println("Item 3 = " + stockItem3.toString());
        
        // close stream BOTH! 
        input.close();
    }
    
}
