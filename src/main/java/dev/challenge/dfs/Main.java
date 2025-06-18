package dev.challenge.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 전위 순회 (PreOrder)
 */

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

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i));
        }

        Node root = nodes.get(0);

        for (int i = 0; i <= (N - 1) / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < N) {
                nodes.get(i).left = nodes.get(left);
            }

            if (right < N) {
                nodes.get(i).right = nodes.get(right);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Node> stack = new ArrayList<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.getLast();
            stack.removeLast();
            result.add(node.value); // visit

            if (node.right != null) { // right
                stack.add(node.right);
            }

            if (node.left != null) { // left
                stack.add(node.left);
            }
        }
        System.out.println(result);
    }
}
