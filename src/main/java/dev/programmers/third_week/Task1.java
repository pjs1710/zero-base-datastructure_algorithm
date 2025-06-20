package dev.programmers.third_week;

/**
 * 7주차 문제 1번 :
 *
 * 인터넷 방송인 짐벌이는 `윷놀이 최강자전`에 참가하여 경기를 치르게 되었다. 짐벌이는 다양한 윷놀이판에서 도착지에 도착하는 가장 적은 턴 수를 알아내려고 한다.
 * 기본적으로 윷놀이는 4개의 윷을 던져서 앞면이 나온 개수에 따라서 아래와 같이 말을 진행시킨다.
 * - 0개(모) : 5칸 이동한 후, 한 번 더 던진다.
 * - 1개(도) : 1칸 이동한다.
 * - 2개(개) : 2칸 이동한다.
 * - 3개(걸) : 3칸 이동한다.
 * - 4개(윷) : 4칸 이동한 후, 한 번 더 던진다.
 * - 단, 모나 윷이 한 턴에 여러 번 나오더라도 총 던지는 횟수는 최대 2회로 제한된다.
 *
 * 윷놀이판은 N개의 노드로 이루어진다. 각 노드 간의 연결은 edges[i] = 이전 노드, 다음 노드로 주어지며, 1번 노드가 항상 출발점, N번 노드가 항상 도착점이다.
 * 이 연결은 단방향 연결로, 이전 노드에서 다음 노드로는 이동할 수 있으나 반대로는 이동할 수 없다.
 *
 * N = 13
 * edges = {{1,2},{1,3},{2,4},{2,5},{3,6},{4,7},{5,7},{6,5},{6,8},{7,9},{8,10},{9,10},{10,11},{11,12},{12,13}}
 *
 * result = 1
 *
 * 이 때, 최소의 턴으로 출발점에서 도착점까지 이동하는 턴 수를 구하시오
 *
 * 단, 모/윷이 나와 두 번 던진 것은 1턴으로 치며, 여러 노드로 연결된 경우 마음대로 선택해서 이동할 수 있다.
 */

import java.io.*;
import java.util.*;

public class Task1 {

    public static int solution(int N, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[N + 1]; // 턴 수 기록
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[1] = 0;
        queue.offer(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int nowTurn = visited[cur];

            Set<Integer> nextNodes = getNextNodes(graph, cur, 10);
            for (int next : nextNodes) {
                if (visited[next] > nowTurn + 1) {
                    visited[next] = nowTurn + 1;
                    queue.offer(next);
                }
            }
        }

        return visited[N];
    }

    public static Set<Integer> getNextNodes(List<List<Integer>> graph, int start, int maxDepth) {
        Set<Integer> reachable = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int depth = curr[1];

            if (depth == 0) {
            } else {
                reachable.add(node);
            }

            if (depth >= maxDepth) {
                continue;
            }

            for (int next : graph.get(node)) {
                queue.offer(new int[]{next, depth + 1});
            }
        }

        return reachable;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] edges = new int[K][2];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, edges));
    }
}
