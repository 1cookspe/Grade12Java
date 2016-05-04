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
        return this.queue[this.front];
    }

    @Override
    public int back() {
        return this.queue[this.back];
    }

    @Override
    public void enqueue(int value) {
        if (isEmpty()) {
            this.front = 0; // ADD CASE TO ADD BOTH IN
        } else if (!isFull()) {
            this.queue[this.back + 1] = value;
            this.back++;
        } else {
            System.out.println("A value cannot be enquened to this queue because the queue is full.");
        }
    }

    @Override
    public int dequeue() {
        int value = -1;
        if (!isEmpty()) {
            value = this.queue[front];
            front--;
        } 
        System.out.println("This queue cannot be queued because it is empty.");
        return value;
    }

    @Override
    public int size() {
        return this.back + 1;
    }

    @Override
    public int capacity() {
        return this.queue.length;
    }

    @Override
    public boolean isEmpty() {
        if (back == -1 && front == -1) {
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
        for (int i = this.back; i <= this.front; i++) {
            outputString += this.queue[i] + " ";
        }
        return outputString;
    }

}
