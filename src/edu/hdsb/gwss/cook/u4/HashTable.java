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

    public static final int DELETED = -1;
    public static final int EMPTY = 0;
    public static final int OCCUPIED = 1;

    private static final int DEFAULT_SIZE = 13;
    private Student[] students;
    private int[] status;

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
        return x;
    }

    public int size() {
        // LOOP THROUGH ARRAY, count non-null items
        // Deleted items
        int size = 0;
        for (int i = 0; i < this.students.length; i++) {
            if (students[i] != null) {
                size++;
            }
        }
        return size;
    }

    public int capacity() {
        return this.students.length;
    }

    public Student get(int key) {
        Student student = null;
        boolean studentFound = false;
        boolean empty = false;
        // Find it @ hash value
        int index = hash(key);

        while (!studentFound || !empty) {
        // STOP: 1. found student
            // or, till you hit an empty spot.

            // Is that the student you are looking for?
            if (students[index].getKey() == key) {
                student = students[index];
                studentFound = true;
            } else {
                if (students[index] == null) {
                    empty = true;
                }
                index = (index + 1) % capacity();
            }
        }
        // Yes! Done. Return:
        // No! Is the one below the one you're looking for? 
        return student;
    }

    public double loadFactor() {
        return 0.0;
    }

    public void makeEmpty() {
        this.students = new Student[capacity()];
        this.status = new int[this.students.length];
    }

    public boolean isEmpty() {
        boolean noData = true;
        for (int i = 0; i < this.students.length && noData; i++) {
            if (this.students[i] != null) {
                noData = false;
            }
        }
        return noData;
    }

    public void resize() {

    }

    public Student remove(int key) {
        Student student = null;
        int index = hash(key);
        boolean studentFound = false;
        boolean empty = false;

        while (!studentFound || !empty) {
            if (students[index].getKey() == key) {
                this.students[index] = null;
                this.status[index] = -1;
                studentFound = true;
            } else {
                if (students[index] == null) {
                    empty = true;
                }
                index = (index + 1) % capacity();
            }
        }
        return student;
    }

    public void put(int key, Student value) {
        int collisions = 0;
        int index = hash(key);
        boolean spotFound = false;

        while (!spotFound) {
            if (this.status[index] != 1) {
                this.students[index] = value;
                spotFound = true;
                this.status[index] = 1;
            } else {
                collisions++;
                index = (index + 1) % capacity();
            }
        }
    }

    public boolean contains(int key) {
        return false;
    }

    public boolean containsKey(int key) {
        return false;
    }

    public int hash(int key) {
        return key % capacity();
    }

}
