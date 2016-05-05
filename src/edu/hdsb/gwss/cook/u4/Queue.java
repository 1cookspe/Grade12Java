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
            this.front = 0;
            this.back = 0;
            this.queue[this.front] = value;
        } else if (!isFull()) {
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
        if (this.front < this.back) {
            return (this.back + 1) - this.front;
        } else if (this.front > this.back) {
            return (this.front) + (this.back % capacity());
        } else if (this.front == this.back && this.front != -1) {
            return 1;
        }
        return 0;
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
        for (int i = this.front; i <= this.back; i++) {
            outputString += this.queue[i] + " ";
        }
        return outputString;
    }

}
