package com.demo.queue;

// TODO: 2020/6/30  未实现
/**
 * 循环队列
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tatil;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity];
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if ((tatil + 1) % data.length == front) {
            resize(2 * data.length - 1);
        }
        data[tatil] = e;
        tatil = (tatil + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == (data.length - 1) / 4 && (data.length - 1) / 2 > 0){
            resize((data.length - 1) / 2 + 1);
        }

        return res;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

    }

    @Override
    public E getFront() {
        return null;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tatil;
    }
}
