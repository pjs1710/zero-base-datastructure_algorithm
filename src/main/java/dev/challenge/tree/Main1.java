package dev.challenge.tree;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main1 {

    public static void main(String[] args) {
        Node root = new Node(5);

        root.left = new Node(4);
        root.right = new Node(10);

        root.left.left = new Node(15);
        root.left.right = new Node(1);

        root.right.left = new Node(20);
        root.right.right = new Node(8);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(9);

        root.right.right.right = new Node(12);

        System.out.println("루트 노드 : " + root.value);
        System.out.println("루트 왼쪽 : " + root.left.value);
        System.out.println("루트 오른쪽 : " + root.right.value);
        System.out.println("4의 오른쪽 자식 : " + root.left.right.value);
    }
}
