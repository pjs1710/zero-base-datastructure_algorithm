package dev.programmers.week_14;

import java.util.*;

/**
 * 당신은 네비게이션 시스템을 개발하기 위해 최단 거리를 계산하는 프로그램을 만들고 테스트 하려고 한다.
 * 최단 거리를 계산하고자 하는 공간에는 총 N개의 장소가 존재한다.
 * a번째 장소에서 b번째 장소로 이동하는 데에 걸리는 시간 time이 edge[i] = {a, b, time}로 주어진다고 하자.
 * 당신은 0번째 장소에 있다고 할 때, 최단 거리로 도달하는 데에 가장 오래 걸리는 장소의 인덱스를 출력하시오.
 * 단, 정답이 여럿일 경우 작은 인덱스를 반환하시오.
 *
 * 입력 :
 * N = 5
 * edge = {{0, 1, 5}, {0, 2, 7}, {1, 3, 10}, {3, 4, 8}, {2, 4, 9}, {4, 2, 1}}
 *
 * 결과 :
 * 4
 */

public class Num_24 {

    public static int solution(int N, int[][] edge) {
        // 그래프 구성 (인접 리스트)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(new int[]{e[1], e[2]}); // {도착지, 시간}
        }

        // 다익스트라 알고리즘
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // 시작점은 0

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0}); // {거리, 노드}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int currentNode = current[1];

            // 이미 더 짧은 경로로 방문한 경우 스킵
            if (currentDist > dist[currentNode]) {
                continue;
            }

            // 인접한 모든 노드 탐색
            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int nextDist = currentDist + neighbor[1];

                // 더 짧은 경로를 찾은 경우 업데이트
                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.offer(new int[]{nextDist, nextNode});
                }
            }
        }

        // 가장 긴 최단 거리를 가진 노드 찾기
        int maxDist = 0;
        int farthestNode = 0;

        for (int i = 0; i < N; i++) {
            if (dist[i] != Integer.MAX_VALUE && dist[i] > maxDist) {
                maxDist = dist[i];
                farthestNode = i;
            }
        }

        return farthestNode;
    }

    public static void main(String[] args) {

    }
}
