package dev.programmers.week_14;

import java.util.*;

/**
 * N개의 국가를 연결하는 다양한 비행기편이 있다. 각 국가는 0부터 N-1 인덱스로 표현된다.
 * 각 비행기편은 flight[i] = {출발지 인덱스, 도착지 인덱스, 비용} 으로 주어진다고 한다.
 * 당신은 k번 이하로 비행기를 탑승하면서, a국가에서 b국가에 도착하기 위한 최소의 비용을 구하려고 한다.
 * 위 프로그램을 구현하시오. 단, k번 이하의 비행편으로 a국가에서 b국가로 도달할 수 없는 경우 -1을 출력.
 *
 * 입력 :
 * N = 4
 * flight = {{0, 2, 1}, {1, 3, 20}, {1, 0, 8}, {2, 3, 1}, {0, 3, 3}}
 * a = 1
 * b = 3
 * k = 2
 *
 * 결과 :
 * 11
 */

public class Num_17 {

    public static int solution(int N, int[][] flight, int a, int b, int k) {
        // 그래프 구성 (인접 리스트)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] f : flight) {
            graph.get(f[0]).add(new int[]{f[1], f[2]}); // {도착지, 비용}
        }

        // 우선순위 큐: {비용, 현재노드, 사용한경유지수}
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        pq.offer(new int[]{0, a, 0}); // 시작: 비용0, 출발지a, 경유지0개

        // 방문 체크: [노드][경유지수] = 최소비용
        int[][] visited = new int[N][k + 2];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int node = current[1];
            int stops = current[2];

            // 목적지에 도달한 경우
            if (node == b) {
                return cost;
            }

            // 경유지를 너무 많이 사용한 경우 스킵
            if (stops > k) {
                continue;
            }

            // 이미 더 적은 비용으로 방문한 경우 스킵
            if (cost > visited[node][stops]) {
                continue;
            }

            visited[node][stops] = cost;

            // 인접한 모든 노드 탐색
            for (int[] edge : graph.get(node)) {
                int nextNode = edge[0];
                int nextCost = cost + edge[1];
                int nextStops = stops + 1;

                // 경유지 제한을 넘지 않고, 더 적은 비용인 경우만 추가
                if (nextStops <= k + 1 && nextCost < visited[nextNode][nextStops]) {
                    pq.offer(new int[]{nextCost, nextNode, nextStops});
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }

    public static void main(String[] args) {

    }
}
