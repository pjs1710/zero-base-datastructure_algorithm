package dev.programmers.week_14;

import java.util.*;

/**
 * 산들이는 시험 공부를 효율적으로 하는 것을 좋아한다.
 * 이번 시험은 총 N개의 문제를 모두 공부하면 시험 준비를 마칠 수 있다.
 * 문제는 서로 연관이 깊은 문제들이 있으며, 이 경우 한 문제를 공부하고 나면 다른 문제는 보다 빠르게 공부할 수 있다.
 * 서로 연관이 깊은 문제는 relations[i] 배열에 {문제번호1, 문제번호2, 소요 시간(분)}의 형식으로 주어진다.
 * 이 때, 문제 번호는 0 ~ N-1으로 표현된다.
 * 연관된 다른 문제를 공부하지 않고 한 문제를 공부하는 데에는 30분의 시간이 소요된다.
 * N개의 문제를 모두 공부하는 데에 최소 몇 분이 걸리는지 구하시오.
 *
 * N = 6
 * relations = {{2, 3, 15}, {1, 5, 10}, {3, 4, 25}, {1, 2, 27}, {1, 4, 29}, {2, 5, 5}}
 *
 * 결과 :
 * 115
 */

public class Num_20 {

    public static int solution(int N, int[][] relations) {
        // Union-Find를 위한 부모 배열
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        // 간선을 비용 순으로 정렬
        Arrays.sort(relations, (a, b) -> Integer.compare(a[2], b[2]));

        int totalTime = 0;
        int connectedProblems = 0;

        // 크루스칼 알고리즘으로 최소 신장 트리 구성
        for (int[] relation : relations) {
            int problem1 = relation[0];
            int problem2 = relation[1];
            int time = relation[2];

            // 두 문제가 서로 다른 그룹에 속하는지 확인
            if (find(parent, problem1) != find(parent, problem2)) {
                union(parent, problem1, problem2);
                totalTime += time;
                connectedProblems++;

                // 모든 문제가 연결되면 종료
                if (connectedProblems == N - 1) {
                    break;
                }
            }
        }

        // 연결되지 않은 문제들은 개별적으로 30분씩 소요
        int isolatedProblems = N - 1 - connectedProblems; // 첫 번째 문제는 무조건 30분
        totalTime += 30 + (isolatedProblems * 30);

        return totalTime;
    }

    public static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);

        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    public static void main(String[] args) {

    }
}
