/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.cook.u4;

import java.util.Arrays;

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
        int prime = nextPrime(capacity);
        this.students = new Student[prime];
    } 
    
    public int nextPrime(int x) {
        boolean isPrime = true;
        for (int i = 2; isPrime && i < x; i++) {
            if (x % i == 0) {
                isPrime = false;
            }
        }
        return 0;
    }
    
    public int size() {
        // LOOP THROUGH ARRAY, count non-null items
        // Deleted items
        int size = 0;
        for (int i = 0; i < this.students.length; i++) {
//            if ()
        }
        return size;
    }
    
    public int capacity() {
        return this.students.length;
    }
    
    public Student get(int key) {
       Student student = new Student(234, "Jeff", "Jones");
        // Find it @ hash value
        // Is that the student you are looking for?
        // Yes! Done. Return:
        // No! Is the one below the one you're looking for? 
        return student;
    }
    
    public double loadFactor() {
        return 0.0;
    }
    
    public void makeEmpty() {
        
    }
    
    public boolean isEmpty() {
        return false;
    }
    
    public void resize() {
        
    }
    
    public Student remove(int key) {
        Student student = new Student(123, "John", "Brown");
        return student;
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
        return 0;
    }

}