package com.demo.binary_tree;

import com.demo.linked_list.LinkedListDemo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的遍历
 */
public class SimpleBinaryTreeDemo {

    private static class Node {

        int data;   //用来保存数据
        Node leftNode;  //左节点
        Node rightNode; //右节点

        Node(int data){
            this.data = data;
        }
    }

    /**
     * 使用LinkerList的数据生成一个简单的满二叉树
     * @param linkedList    记录一组数据的链表
     * @return  返回二叉树的头节点
     */
    public static Node createSimpleBinaryTree(LinkedList<Integer> linkedList){
        Node node = null;
        //判断链表是否符合要求
        if(linkedList == null || linkedList.isEmpty()){
            return null;
        }
        //将链表的头数据取出来
        Integer data = linkedList.removeFirst();
        //如果头数据不为空， 创建链表
        if(data != null){
            node = new Node(data);
            node.leftNode = createSimpleBinaryTree(linkedList);
            node.rightNode = createSimpleBinaryTree(linkedList);
        }
        return node;
    }

    /**
     * 将二叉树以前序遍历方式输出
     * @param node  传入头节点
     */
    public void preOrderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftNode);
        preOrderTraversal(node.rightNode);
    }

    /**
     * 中序遍历
     * @param node 头节点
     */
    public void inOrderTraversal(Node node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.leftNode);
        System.out.println(node.data);
        inOrderTraversal(node.rightNode);
    }

    /**
     * 后序遍历
     * @param node  头节点
     */
    public void postOrderTraversal(Node node){
        if (node == null){
            return;
        }
        inOrderTraversal(node.leftNode);
        inOrderTraversal(node.rightNode);
        System.out.println(node.data);
    }

    /**
     * 使用非递归（栈）方式完成前序遍历
     * @param node  头节点
     */
    public void preOrderTraversalWithStach(Node node){
        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.isEmpty()){
            while (node != null){
                System.out.println(node.data);
                stack.push(node);
                node = node.leftNode;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                node = node.rightNode;
            }
        }
    }

    /**
     * 广度优先遍历（层序遍历）
     * @param root  头节点
     */
    public void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.leftNode != null){
                queue.offer(node.leftNode);
            }
            if (node.rightNode != null){
                queue.offer(node.rightNode);
            }
        }
    }
}
