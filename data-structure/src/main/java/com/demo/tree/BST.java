package com.demo.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树(BinarySearchTree)
 * 每个节点的值都大于左子树且小于右子树
 * 不包含重复元素
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        private E e;
        private Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        this.root = null;
        size = 0;
    }

    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node curNode, E e){
        if (curNode == null){
            size++;
            return new Node(e);
        }
        if (e.compareTo(curNode.e) < 0){
            curNode.left = add(curNode.left,e);
        } else if (e.compareTo(curNode.e) > 0){
            curNode.right = add(curNode.right,e);
        }
        return curNode;
    }

    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node curNode,E e){
        if(curNode == null){
            return false;
        }
        if (e.equals(curNode.e)){
            return true;
        } else if(e.compareTo(curNode.e) < 0){
            return contains(curNode.left,e);
        } else {
            return contains(curNode.right,e);
        }
    }

    /**
     * 寻找最小值
     * @return
     */
    public E minimum(){
        if (isEmpty()){
            throw new IllegalArgumentException("BST is empty.");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 删除最小值
     * @return
     */
    public E removeMin(){
        E res = minimum();
        root = removeMin(root);
        return res;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            size--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 寻找最大值
     * @return
     */
    public E maximum(){
        if (isEmpty()){
            throw new IllegalArgumentException("BST is empty.");
        }
        return maximum(root).e;
    }


    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除最大值
     * @return
     */
    public E removeMax(){
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            size--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除某一元素，存在则删除，不存在不做操作
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * Hibbard deletion
     * @param node
     * @param e
     * @return
     */
    private Node remove (Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left,e);
            return node;
        } else if(e.compareTo(node.e) > 0){
            node.right = removeMin(node.right);
            return node;
        } else {
            if(node.left == null){
                Node nodeRight = node.right;
                node.right = null;
                size--;
                return nodeRight;
            }
            if(node.right == null){
                Node nodeLeft = node.left;
                node.left = null;
                size--;
                return nodeLeft;
            }
            //如果删除节点既有左子树又有右子树，
            //寻找该节点的后继（右子树最小值），
            //使用后继successor节点代替该节点。（也可使用前驱predecessor）
            Node successor = minimum(node.right);
            successor.left = node.left;
            successor.right = removeMin(node.right);
            node.left = node.right = null;
            return successor;
        }
    }


    /**
     * 前序遍历打印输出
     * @param node
     */
    private void preorderTraversal(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.e);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /**
     * 以非递归(Non-recursive)的方式前序遍历打印输出
     */
    private void preorderTraversalNR(){
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.print(node.e);
            if(node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
    }

    /**
     * 中序遍历打印输出
     * @param node
     */
    private void inorderTraversal(Node node){
        if (node == null){
            return;
        }
        inorderTraversal(node.left);
        System.out.print(node.e);
        inorderTraversal(node.right);
    }


    /**
     * 后序遍历打印输出
     * @param node
     */
    private void postorderTraversal(Node node){
        if (node == null){
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.e);
    }

    /**
     * 层序遍历（广度优先遍历）
     */
    private void levelOrder(){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(node.e);
            if (node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    /**
     * 通过数字决定遍历输出顺序
     * 1前序遍历2中序遍历3后序遍历，其他数字为层序遍历
     * @param choose
     */
    public void  output(int choose) {
        switch (choose){
            case 1:
                System.out.println("前序遍历结果：");
                preorderTraversal(root);
                System.out.println();
                System.out.println("非递归方式前序遍历结果：");
                preorderTraversalNR();
                System.out.println();
                break;
            case 2:
                System.out.println("中序遍历结果：");
                inorderTraversal(root);
                System.out.println();
                break;
            case 3:
                System.out.println("后序遍历结果：");
                postorderTraversal(root);
                System.out.println();
                break;
            default:
                System.out.println("层序遍历结果：");
                levelOrder();
                System.out.println();
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
