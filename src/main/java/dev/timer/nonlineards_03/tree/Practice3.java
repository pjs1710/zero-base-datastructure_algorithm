package dev.timer.nonlineards_03.tree;

// 트리 구조 복습 / 구현

import java.util.LinkedList;
import java.util.Queue;

class Node2 {
    char data;
    Node2 left;
    Node2 right;
    Node2 parent;

    public Node2(char data, Node2 left, Node2 right, Node2 parent) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class BinaryTree3 {
    Node2 head;

    BinaryTree3(char[] arr) {
        Node2[] nodes = new Node2[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new Node2(arr[i], null, null, null);
        }

        for (int i = 0; i < arr.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < arr.length) {
                nodes[i].left = nodes[left];
                nodes[left].parent = nodes[i];
            }

            if (right < arr.length) {
                nodes[i].right = nodes[right];
                nodes[right].parent = nodes[i];
            }
        }
        this.head = nodes[0];
    }

    public Node2 searchNode(char data) {
        Queue<Node2> queue = new LinkedList<>();
        queue.add(this.head);

        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();
            if (cur.data == data) {
                return cur;
            }

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return null;
    }

    public Integer checkSize(char data) {
        Node2 node = this.searchNode(data);

        Queue<Node2> queue = new LinkedList<>();
        queue.add(node);
        int size = 0;

        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();

            if (cur.left != null) {
                queue.offer(cur.left);
                size++;
            }

            if (cur.right != null) {
                queue.offer(cur.right);
                size++;
            }
        }
        return size + 1;
    }
}

public class Practice3 {

    public static void main(String[] args) {
        // Test Code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) ('A' + i);
        }

        BinaryTree3 bt = new BinaryTree3(arr);

        // Root Node
        System.out.println("Root : " + bt.head.data);

        // B's Child Node
        Node2 B = bt.searchNode('B');
        if (B.left != null) {
            System.out.println("B -> left child : " + B.left.data);
        }
        if (B.right != null) {
            System.out.println("B -> right child : " + B.right.data);
        }

        // F's Parent Node
        Node2 F = bt.searchNode('F');
        System.out.println("F -> parent : " + F.parent.data);

        // Leaf Node
        System.out.print("Leaf Node : ");
        for (int i = 0; i < arr.length; i++) {
            Node2 cur = bt.searchNode((char) ('A' + i));

            if (cur.left == null && cur.right == null) { // leaf node
                System.out.print(cur.data + " ");
            }
        }
        System.out.println();

        // E's Depth
        Node2 E = bt.searchNode('E');
        Node2 cur = E;
        int cnt = 0;
        while (cur.parent != null) {
            cur = cur.parent;
            cnt++;
        }
        System.out.println("E Depth : " + cnt);

        // Level2 Node
        System.out.print("Level2 Node : ");
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt.searchNode((char) ('A' + i));
            cur = target;
            cnt = 0;

            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }

            if (cnt == 2) { // level2
                System.out.print(target.data + " ");
            }
        }
        System.out.println();

        // Height

        int maxCnt = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            Node2 target = bt.searchNode((char) ('A' + i));
            cur = target;
            cnt = 0;

            while (cur.parent != null) {
                cur = cur.parent;
                cnt++;
            }

            if (maxCnt < cnt) {
                maxCnt = cnt;
            }
        }
        System.out.println("Height : " + maxCnt);

        // B's Size
        int size = bt.checkSize('B');
        System.out.println("B Size = " + size);

    }
}
