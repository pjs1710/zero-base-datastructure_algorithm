package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 5번 :
 *
 * N개의 국가를 연결하는 다양한 비행기편이 있다. 각 국가는 0부터 N - 1의 인덱스로 표현된다.
 * 각 비행기편은 flight[i] = {출발지 인덱스, 도착지 인덱스, 비용} 으로 주어진다고 한다.
 * 당신은 k번 이하로 비행기를 탑승하면서, a국가에서 b국가에 도착하기 위한 최소의 비용을 구하려고 한다.
 * 위 프로그램을 구현하시오. 단, k번 이하의 비행편으로 a국가에서 b국가로 도달할 수 없는 경우 -1을 출력하시오.
 *
 * 입력 :
 * N = 4
 * flight = {{0, 2, 1}, {1, 3, 20}, {1, 0, 8}, {2, 3, 1}, {0, 3, 3}}
 * a = 1
 * b = 3
 * k = 2
 *
 * 출력 :
 * 11
 */

public class Task5 {

    static class Node {
        int nation;
        int stop;
        int cost;

        public Node(int nation, int stop, int cost) {
            this.nation = nation;
            this.stop = stop;
            this.cost = cost;
        }
    }

    public static int solution(int N, int[][] flight, int a, int b, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] item : flight) {
            graph.computeIfAbsent(item[0],
                    x -> new ArrayList<>()).add(new int[]{item[1], item[2]});
        }

        int[][] dist = new int[N][k + 2];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[a][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));
        pq.offer(new int[]{0, a, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], node = cur[1], stops = cur[2];

            if (cost > dist[node][stops]) {
                continue;
            }

            if (stops > k) {
                continue;
            }

            if (!graph.containsKey(node)) {
                continue;
            }

            for (int[] next : graph.get(node)) {
                int nextNode = next[0], price = next[1];
                int nextCost = cost + price;
                int nextStops = stops + 1;

                if (nextStops <= k + 1 && nextCost < dist[nextNode][nextStops]) {
                    dist[nextNode][nextStops] = nextCost;
                    pq.offer(new int[]{nextCost, nextNode, nextStops});
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            answer = Math.min(answer, dist[b][i]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) throws IOException {

    }
}
