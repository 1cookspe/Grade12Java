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
public class Stack implements StackInterface {

    private static final int DEFAULT_SIZE = 15;

    private int[] stack;
    private int top;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int length) {
        this.stack = new int[length];
        this.top = -1;
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
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
    public int size() {
        return this.top + 1;
    }

    @Override
    public int capacity() {
        return this.stack.length;
    }

    @Override
    public void makeEmpty() {
        top = -1;
    }

    @Override
    public int pop() {
        int value = -1;
        if (!this.isEmpty()) {
            value = this.stack[top];
            top--;
        } else {
            System.out.println("This stack cannot be popped because it is empty.");
        }
        return value;
    }

    @Override
    public void push(int value) {
        if (!this.isFull()) {
            stack[top + 1] = value;
            top++;
        } else {
            System.out.println("A value cannot be pushed to this stack because it is full.");
        }
    }

    @Override
    public String toString() {
        String outputStack = "";
        for (int i = 0; i <= this.top; i++) {
            outputStack += this.stack[i] + " ";
        }
        return outputStack;
    }

    @Override
    public int top() {
        if (!this.isEmpty()) {
            return this.stack[top];
        } 
        return -1;
    }

}
