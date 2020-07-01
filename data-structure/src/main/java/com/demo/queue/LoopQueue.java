package com.demo.queue;

/**
 * 数组实现的循环队列
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tatil;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public void enqueue(E e) {
        if ((tatil + 1) % data.length == front) {
            resize(2 * getCapacity());
        }
        data[tatil] = e;
        tatil = (tatil + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E res = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }

        return res;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i = 0; i < size;i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tatil = size;
    }

    @Override
    public E getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue: ");
        stringBuilder.append("Front [");
        int flag = front;
        while (flag != tatil){
            stringBuilder.append(data[flag]);
            flag = (flag + 1) % data.length;
            if (flag != tatil){
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("] Tatil");
        return stringBuilder.toString();
    }
}
