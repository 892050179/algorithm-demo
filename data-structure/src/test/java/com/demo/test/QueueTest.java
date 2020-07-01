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
    public void implQueueTest(){
//        implQueueTestTemplate(new ArrayQueue<>());
        implQueueTestTemplate(new LoopQueue<>());
    }

    /**
     * 使用Integer类型测试实现的队列
     * @param queue
     */
    private void implQueueTestTemplate(Queue<Integer> queue){
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
        for (int i = 0; i < 3; i++) {
            queue.dequeue();
            System.out.println(queue);
        }
    }

    @Test
    public void implCompareTestTemplate(){
        implCompareTestTemplate(new LoopQueue<>() , 100000);
        implCompareTestTemplate(new ArrayQueue<>() , 100000);
    }

    /**
     * 打印不同实现方式队列入队出队一定次数所需时间（使用int类型测试，打印时间单位为秒）
     * @param queue 实现的队列
     * @param frequency 入队出队次数
     */
    private void implCompareTestTemplate(Queue<Integer> queue, int frequency){
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
