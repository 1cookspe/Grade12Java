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
        this.status = new int[this.students.length];
    }

    public int nextPrime(int x) {
        
        
        boolean isPrime = true;
        
        do {
            isPrime = true;
            x++;
            for (int i = 2; isPrime && i < x; i++) {
                if (x % i == 0) {
                    isPrime = false;
                }
            }
            
        } while( !isPrime );
        
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
        return size() / capacity();
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
        if (loadFactor() > 0.75) {
            int newCapacity = size() * 4;
            Student[] oldStudents = this.students;
            this.students = new Student[nextPrime(newCapacity)];
            for (int i = 0; i < oldStudents.length; i++) {
                if (oldStudents[i] != null) {
                    this.students[i] = oldStudents[i];
                }
            }
        }
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
        
        System.out.println("Number of collisions: " + collisions);
    }

    public boolean contains( Student value ) {
        boolean studentFound = false;
        boolean empty = false;
        while (!studentFound || !empty) {
           
        }
        return studentFound;
    }

    public boolean containsKey(int key) {
        boolean studentFound = false;
        boolean empty = false;
        int index = hash(key);
        while (!studentFound || !empty) {
            if (this.students[index].getKey() == key) {
                studentFound = true;
            }
        }
        return studentFound;
    }

    public int hash(int key) {
        return key % capacity();
    }

}
