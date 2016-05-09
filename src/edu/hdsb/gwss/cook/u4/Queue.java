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
public class Queue implements QueueInterface {

    private static final int DEFAULT_SIZE = 15;

    private int[] queue;
    private int front; // TOP
    private int back; // BOTTOM

    public Queue() {
        this(DEFAULT_SIZE);
    }

    public Queue(int length) {
        this.queue = new int[length];
        this.front = -1;
        this.back = -1;
    }

    @Override
    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[this.front];
    }

    @Override
    public int back() {
        if (isEmpty()) {
            return -1;
        }
        return this.queue[this.back];
    }

    @Override
    public void enqueue(int value) {
        if (isEmpty()) {
            System.out.println("It's empty!");
            this.front = 0;
            this.back = 0;
            this.queue[this.front] = value;
        } else if (!isFull()) {
            System.out.println("It's not full!");
            this.back++;
            this.back = this.back % capacity();
            this.queue[this.back] = value;
        } else {
            System.out.println("A value cannot be enquened to this queue because the queue is full.");
        }
    }

    @Override
    public int dequeue() {
        int value = -1;
        if (size() == 1) {
            value = this.queue[this.front];
            this.back = -1;
            this.front = -1;
        } else if (!isEmpty()) {
            value = this.queue[this.front];
            this.front++;
            this.front = this.front % capacity();
        } else {
            System.out.println("This queue cannot be deqeued because it is empty.");
        }
        return value;
    }

    @Override
    public int size() {
        int size = -1;
        // EMPTY
        if (this.front == -1 && this.back == -1) {
            size = 0;
        } else if (this.front == this.back) {
            size = 1;
        } else if (this.front < this.back) {
            size = this.back + 1 - this.front;
        } else {
            size = (this.back + capacity()) + 1 - this.front;
        }
        return size;
    }

    @Override
    public int capacity() {
        return this.queue.length;
    }

    @Override
    public boolean isEmpty() {
        if (this.back == -1 && this.front == -1) {
            return true;
        }
        return false;

    }

    @Override
    public boolean isFull() {
        if (size() == capacity()) {
            return true;
        }
        return false;
    }

    @Override
    public void makeEmpty() {
        this.back = -1;
        this.front = -1;
    }

    @Override
    public String toString() {
        String outputString = "";
        System.out.println("Back: " + this.back);
        System.out.println("Front: " + this.front);
        if (!this.isEmpty()) {
            if (this.front <= this.back) {
                for (int i = this.front; i <= this.back; i++) {
                    outputString += this.queue[i] + " ";
                }
            } else if (this.front > this.back) {
                for (int i = this.front; i < capacity(); i++) {
                    outputString += this.queue[i] + " ";
                }
                for (int i = 0; i <= this.back; i++) { 
                    outputString += this.queue[i] + " ";
                }
            }

        } else {
            System.out.println("Empty");
        }

//        int startingPoint = 0;
//        int endPoint = 0;
//        if (front <= back) {
//            if (front >= 0) {
//                startingPoint = this.front;
//            }
//            endPoint = this.back;
//        } else {
//            if (back >= 0) {
//                startingPoint = this.back;
//            }
//            endPoint = this.front;
//        }
//        for (int i = startingPoint; i <= endPoint; i++) {
//            outputString += this.queue[i] + " ";
//        }
        return outputString;
    }

}
