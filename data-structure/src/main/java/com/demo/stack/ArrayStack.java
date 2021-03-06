package com.demo.stack;

import com.demo.array.DynamicArray;

/**
 * 通过动态数组实现栈
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

    private DynamicArray<E> array;

    public ArrayStack(int capacity){
        array = new DynamicArray<>(capacity);
    }
    public ArrayStack(){
        this(10);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append("[");
        for (int i = 0; i < getSize(); i++) {
            res.append(array.get(i));
            if(i != getSize() - 1){
                res.append(',');
            }
        }
        res.append("] Top");
        return res.toString();
    }
}
