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
public class LinkedListClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // WHEN EMPTY
        assert(list.size() == 0);
        assert(list.head().equals(""));
        assert(list.tail().equals(""));
        assert(list.isEmpty());
        list.addAtEnd("Hello");
        list.addAtEnd("Hi");
        list.addAtEnd("5");
        assert(list.size() == 3);
        assert(list.removeFromEnd().equals("5"));
        assert(list.removeFromFront().equals("Hello"));
        assert(list.size() == 1);
        System.out.println(list.head.getData());
        
    }
    
}
