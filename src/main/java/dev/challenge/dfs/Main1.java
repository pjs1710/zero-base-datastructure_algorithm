package dev.challenge.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 재귀 함수 기반 PreOrder
 */

class Node1 {
    int value;
    Node1 left;
    Node1 right;

    public Node1(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Node1> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new Node1(i));
        }

        Node1 root = nodes.get(0);

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
        preOrder(root, result);

        System.out.println(result);
    }

    public static void preOrder(Node1 node, List<Integer> result) {
        if (node != null) {
            result.add(node.value);
            preOrder(node.left, result);
            preOrder(node.right, result);
        }
    }
}