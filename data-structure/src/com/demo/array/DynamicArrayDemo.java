package com.demo.array;

/**
 * 动态数组
 */
public class DynamicArrayDemo {

    private int[] array;
    private int size;

    public DynamicArrayDemo(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public DynamicArrayDemo() {
        this(10);
    }

    /**
     * 插入元素
     *
     * @param element 插入的元素
     * @param index   插入的下标
     */
    public void insert(int element, int index) {
        //判断下标范围
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("超出数组范围");
        }
        //动态扩容
        if (size == array.length) {
            resize(2 * array.length);
        }
        //从右向左腾出位置
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        //插入元素
        array[index] = element;
        size++;
    }

    /**
     * 删除元素并将元素返回
     *
     * @param index 删除的下标
     */
    public int delete(int index) {
        if (index > 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("超出数组范围");
        }
        int res = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        if (size == array.length / 4) {
            resize(array.length / 2);
        }
        return res;
    }

    /**
     * 重新制定数组容量
     */
    private void resize(int capacity) {
        int[] newArr = new int[capacity];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

}
