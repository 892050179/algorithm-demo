package com.demo.test;

import com.demo.stack.ArrayStack;
import com.demo.stack.LinkedListStack;
import com.demo.stack.Stack;
import org.junit.Test;

import java.util.Random;

public class StackTest {

    @Test
    public void implStackTest(){
//        implStackTest(new ArrayStack<Integer>());
//        implStackTestTemplate(new LinkedListStack<>());
    }

    @Test
    public void implCompareTest(){
        final int frequency = 100000;
        implCompareTestTemplate(new ArrayStack<>(),frequency);
        implCompareTestTemplate(new LinkedListStack<>(),frequency);
    }

    /**
     * 使用Integer类型测试实现的链表
     * @param stack
     */
    private void implStackTestTemplate(Stack<Integer> stack){
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        for (int i = 0; i < 3; i++) {
            stack.pop();
            System.out.println(stack);
        }
    }

    /**
     * 打印不同实现方式栈进栈出栈一定次数所需时间（使用int类型测试，打印时间单位为秒）
     * @param stack
     * @param frequency
     */
    private void implCompareTestTemplate(Stack<Integer> stack,int frequency){
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < frequency; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < frequency; i++) {
            stack.pop();
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000000.0);
    }

}
