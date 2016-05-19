/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u4;

/**
 *
 * @author 1cookspe
 */
public class HashTableClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        System.out.println(hashTable.nextPrime(6));
        assert(hashTable.isEmpty());
        Student bob = new Student(123, "Bob", "Jones");
        //hashTable.put(123, bob);
    }
    
}
