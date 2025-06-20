package dev.challenge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Blob {

    static final int UND = -1;
    static final int ROAD = 0;
    static final int TRASH = 1;
    static final int _n = 0;
    static final int _m = 1;
    static final List<List<Integer>> dirs = Arrays.asList(
            Arrays.asList(-1, 0),
            Arrays.asList(1, 0),
            Arrays.asList(0, 1),
            Arrays.asList(0, -1)
    );

    static int N;
    static int M;
    static int K;
    static int index = 0;
    static int result = 0;
    static List<List<Integer>> graph;
    static List<List<Integer>> visited;
    static Queue<List<Integer>> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");

        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        K = Integer.parseInt(size[2]);

        graph = new ArrayList<>(Collections.nCopies(N + 1, null));
        visited = new ArrayList<>(Collections.nCopies(N + 1, null));

        for (int i = 0; i <= N; i++) {
            graph.set(i, new ArrayList<>(Collections.nCopies(M + 1, ROAD)));
            visited.set(i, new ArrayList<>(Collections.nCopies(M + 1, UND)));
        }

        for (int i = 0; i < K; i++) {
            String[] trashPosition = br.readLine().split(" ");
            int n = Integer.parseInt(trashPosition[0]);
            int m = Integer.parseInt(trashPosition[1]);
            graph.get(n).set(m, TRASH);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (graph.get(i).get(j) == TRASH && visited.get(i).get(j) == UND) {
                    get_blob(i, j);
                }
            }
        }

        System.out.println(result);
    }

    public static void get_blob(int n, int m) {
        index++;
        queue.add(Arrays.asList(n, m));
        visited.get(n).set(m, index);
        int cnt = 0;

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            cnt++;

            for (List<Integer> dir : dirs) {
                int next_n = cur.get(_n) + dir.get(_n);
                int next_m = cur.get(_m) + dir.get(_m);

                if (1 <= next_n && next_n <= N &&
                        1 <= next_m && next_m <= M &&
                        graph.get(next_n).get(next_m) == TRASH &&
                        visited.get(next_n).get(next_m) == UND) {
                    visited.get(next_n).set(next_m, index);
                    queue.add(Arrays.asList(next_n, next_m));
                }
            }
        }
        result = Math.max(result, cnt);
    }
}
