package com.demo.queue;

import com.demo.array.DynamicArray;

/**
 * 通过动态数组实现队列
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private DynamicArray<E> array;

    public ArrayQueue(){
        this(10);
    }

    public ArrayQueue(int capatiye){
        array = new DynamicArray<>(capatiye);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("Front [");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if(i != getSize() - 1){
                res.append(',');
            }
        }
        res.append("] Tail");
        return res.toString();
    }
}
