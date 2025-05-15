package dev.timer.nonlineards_03.graph.problem_solve;

// Center Node 찾기
// Undirected 그래프에서 center node를 출력하세요
// Center node는 다른 모든 노드와 연결된 노드를 의미
// 다른 노드와 연결된 노드는 하나라고 가정

// 간선의 총 개수는 노드의 개수 - 1
// 모든 노드는 연결되어 있다.

// 입력 그래프 : {{1, 2}, {2, 3}, {4, 2}}
// 출력 : 2

// 입력 그래프 : {{1, 2}, {5, 1}, {1, 3}, {1, 4}}
// 출력 : 1

class MyGraphMatrix {
    char[] vertices;
    int[][] adjMat;
    int elemCnt;

    public MyGraphMatrix() {

    }

    public MyGraphMatrix(int size) {
        this.vertices = new char[size];
        this.adjMat = new int[size][size];
        this.elemCnt = 0;
    }

    public boolean isFull() {
        return this.elemCnt == this.vertices.length;
    }

    public void addVertex(char data) {
        if (isFull()) {
            System.out.println("Graph is Full!");
            return;
        }

        this.vertices[this.elemCnt++] = data;
    }

    public void addEdge(int x, int y) { // 무방향 그래프 인접 노드 엣지 연결
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    }

}

public class Practice1 {

    public static int solution(int[][] e) {
        MyGraphMatrix graph = new MyGraphMatrix(e.length + 1);

        for (int i = 0; i < e.length; i++) {
            graph.addEdge(e[i][0] - 1, e[i][1] - 1);
        }

        int[] edgeCnt = new int[e.length + 1];
        for (int i = 0; i < graph.adjMat.length; i++) {
            for (int j = 0; j < graph.adjMat[i].length; j++) {
                if (graph.adjMat[i][j] == 1) {
                    edgeCnt[i] += 1;
                }
            }
        }

        int maxCnt = -1;
        int maxIdx = -1;
        for (int i = 0; i < edgeCnt.length; i++) {
            if (maxCnt < edgeCnt[i]) {
                maxCnt = edgeCnt[i];
                maxIdx = i;
            }
        }

        return maxIdx + 1;
    }

    public static int solution2(int[][] e) {
        return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
    }

    public static void main(String[] args) {
        // Test Code
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
        System.out.println();

        edges = new int[][]{{1, 2}, {5, 1}, {1, 3}, {1, 4}};
        System.out.println(solution(edges));
        System.out.println(solution2(edges));
    }
}
