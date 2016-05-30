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
        hashTable.makeEmpty();
        assert(hashTable.isEmpty());
        assert(hashTable.size() == 0);
//        
//        // FILL TO LOAD FACTOR (9 STUDENTS)
        Student jeff = new Student(890, "Jeff", "Williams");
        hashTable.put((int) jeff.getKey(), jeff);
        assert(hashTable.size() == 1);
        
        int initalCapacity = hashTable.capacity();
        for (int i = 1; i < 9; i++) {
            Student newStudent = new Student((int) (Math.random() * (999 - 1)) + 1, "John", "Scott");
            hashTable.put((int) newStudent.getKey(), newStudent);
            assert(hashTable.size() == i + 1);
            //hashTable.resize();
            assert(hashTable.capacity() == initalCapacity);
            assert(hashTable.contains(newStudent));
        }
////        
////        // AT LOAD FACTOR (10 STUDENTS)
        Student joe = new Student(874, "Joe", "Smith");
        hashTable.put((int) joe.getKey(), joe);
        assert(hashTable.size() == 10);
        assert(hashTable.contains(joe)); 

        
        hashTable.resize();
        assert(hashTable.capacity() == (hashTable.size() * 4) + 1);
        System.out.println(hashTable.toString());
//        
        hashTable.remove((int) joe.getKey());
        assert(hashTable.size() == 9);
        assert(!hashTable.contains(joe));
        assert(!hashTable.containsKey((int) joe.getKey()));
        
        Student george = new Student(555, "George", "Joseph");
        hashTable.put((int) george.getKey(), george);
        assert(hashTable.get((int) george.getKey()).equals(george));
        assert(hashTable.size() == 10);
        
    }
    
}
