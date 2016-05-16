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
public class HashTable implements HashTableInterface {
    
    private static final int DEFAULT_SIZE = 13;
    private Student[] students;
    
    public HashTable() {
        this(DEFAULT_SIZE);
    }
    
    public HashTable(int capacity) {
        this.students = new Student[capacity];
    } 
    
    public static int nextPrime(int x) {
        // Find next prime
        return 0;
    }
    
    public int size() {
        // LOOP THROUGH ARRAY, count non-null items
        // Deleted items
        return 0;
    }
    
    public int capacity() {
        return 0;
    }
    
    public Student get(int key) {
       
        // Find it @ hash value
        // Is that the student you are looking for?
        // Yes! Done. Return:
        // No! Is the one below the one you're looking for? 
        
    }
    
    public double loadFactor() {
        return 0;
    }
    
    public void makeEmpty() {
        
    }
    
    public boolean isEmpty() {
        return false;
    }
    
    public void resize() {
        
    }
    
    public Student remove(int key) {
        
    }
    
    public void put(int key, Student value) {
        
    }
    
    public boolean contains(int key) {
        return false;
    }
    
    public boolean containsKey(int key) {
        return false;
    }
    
    public int hash(int key) {
        
    }

}