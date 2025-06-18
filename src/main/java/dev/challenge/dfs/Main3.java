package dev.challenge.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 재귀 함수 기반 PreOrder
 */

class Node3 {
    int value;
    Node3 left;
    Node3 right;

    public Node3(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Node3> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new Node3(i));
        }

        Node3 root = nodes.get(0);

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
        postOrder(root, result);

        System.out.println(result);
    }

    public static void postOrder(Node3 node, List<Integer> result) {
        if (node != null) {
            postOrder(node.left, result);
            postOrder(node.right, result);
            result.add(node.value);
        }
    }
}