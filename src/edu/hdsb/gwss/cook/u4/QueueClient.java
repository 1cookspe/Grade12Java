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

        Queue q = new Queue(10);

        // EMPTY QUEUE
        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.size() == 0);
        assert (q.capacity() == 10);
        assert (q.isEmpty());
        assert (!q.isFull());

        // FILL THE QUEUE
        for (int i = 0; i < q.capacity() - 1; i++) {
            q.enqueue(i);

            assert (q.front() == 0);
            assert (q.back() == i);
            assert (q.size() == (i + 1));
            assert (q.capacity() == 10);
            assert (!q.isEmpty());
            assert (!q.isFull());
        }

        // FILL THE LAST ELEMENT
        q.enqueue(q.capacity() - 1);
        assert (q.front() == 0);
        assert (q.back() == q.capacity() - 1);
        assert (q.size() == (q.capacity() - 1 + 1));
        assert (q.capacity() == 10);
        assert (!q.isEmpty());
        assert (q.isFull());
        
        // OVER-FILL QUEUE
        q.enqueue( q.capacity() );
         assert (q.front() == 0);
        assert (q.back() == q.capacity() - 1);
        assert (q.size() == (q.capacity() - 1 + 1));
        assert (q.capacity() == 10);
        assert (!q.isEmpty());
        assert (q.isFull());      
        
        // MAKE EMPTY
        q.makeEmpty();
        
        assert (q.front() == -1);
        assert (q.back() == -1);
        assert (q.size() == 0);
        assert (q.capacity() == 10);
        assert (q.isEmpty());
        assert (!q.isFull());

        // FILL THE QUEUE
        for (int i = 0; i < q.capacity(); i++) {
            q.enqueue(i);

            assert (q.front() == 0);
            assert (q.back() == i);
            assert (q.size() == (i + 1));
            assert (q.capacity() == 10);
            assert (!q.isEmpty());
            if( i == q.capacity() - 1 )
                assert (q.isFull());
            else
                assert (!q.isFull());
        }
        System.out.println( "AT START: " + q.size() + " vs " + q.capacity() );
        
        // FILL THE QUEUE
        for (int i = 0; i < q.capacity(); i++) {
            assert( q.dequeue() == i );
            q.enqueue( q.capacity() + i );
            assert (q.front() == i + 1);
            assert (q.back() == q.capacity() + i );
            System.out.println( q.size() + " vs " + q.capacity() );
            assert (q.size() == q.capacity() );
            assert (q.capacity() == 10);
        }
        
        System.out.println(q.toString());
        q.dequeue();
        System.out.println(q.toString());
        q.enqueue(47);
        System.out.println(q.toString());
        q.dequeue();
        System.out.println(q.toString());
    }

}
