package dev.timer.nonlineards_03.graph;

// 인접 리스트 그래프의 DFS, BFS

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGraphList2 extends MyGraphList {

    public MyGraphList2(int size) {
        super(size);
    }

    public void dfs(int id) {
        boolean[] visited = new boolean[this.elemCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while (!stack.isEmpty()) {
            int curId = stack.pop();
            System.out.print(this.vertices[curId] + " ");

            Node cur = this.adjList[curId];
            while (cur != null) {
                if (visited[cur.id] == false) {
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }

    public void bfs(int id) {
        boolean[] visited = new boolean[this.elemCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(id);
        visited[id] = true;

        while (!queue.isEmpty()) {
            int curId = queue.poll();
            System.out.print(this.vertices[curId] + " ");

            Node cur = this.adjList[curId];
            while (cur != null) {
                if (visited[cur.id] == false) {
                    queue.offer(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }
}

public class Practice2 {

    public static void main(String[] args) {
        // Test Code
        MyGraphList2 graph = new MyGraphList2(7);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        graph.dfs(0);
        graph.bfs(0);
    }
}
