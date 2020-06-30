package com.demo.queue;

/**
 * 队列接口
 * @param <E>
 */
public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    E getFront();
    int getSize();
    boolean isEmpty();
}
