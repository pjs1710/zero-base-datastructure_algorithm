package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 3번 :
 *
 * 한 학생은 초기에 1번 지점의 위치에 서 있으며, N번 지점으로 이동하고자 한다.
 * 이때 시작 지점인 1번 지점에서 출발하여 도착 지점인 N번 지점에 최대한 빠르게 도착하는 것이 목표다.
 * 임의의 두 노드(지점) 사이에는 통로가 존재할 수 있는데, 각 통로마다 1이상 10이하의 값을 가지는 통로의 길이 정보가 함께 주어진다.
 * 예를 들어 통로의 길이가 5인 경우, 해당 통로를 이용하여 이동하는 경우 5만큼의 거리를 이동해야 하는 것으로 이해할 수 있다. 두 개의 노드를 잇는 통로는 여러 개 일 수 있다.
 * 총 노드의 개수 N은 최대 8000의 값을 가지며, 통로의 개수 M은 최대 100,000의 값을 가진다.
 * 또한 통로는 양방향 통로라서 A와 B를 연결하는 통로가 존재한다면 A에서 B로도 갈 수 있고, B에서 A로도 갈 수 있다.
 *
 * 이때, 항상 3개의 거점을 거쳐야 한다. 주어지는 3개의 거점의 번호는 항상 1번가 N번에 해당하지 않는다.
 * 또한 3개의 거점 번호는 항상 서로 다르다.
 * 구체적으로 학생은 3개의 거점을 최소 1번씩 방문하는 조건을 만족하며 1번 노드에서 N번 노드까지 최단 경로로 이동해야 한다.
 * 결과적으로 1번 노드에서 N번 노드로 이동하기 위한 최단 거리를 계산하는 프로그램을 작성하여라.
 * 만약 1번 노드에서 3개의 거점을 거쳐서 N번 노드에 도달이 불가능한 경우 -1을 반환하여라.
 *
 * 입력 조건 :
 * 가장 먼저 노드의 개수 N이 주어진다. N의 값은 5이상 8000 이하의 자연수다.
 * 이어서 통로의 개수 M이 주어진다. M의 값은 최대 100,000 이하의 자연수다. 통로는 양방향 통로를 의미한다.
 * 따라서, A와 B가 연결되어 있다면 A에서 B로도 갈 수 있으며 B에서 A로도 갈 수 있다.
 * 이어서 각 통로에 대한 정보가 담긴 2차원 배열 edges가 주어진다. 구체적으로 M X 3 형태의 배열로 주어지는데, 각 통로에 대한 정보는 A, B, K로 구성된다.
 * 이는 A와 B가 연결되어 있다는 의미이며, K는 A와 B를 연결하는 통로의 길이를 의미한다.
 * A와 B는 서로 다른 노드이며, 통로의 길이는 1이상 10이하의 자연수로 주어진다.
 * 이어서 거점 노드의 정보가 담긴 1차원 배열 points가 주어진다. 구체적으로 3개의 원소를 갖는 1차원 배열로 [X, Y, Z] 형태를 가진다.
 * 세 개의 각 원소의 값은 1초과 N미만의 자연수로, 서로 다른 값을 가진다.
 *
 * 출력 조건 :
 * 1번에서 출발하여 주어진 3개의 거점을 한 번씩은 방문하고 N번 노드에 도착하기 위한 최단 거리를 자연수 형태로 반환한다.
 * 만약 1번 노드에서 3개의 거점을 거쳐 N번 노드에 도달이 불가능한 경우 -1을 반환한다.
 */

public class Task3 {

    static final int INF = 987654321;

    public static int solution(int N, int M, int[][] edges, int[] points) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int[][] dist = new int[4][N + 1];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(dist[i], INF);
        }

        int[] starts = new int[]{1, points[0], points[1], points[2]};
        for (int i = 0; i < 4; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            dist[i][starts[i]] = 0;
            pq.offer(new int[]{starts[i], 0});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int now = cur[0];
                int cost = cur[1];
                if (cost > dist[i][now]) {
                    continue;
                }
                for (int[] next : graph.get(now)) {
                    int to = next[0];
                    int w = next[1];
                    if (dist[i][to] > cost + w) {
                        dist[i][to] = cost + w;
                        pq.offer(new int[]{to, dist[i][to]});
                    }
                }
            }
        }

        int min = INF;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int p1 = points[i];
                    int p2 = points[j];
                    int p3 = points[k];

                    int d1 = dist[0][p1];
                    int d2 = dist[i + 1][p2];
                    int d3 = dist[j + 1][p3];
                    int d4 = dist[k + 1][N];

                    if (d1 == INF || d2 == INF ||
                            d3 == INF || d4 == INF) {
                        continue;
                    }

                    min = Math.min(min, d1 + d2 + d3 + d4);
                }
            }
        }

        return min == INF ? -1 : min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] edges = new int[M][3];
        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(data[0]);
            edges[i][1] = Integer.parseInt(data[1]);
            edges[i][2] = Integer.parseInt(data[2]);
        }

        int[] points = new int[3];
        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < 3; i++) {
            points[i] = Integer.parseInt(data1[i]);
        }

        System.out.println(solution(N, M, edges, points));
    }
}
