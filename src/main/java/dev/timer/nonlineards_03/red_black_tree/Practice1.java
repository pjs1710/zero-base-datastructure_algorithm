package dev.timer.nonlineards_03.red_black_tree;

// 비선형 자료구조 - 이진 탐색 트리_3
// Red-Black 트리 - 삽입

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    int color;
    Node left;
    Node right;
    Node parent;

    public Node(int key, int color, Node left, Node right, Node parent) {
        this.key = key;
        this.color = color;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

class RedBlackTree {

    final int BLACK = 0;
    final int RED = 1;

    Node head;

    public void insert(int key) {
        Node checkNode = null;
        if (this.head == null) {
            this.head = new Node(key, BLACK, null, null, null);
        } else {
            Node cur = this.head;

            while (true) {
                Node prev = cur;

                if (key < cur.key) {
                    cur = cur.left;
                    if (cur == null) {
                        prev.left = new Node(key, RED, null, null, prev);
                        checkNode = prev.left;
                        break;
                    }
                } else {
                    cur = cur.right;
                    if (cur == null) {
                        prev.right = new Node(key, RED, null, null, prev);
                        checkNode = prev.right;
                        break;
                    }
                }
            }
            reBalance(checkNode);
        }
    }

    public void reBalance(Node node) {
        while (node.parent != null && node.parent.color == RED) { // double red case
            Node sibling = null;

            if (node.parent == node.parent.parent.left) {
                sibling = node.parent.parent.right;
            } else {
                sibling = node.parent.parent.left;
            }

            if (sibling != null && sibling.color == RED) { // ReColoring
                node.parent.color = BLACK;
                sibling.color = BLACK;
                node.parent.parent.color = RED;

                if (node.parent.parent == this.head) {
                    node.parent.parent.color = BLACK;
                    break;
                } else {
                    node = node.parent.parent;
                    continue;
                }
            } else { // ReStructuring
                if (node.parent == node.parent.parent.left) {
                    if (node == node.parent.right) {
                        node = node.parent;
                        // 회전
                        leftRotate(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    rightRotate(node.parent.parent);
                } else if (node.parent == node.parent.parent.right) {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    node.parent.color = BLACK;
                    node.parent.parent.color = RED;
                    leftRotate(node.parent.parent);
                }
                break;
            }
        }
    }

    public void leftRotate(Node node) {
        if (node.parent == null) {
            Node rNode = this.head.right;
            this.head.right = rNode.left;
            rNode.left.parent = this.head;
            this.head.parent = rNode;
            rNode.left = this.head;
            rNode.parent = null;
            this.head = rNode;
        } else {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;

            if (node.right.left != null) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        }
    }

    public void rightRotate(Node node) {
        if (node.parent == null) {
            Node lNode = this.head.left;
            this.head.left = lNode.right;
            lNode.right.parent = this.head;
            this.head.parent = lNode;
            lNode.right = this.head;
            lNode.parent = null;
            this.head = lNode;
        } else {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }


            node.left.parent = node.parent;
            node.parent = node.left;

            if (node.left.right != null) {
                node.left.right.parent = node;
            }

            node.left = node.left.right;
            node.parent.right = node;
        }
    }

    public void levelOrder(Node node) {
        char[] color = {'B', 'R'};

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print("[" + color[cur.color] + "]" + cur.key + " ");

            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
}

public class Practice1 {

    public static void main(String[] args) {
        // Test Code
        RedBlackTree rbTree = new RedBlackTree();
        rbTree.insert(20);
        rbTree.insert(10);
        rbTree.insert(30);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(25);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(5);
        rbTree.insert(7);
        rbTree.levelOrder(rbTree.head);
        rbTree.insert(19);
        rbTree.levelOrder(rbTree.head);

    }
}
