package com.demo.test;

import com.demo.stack.ArrayStack;
import org.junit.Test;

public class StackTest {

    @Test
    public void arrayStackTest(){
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 15; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);
        arrayStack.pop();
        System.out.println(arrayStack);
    }

}
