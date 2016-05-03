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
public class StackClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack stack = new Stack(6);
        assert(stack.capacity() == 6);
        assert(stack.toString().equals(""));
        stack.push(4);
        assert(stack.toString().equals("4 "));
        stack.push(6);
        assert(stack.toString().equals("4 6 "));
        stack.push(65);
        assert(stack.toString().equals("4 6 65 "));
        stack.pop();
        assert(stack.toString().equals("4 6 "));
        stack.makeEmpty();
        assert(stack.toString().equals(""));
        assert(stack.isEmpty());
        stack.push(8);
        assert(stack.toString().equals("8 "));
        assert(!stack.isEmpty());
        stack.push(3);
        stack.push(4);
        assert(stack.size() == 3);
        stack.push(9);
        stack.push(54);
        assert(!stack.isFull());
        stack.push(2);
        assert(stack.isFull());
        stack.push(33);
        assert(stack.toString().equals("8 3 4 9 54 2 "));
        assert(stack.size() == stack.capacity());
        stack.pop();
        stack.pop();
        assert(stack.toString().equals("8 3 4 9 "));
        assert(stack.top() == 9);
        stack.makeEmpty();
        stack.pop();
        stack.makeEmpty();
        assert(stack.top() == -1);
        
    }
    
}
