package dev.challenge.bfs;

import java.util.*;

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

        Node root = nodes.getFirst();

        for (int i = 0; i <= (N - 1) / 2; i++) { // 트리에 자식을 붙여주는 과정
            int left = i * 2 + 1;
            int right = i * 2 + 2;

            if (left < N) {
                nodes.get(i).left = nodes.get(left);
            }

            if (right < N) {
                nodes.get(i).right = nodes.get(right);
            }
        }
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            result.add(node.value); // 0

            if (node.left != null) {
                queue.add(node.left); // 1
            }

            if (node.right != null) {
                queue.add(node.right); // 2
            }
        }

        System.out.println(result);
    }
}
