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
public class Node implements NodeInterface {
    
    private String data;
    private Node next;

    public Node( String newData ) {
        this.data = newData;
        this.next = null;
    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setNext( Node nextNode ) {
        this.next = nextNode;
    }

    @Override
    public String getData() {
        return this.data;
    }     

}
