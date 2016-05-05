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
public class QueueClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue queue = new Queue(6);
        assert(queue.size() == 0);
        assert(queue.capacity() == 6);
        queue.enqueue(4);

        queue.dequeue();

    }
    
}
