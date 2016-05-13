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

    // Object variables
    Node tail;
    Node head;

    // Default constructor
    public LinkedList() {
        this.tail = null;
        this.head = null;
    }

    @Override
    public int size() {
        int size = 0;
        if (!isEmpty()) {
            size = 1;
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

        if (!isEmpty()) {
            if (size() == 1) {
                this.head = null;
                this.tail = null;
            } else {
                Node nodeBefore = nodeBefore(this.head, str);
                if (nodeBefore == null) {
                    // DNE
                    System.out.println("This data does not exist in the linked list.");
                } else {
                    // REMOVE
                    nodeBefore.setNext(nodeBefore.getNext().getNext());
                    nodeBefore.getNext().setNext(null);
                }
            }
        }

    }

    @Override
    public String removeFromEnd() {

        String removedValue = "";

        if (!isEmpty()) {
            if (size() == 1) {
                removedValue = this.head.getData();
                this.head = null;
                this.tail = null;
            } else {
                Node nodeBefore = nodeBefore(this.head, this.tail.getData());
                removedValue = this.tail.getData();
                this.tail = nodeBefore;
                nodeBefore.setNext(null);
            }
        }

        return removedValue;
    }

    public Node nodeBefore(Node n, String str) {
        if (n == null || n.getNext() == null) {
            return null;
        }
        if (n.getNext().getData().equals(str)) {
            return n;
        } else {
            return nodeBefore(n.getNext(), str);
        }
    }

    @Override
    public String removeFromFront() {
        String removedValue = "";
        if (!isEmpty()) {
            if (size() == 1) {
                removedValue = this.head.getData();
                this.head = null;
                this.tail = null;
            } else {
                Node secondNode = this.head.getNext();
                removedValue = this.head.getData();
                this.head.setNext(null);
                this.head = secondNode;
            }
        }
        return removedValue;
    }

    @Override
    public String toString() {
        Node before = this.head;
        String outputString = "HEAD ---> ";
        while (before != null) {
            outputString += before.getData() + " ---> ";
            before = before.getNext();
        }
        outputString += "TAIL";
        return outputString;
    }

    @Override
    public String head() {
        String headData = "";
        if (!isEmpty()) {
            headData = this.head.getData();
        } else {
            System.out.println("The head has no value because the list is empty.");
        }
        return headData;
    }

    @Override
    public String tail() {
        String tailData = "";
        if (!isEmpty()) {
            tailData = this.tail.getData();
        } else {
            System.out.println("The head has no value because the list is empty.");
        }
        return tailData;
    }

}
