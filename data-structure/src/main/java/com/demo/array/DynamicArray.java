package com.demo.array;

/**
 * 动态数组的实现
 *
 * @param <E>
 */
public class DynamicArray<E> {

    private int size;
    private E[] data;

    /**
     * 初始化容量大小，若未指定，默认容量大小为10
     */
    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int getCapacity(){
        return data.length;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, E e) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Add failed. Index is illegal.");
        }
        if (size == data.length){
            resize(data.length * 2);
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }


    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Remove failed.Index is illegal");
        }
        E ret = data[index];
        if(size == data.length / 4 && data.length / 2 > 0){
            resize(data.length / 2);
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size] = null;
        size--;
        return ret;
    }

    public E removeElement(E e){
        int index = find(e);
        if (index == -1){
            throw new RuntimeException("No remove elements found.");
        }
        return remove(index);
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void set(int index,E e){
        data[index] = e;
    }

    public int find(E e){
        int ret = -1;
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])){
                ret = i;
            }
        }
        return ret;
    }

    public boolean contains(E e){
        return find(e) != -1;
    }

    public E get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Remove failed.Index is illegal");
        }
        return data[index];
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i != size - 1){
                stringBuilder.append(',');
            }
        }
        return stringBuilder.toString();
    }

}
