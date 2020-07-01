package com.demo.test;

import com.demo.queue.ArrayQueue;
import com.demo.queue.LoopQueue;
import com.demo.queue.Queue;
import org.junit.Test;

import java.util.Random;

/**
 * 队列的有关测试
 */
public class QueueTest {

    @Test
    public void arrayQueueTest(){
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            arrayQueue.enqueue(i);
        }
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue);
    }

    @Test
    public void loopQueueTest(){
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            loopQueue.enqueue(i);
        }
        System.out.println(loopQueue);
        System.out.println(loopQueue.dequeue());
        System.out.println(loopQueue);
    }

    @Test
    public void compare(){
        testQueue(new LoopQueue<Integer>() , 100000);
        testQueue(new ArrayQueue<Integer>() , 100000);
    }

    /**
     * 打印不同队列入队出队一定次数所需时间（使用int类型测试，打印时间单位为秒）
     * @param queue 实现的队列
     * @param frequency 入队出队次数
     */
    private void testQueue(Queue<Integer> queue,int frequency){
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < frequency; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < frequency; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000000.0);
    }

}
