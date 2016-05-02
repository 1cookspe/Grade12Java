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
public interface StackInterface {
    public boolean isEmpty();
    
    public boolean isFull();
    
    public int size();
    
    public int capacity();
    
    public void makeEmpty();
    
    public void pop(int value);
    
    public void push(int value);
    
    public String toString();
}
