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
        assert(hashTable.isEmpty());
        Student bob = new Student(123, "Bob", "Jones");
        hashTable.put(123, bob);
        assert(!hashTable.isEmpty());
        assert(hashTable.size() == 1);
        assert(hashTable.contains(bob));
        System.out.println(hashTable.capacity());
        hashTable.makeEmpty();
        assert(hashTable.isEmpty());
        assert(hashTable.size() == 0);
        
        // FILL TO LOAD FACTOR (9 STUDENTS)
        int initalCapacity = hashTable.capacity();
        for (int i = 0; i < 9; i++) {
            Student newStudent = new Student((int) (Math.random() * (999 - 1)) + 1, "John", "Scott");
            hashTable.put((int) newStudent.getKey(), newStudent);
            assert(hashTable.size() == i + 1);
            hashTable.resize();
            assert(hashTable.capacity() == initalCapacity); // CAPACITY DOES NOT CHANGE!
        }
        
        // AT LOAD FACTOR (10 STUDENTS)
        Student joe = new Student(874, "Joe", "Smith");
        hashTable.put((int) joe.getKey(), joe);
        assert(hashTable.size() == 10);
        hashTable.resize();
        System.out.println(hashTable.size());
        System.out.println(hashTable.capacity());
        assert(hashTable.capacity() == (hashTable.size() * 4) + 1);
        
    }
    
}
