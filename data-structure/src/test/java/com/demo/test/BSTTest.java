package com.demo.test;

import com.demo.tree.BST;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BSTTest {

    @Test
    public void orderTraversal(){
        int[] data = {5,3,6,8,4,2};
        BST<Integer> bst = new BST<>();
        for (int datum : data) {
            bst.add(datum);
        }
        bst.output(1);
        bst.output(2);
        bst.output(3);
        bst.output(4);
    }

    @Test
    public void removeMaxAndMin(){
        removeMaxAndMin(0);
        removeMaxAndMin(1);
    }

    /**
     * 删除最大最小值测试，若为0是最小值，1为最大值
     * @param choose
     */
    private void removeMaxAndMin(int choose){
        Random random = new Random();
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(1000));
        }
        List<Integer> list = new ArrayList<>();
        while (!bst.isEmpty()){
            switch (choose){
                case 0:
                    list.add(bst.removeMin());
                    break;
                case 1:
                    list.add(bst.removeMax());
            }

        }
        System.out.println(list);
        if(choose == 0){
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i - 1) > list.get(i)){
                    throw new IllegalArgumentException("Error.");
                }
            }
            System.out.println("remove min is successful.");
        } else {
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i - 1) < list.get(i)){
                    throw new IllegalArgumentException("Error.");
                }
            }
            System.out.println("remove max is successful.");
        }
    }
    
}
