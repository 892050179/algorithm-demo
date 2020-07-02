package com.demo.queue;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        private E e;
        private Node next;

        public Node(){
            this.e = null;
            this.next = null;
        }

        public Node(E e){
            this.e = e;
        }

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(head == null){
            head = new Node(e);
            tail = head;
        } else {
          tail.next = new Node(e);
          tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node remNode = head;
        head = head.next;
        remNode.next = null;
        if (head == null){
            tail = null;
        }
        size--;
        return remNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot get from an empty queue.");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: ");
        stringBuilder.append("Front [");
        Node curNode = head;
        while (curNode != null){
            stringBuilder.append(curNode.e + "->");
            curNode = curNode.next;
        }
        stringBuilder.append("NULL] Tail");
        return stringBuilder.toString();
    }
}
