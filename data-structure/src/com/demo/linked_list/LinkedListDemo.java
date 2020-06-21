package com.demo.linked_list;

/**
 * 链表
 */
public  class LinkedListDemo {

    private Node head;  // 头节点
    private int size;   // 长度
    private Node last;  // 尾节点

    public LinkedListDemo(){
        this.size = 0;
    }

    /**
     * 插入元素
     * @param element
     * @param index
     */
    public void insert(int element,int index){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node insertNode = new Node(element);

        if(size == 0){
            head = insertNode;
            last = insertNode;
        } else if(index == 0) {
            //插入头
            insertNode.next = head;
            head = insertNode;
        } else if(index == size) {
            //插入尾
            last.next = insertNode;
            last = insertNode;
        } else {
            //插入中间
            Node preNode = getNode(index - 1);
            insertNode.next = preNode.next;
            preNode.next = insertNode;
        }
        size++;
    }

    /**
     * 删除元素
     * @param index
     * @return
     */
    public int remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("超出链表节点范围");
        }
        Node removeNode;
        if (index == 0){
            removeNode = head;
            head = removeNode.next;
        } else {
            Node preNode = getNode(index - 1);
            removeNode = preNode.next;
            preNode.next = removeNode.next;
            if (index == size - 1){
                last = preNode;
            }
        }
        removeNode.next = null;
        return removeNode.data;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node node = head;
        while (node.next != null){
            str.append(node.data);
            str.append(',');
            node = node.next;
        }
        str.append(node.data);
        return str.toString();
    }

    /**
     * 获取某一位置的节点
     * @param index
     * @return
     */
    private Node getNode(int index){
        Node node = head;
        while (index > 0){
            node = node.next;
            index--;
        }
        return node;
    }

    /**
     * 节点类
     */
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

}
