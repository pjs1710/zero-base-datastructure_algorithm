package dev.programmers.week_14;

import java.util.*;

/**
 * 당신에게 2차원 평면상의 좌표 x[i]와 y[i]가 주어진다.
 * 각 좌표에 찍혀있는 점을 서로 연결하는 데에는 두 좌표 사이의 '맨하탄 거리'만큼의 비용이 든다.
 * i번째 점과 j번째 점 사이의 맨하탄 거리는 아래와 같이 정의된다.
 * manhattan(i, j) = |x[i] - x[j]| + |y[i] - y[j]|
 * 이 때, 모든 점을 연결하는 데에 필요한 최소의 비용을 구하시오.
 *
 * 입력 :
 * x = {0, 0, 3, 3, 6}
 * y = {0, 3, 1, 4, 3}
 *
 * 결과 :
 * 14
 */

public class Num_19 {

    public static int solution(int[] x, int[] y) {
        int n = x.length;

        // Union-Find를 위한 부모 배열과 랭크 배열
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        // 모든 간선을 저장할 리스트 (비용, 점1, 점2)
        List<int[]> edges = new ArrayList<>();

        // 모든 점 쌍에 대해 맨하탄 거리 계산하여 간선 생성
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[j]);
                edges.add(new int[]{cost, i, j});
            }
        }

        // 간선을 비용 순으로 정렬
        edges.sort((a, b) -> Integer.compare(a[0], b[0]));

        int totalCost = 0;
        int edgesUsed = 0;

        // 크루스칼 알고리즘
        for (int[] edge : edges) {
            int cost = edge[0];
            int u = edge[1];
            int v = edge[2];

            // 두 점이 다른 집합에 속하는지 확인 (사이클 방지)
            if (find(parent, u) != find(parent, v)) {
                union(parent, rank, u, v);
                totalCost += cost;
                edgesUsed++;

                // 모든 점이 연결되면 종료 (n-1개의 간선)
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }

    public static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public static void main(String[] args) {

    }
}
