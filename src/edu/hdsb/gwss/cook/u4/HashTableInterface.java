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
public interface HashTableInterface {

    public int size();
    
    public int capacity();
    
    public double loadFactor();
    
    public void makeEmpty();
    
    public boolean isEmpty();
    
    public void resize();
    
    public Student get( int key );
    
    public Student remove( int key );
    
    public void put( int key, Student value);
    
    public boolean contains( Student value );
    
    public boolean containsKey( int key );
    
    public int hash( int key );
    
    public String toString();

}
