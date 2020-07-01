package com.demo.test;

import com.demo.linkedlist.LinkedList;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void linkedListTest(){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
            System.out.println(linkedList.getSize());
        }
        linkedList.add(3,11);
        System.out.println(linkedList);
    }
}
