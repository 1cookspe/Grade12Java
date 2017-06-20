/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExamReview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author spencercook
 */
public class Inventory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Clothes sweatshirt = new Clothes("Sweatshirt", 13);
        Clothes hat = new Clothes("Hat", 10);
        
        File file = new File("clothes.dat");
        FileOutputStream fos = new FileOutputStream(file);        
        ObjectOutputStream os = new ObjectOutputStream(fos);
        
        os.writeObject(sweatshirt);
        os.writeObject(hat);
        os.close();
        
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Clothes sweatshirt2 = (Clothes) ois.readObject();
        ois.close();
    }
    
}
