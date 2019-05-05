package Foundation;

import java.util.HashMap;

public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node{
        K key;
        V value;
        Node left, right;
        int N;
        boolean color;

        Node(K k, V v, int N, boolean color){
            this.key = k;
            this.value = v;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if(x==null){return false;}
        return x.color == RED;
    }

    /*
    将h节点左旋，原h的右节点x放在h的位置，h变为x的左节点
     */
    Node rotateLeft(Node h){
        Node x = h.right;
        x.color = h.color;
        h.right = x.left;//原x.left是介于h和x之间的数值，现在h.right负责存储
        x.left = h;
        x.N = h.N;
        h.N = 1+size(h.left)+size(h.right);
        return x;
    }

    /*
    将h节点右旋，其实就是把左旋代码里所有right和left对换
     */
    Node rotateRight(Node h){
        Node x = h.left;
        x.color = h.color;
        h.left = x.right;
        x.right = h;
        x.N = h.N;
        h.N = 1+size(h.right)+size(h.left);

        return x;
    }

    private int size(Node n){
        if(n==null){return 0;}
        return 1+size(n.left)+size(n.right);
    }

    public void put(K key, V value){
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, K key, V value){
        if(h==null){
            return new Node(h.key, h.value, 1, RED);//这句是将新Node插入，注意新的Node一定是RED的
        }
        int cmp = key.compareTo(h.key);
        if(cmp>0){
            h.right = put(h.right, key, value);
        }
        else if(cmp<0){
            h.left = put(h.left,key,value);
        }
        else h.value = value;

        //下面这三行if就是实现了左右旋转和双红键消除，把这三行删了就完全是标准二叉树的代码了
        if(isRed(h.right)&&!isRed(h.left)){h = rotateLeft(h);}//左旋
        if(isRed(h.left)&&isRed(h.left.left)){h = rotateRight(h);}//右旋
        if (isRed(h.left)&&isRed(h.right)){flipColors(h);}

        h.N = size(h.left)+size(h.right)+1;
        return h;
    }

    private void flipColors(Node h){
        h.color = RED;
        h.left.color=BLACK;
        h.right.color=BLACK;
    }

    public static void main(String[] args) {

    }
}
