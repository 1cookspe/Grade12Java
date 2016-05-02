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

    private int[] stack;
    private int top;

    public Stack() {
        int length = (int) Math.random() * 10 + 1;
        this.stack = new int[length];
        this.top = -1;
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
        if (top == capacity()) {
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
        for (int i = 0; i < this.stack.length; i++) {
            this.stack[i] = 0;
            top = -1;
        }
    }

    @Override
    public void pop(int value) {
        stack[top] = 0;
        top--;
    }
    
    @Override
    public void push(int value) {
        stack[top + 1] = value;
        top++;
    }
    
    @Override
    public String toString() {
        String outputStack = "";
        for (int i = 0; i < this.stack.length; i++) {
            outputStack += this.stack[i] + ", ";
        }
        return outputStack;
    }

}
