package dev.timer.nonlineards_03.binary_search_tree;

// 비선형 자료구조 - 이진 탐색 트리

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    public Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node head;

    BinarySearchTree(int key) {
        this.head = new Node(key, null, null);
    }

    public void addNode(int key) {
        if (this.head == null) {
            this.head = new Node(key, null, null);
        } else {
            Node cur = this.head;

            while (true) {
                Node prev = cur;

                if (key < cur.key) {
                    cur = cur.left;
                    if (cur == null) {
                        prev.left = new Node(key, null, null);
                        break;
                    }
                } else {
                    cur = cur.right;
                    if (cur == null) {
                        prev.right = new Node(key, null, null);
                        break;
                    }
                }
            }
        }
    }

    public void removeNode(int key) {
        Node parent = null; // 부모 노드
        Node successor = null; // 왼쪽 서브 트리에서 가장 큰 노드 or 오른쪽 서브 트리에서 가장 작은 노드
        Node predecessor = null; // successor의 부모 노드
        Node child = null; // successor의 자식 노드가 있는지 없는지

        Node cur = this.head;
        while (cur != null) {
            if (key == cur.key) { // 삭제할 데이터 찾았으면 cur에는 삭제할 node가 들어가있음
                break;
            }

            parent = cur; // 삭제하려는 노드의 부모 노드를 parent가 갖고 있음
            if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (cur == null) { // 삭제하려는 노드가 트리에 없는 경우
            System.out.println("Key에 해당하는 노드가 없습니다.");
            return;
        }

        if (cur.left == null && cur.right == null) { // Leaf 노드인 경우
            if (parent == null) { // 노드가 1개인 경우니까
                this.head = null; // head를 null로만 바꾸면 됨
            } else {
                if (parent.left == cur) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (cur.left != null && cur.right == null || cur.left == null && cur.right != null) { // 자식 노드가 하나인 경우
            if (cur.left != null) {
                child = cur.left;
            } else {
                child = cur.right;
            }

            if (parent == null) { // root 노드와 root 노드의 자식 노드가 있을 때, root 노드를 삭제하려고 할 때는 root 노드의 부모 노드는 null이므로 root 노드를 삭제할 경우
                this.head = child; // 자식 노드를 root 노드로
            } else {
                if (parent.left == cur) { // 부모 노드의 왼쪽 자식 노드가 삭제할 노드라면
                    parent.left = child; // 삭제할 왼쪽 자식 노드의 왼쪽 자식 노드를 부모 노드의 왼쪽 자식 노드로
                } else {
                    parent.right = child;
                }
            }
        } else { // 자식 노드가 둘인 경우
            predecessor = cur; // successor의 부모 노드
            successor = cur.left; // 왼쪽 서브 트리에서 가장 큰 노드로 바꿀 예정

            while (successor.right != null) { // 가장 큰 노드를 찾기 위한 반복문
                predecessor = successor;
                successor = successor.right;
            }

            // ex) 10 5 8 6 이라고 하자, 그러면 루트 노드에서 왼쪽 서브트리에서 가장 큰 값은 8이고 해당 값을 위로 올려야하니까 8을 루트 노드로 올리고
            predecessor.right = successor.left; // 8의 왼쪽 노드를 8의 부모 노드의 오른쪽으로 붙이기
            successor.left = cur.left; // 8의 left : 6은, 10(cur)의 left, 그렇게 되면 8 6 5
            successor.right = cur.right;

            if (parent == null) { // root 노드 이면서 자식 노드가 2개인 경우
                this.head = successor;
            } else {
                if (parent.left == cur) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
            }
        }
    }

    public void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.key + " ");

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
        // 노드 삽입
        BinarySearchTree bst = new BinarySearchTree(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(27);
        bst.addNode(40);
        bst.levelOrder(bst.head);

        // 노드 삭제
        bst.removeNode(40);
        bst.levelOrder(bst.head);
        bst.removeNode(25);
        bst.levelOrder(bst.head);
        bst.removeNode(20);
        bst.levelOrder(bst.head);

    }
}
