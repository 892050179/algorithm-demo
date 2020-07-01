package com.demo.linkedlist;

/**
 * 链表
 * @param <E>
 */
public class LinkedList<E> {

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

        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        this.dummyHead = new Node();
    }

    public void addFirst(E e){
        add(0,e);
    }

    //  在链表的index位置添加元素（在链表中非常用操作）
    public void add(int index,E e){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Add failed. Index is illegal.");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        preNode.next = new Node(e,preNode.next);
        size++;
    }

    public void addLast(E e){
        add(size,e);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //  获得链表的第index个元素（在链表中非常用操作）
    public E get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Get failed.Index is illegal.");
        }
        Node res = dummyHead.next;
        for (int i = 0; i < index;i++){
            res = res.next;
        }
        return res.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    //  修改链表的第index个元素（在链表中非常用操作）
    public void set(int index,E e){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Set failed.Index is illegal.");
        }
        Node curNode = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.e = e;
    }

    //  删除index位置的元素（在链表中非常用操作）
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Remove failed.Index is illegal.");
        }
        Node preNode = dummyHead;
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }
        Node remNode = preNode.next;
        preNode.next = remNode.next;
        remNode.next = null;
        size--;
        return remNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public void removeElement(E e){
        Node preNode = dummyHead;
        Node remNode = null;
        while (preNode.next != null){
            if (preNode.next.e.equals(e)){
                remNode = preNode.next;
                break;
            }
            preNode = preNode.next;
        }
        if (remNode == null){
            throw new RuntimeException("Remove failed.Not found element.");
        }
        preNode.next = remNode.next;
        remNode.next = null;
        size--;
    }

    public boolean contains(E e){
        Node curNode = dummyHead.next;
        while (curNode != null){
            if(e.equals(curNode.e)){
                return true;
            }
            curNode = curNode.next;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node curNode = dummyHead.next;curNode != null;curNode = curNode.next){
            stringBuilder.append(curNode.e + "->");
        }
        stringBuilder.append("NUll");
        return stringBuilder.toString();
    }
}
