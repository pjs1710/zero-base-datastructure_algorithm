package dev.challenge.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 재귀 함수 기반 PreOrder
 */

class Node2 {
    int value;
    Node3 left;
    Node3 right;

    public Node2(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main2 {

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
        inOrder(root, result);

        System.out.println(result);
    }

    public static void inOrder(Node3 node, List<Integer> result) {
        if (node != null) {
            inOrder(node.left, result);
            result.add(node.value);
            inOrder(node.right, result);
        }
    }
}