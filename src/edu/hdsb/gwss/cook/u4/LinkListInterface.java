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
public interface LinkListInterface {

    public int size();
    
    public void makeEmpty();
    
    public boolean isEmpty();
    
    /**
     * Adds a node to the front of the linked list .
     *
     * @param str
     */
    public void addAtFront( String str );
    
    /**
     * Adds a node to the end of the linked list.
     *
     * @param str
     */
    public void addAtEnd( String str );
    
    /**
     * Deletes a node in the linked list.
     *
     * @param str
     */
    public void remove( String str );
    public String removeFromEnd();
    public String removeFromFront();
    
    public String head();
    public String tail();
    
    /**
     * Creates a string that lists the nodes of the linked list.
     *
     * @return string
     */
    @Override
    public String toString( );
    

}
