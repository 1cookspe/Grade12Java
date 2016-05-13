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
        list.addAtFront("Goodbye");
        assert(list.toString().equals("HEAD ---> Goodbye ---> Hello ---> Hi ---> 5 ---> TAIL"));
        assert(list.removeFromEnd().equals("5"));
        assert(list.removeFromFront().equals("Goodbye"));
        assert(list.size() == 2);
        assert(list.removeFromFront().equals("Hello"));
        assert(list.head().equals("Hi"));
        assert(list.removeFromEnd().equals("Hi"));
        assert(list.size() == 0);
        assert(list.isEmpty());
        assert(list.head().equals(""));
        assert(list.toString().equals("HEAD ---> TAIL"));
        
        // FILL WITH 20 VALUES
        for (int i = 0; i < 10; i++) {
            list.addAtFront("" + i);
            list.addAtEnd("" + i);
            assert(list.head().equals("" + i));
            assert(list.tail().equals("" + i));
            list.remove("" + i);
        }
    }
    
}
