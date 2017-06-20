/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author spencercook
 */
public class Inventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        StockItem item1 = new StockItem("Sweatshirts", 59.99);
        StockItem item2 = new StockItem("Ball caps", 19.99);
        StockItem item3 = new StockItem("Team jackets", 119.99);
        
        // declare the file
        File dataFile = new File("tuckShop.dat");
        
        // set up streams to write to file
        FileOutputStream fos = new FileOutputStream(dataFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        // write objects to file
        oos.writeObject(item1);
        oos.writeObject(item2);
        oos.writeObject(item3);
        
        // close the stream
        oos.close();
    }
    
}
