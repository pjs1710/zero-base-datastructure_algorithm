package dev.challenge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LevelOrder {

    static final int UND = -1; // 초기화 되지 않은 값 : -1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>(1); // 인덱스 번호를 0번 or 1번 선택해야하는데, 문제에서는 1번으로 받으므로 해당 번호를 사용할 수 있도록 크기 지정
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        /**
         * 엣지의 개수가 작기 때문에 인접 리스트로 구현!
         */
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }
        System.out.println(graph);

        List<Integer> visited = new ArrayList<>(Collections.nCopies(N + 1, UND));
        Queue<Integer> queue = new LinkedList<>();

        visited.set(X, 0); // 시작 시 시작점의 방문을 0으로 초기화 하고 이를 큐에 넣어서 시작
        queue.add(X);

        List<Integer> result = new ArrayList<>();

        // BFS 로직
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int nextNode : graph.get(current)) {
                if (visited.get(nextNode) == UND) {
                    visited.set(nextNode, visited.get(current) + 1);
                    queue.add(nextNode);
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            if (visited.get(i) == K) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int value : result) {
                System.out.println(value);
            }
        }
    }
}
