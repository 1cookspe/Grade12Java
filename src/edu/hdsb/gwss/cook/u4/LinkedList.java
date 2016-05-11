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
public class LinkedList implements LinkListInterface {

    Node tail;
    Node head;

    public LinkedList() {
        this.tail = null;
        this.head = null;
    }

    @Override
    public int size() {
        int size = 0;
        if (!isEmpty()) {
            Node node = this.head;
            while (node.getNext() != null) {
                size++;
                node = node.getNext();
            }
        }
        return size;
    }

    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null && this.tail == null) {
            return true;
        }
        return false;
    }

    @Override
    public void addAtFront(String str) {
        Node newNode = new Node(str);
        if (!isEmpty()) {
            newNode.setNext(this.head);
            this.head = newNode;
        } else {
            this.head = newNode;
            this.tail = newNode;
        }
    }

    @Override
    public void addAtEnd(String str) {
        Node newNode = new Node(str);
        if (!isEmpty()) {
            this.tail.setNext(newNode);
            this.tail = newNode;
        } else {
            this.head = newNode;
            this.tail = newNode;
        }
    }

    @Override
    public void remove(String str) {
        Node newNode = this.head;
        String removedValue = "";
        do {
            
        } while (!newNode.getNext().getData().equals(str));
    }

    @Override
    public String removeFromEnd() {
        String removedValue = "";
//        if (node.getNext().getNext() != null) {
//            node.setNext(null);
//        } else {
//            removeFromEnd();
//        }
        return removedValue;
    }

    @Override
    public String removeFromFront() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "";
    }

    public void loopForward() {
        Node node = this.head;
        while(node.getNext() != null) {
            node = node.getNext();
        }
    }

}
