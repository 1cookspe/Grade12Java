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

        if (isPrime(x)) {
            return x;
        }

        do {
            isPrime = true;
            x++;

            isPrime = isPrime(x);

        } while (!isPrime);

        return x;
    }

    public boolean isPrime(int x) {
        boolean isPrime = true;

        for (int i = 2; isPrime && i < x; i++) {
            if (x % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
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
        System.out.println("SIZE: " + size());
        System.out.println("capacity: " + capacity());
        return (double) size() / capacity();
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
        System.out.println("KEY IN REMOVE: " + key);
        Student student = null;
        System.out.println("CAPACITY IN REMOVE:" + capacity());
        int index = hash(key);
        System.out.println("INDEX IN REMOVE: " + index);
        boolean studentFound = false;
        boolean empty = false;

        while (!studentFound && !empty) {
            if (this.students[index] != null) {
                if ((int) this.students[index].getKey() == key) {
                    this.students[index] = null;
                    this.status[index] = -1;
                    studentFound = true;
                    System.out.println("Yeah!");
                } else {
                    index = (index + 1) % capacity();
                }
            } else {
                System.out.println("It is empty!");
                empty = true;
            }

        }
        return student;
    }

    public void put(int key, Student value) {
        int collisions = 0;
        int index = hash(key);
        if (key == 874) {
            System.out.println("Joe's index " + index);
            System.out.println("CAPACITY IN PUT: " + capacity());
        }
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

    public boolean contains(Student value) {
        boolean studentFound = false;
        boolean empty = false;
        System.out.println((int) value.getKey());
        int index = hash((int) value.getKey());
        //System.out.println("INDEX: " + index);
        while (!studentFound && !empty) {
            if (this.students[index].getKey() == value.getKey()) {
                studentFound = true;
            } else {
                if (this.students[index] == null) {
                    empty = true;
                }
                index = (index + 1) % capacity();
            }
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
            } else {
                if (this.students[index] == null) {
                    empty = true;
                }
                index = (index + 1) % capacity();
            }
        }
        return studentFound;
    }

    public int hash(int key) {
        return key % capacity();
    }

    public String toString() {
        String outputString = "";
        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i] != null) {
                outputString += this.students[i].toString() + "\t" + hash((int) this.students[i].getKey()) + "\n";
            } else {
                outputString += "Empty" + "\n";
            }
        }
        return outputString;
    }

}
