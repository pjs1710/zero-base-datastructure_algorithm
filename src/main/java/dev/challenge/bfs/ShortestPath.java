package dev.challenge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShortestPath {

    static final int UND = -1;
    static final int WALL = 0;
    static final int ROAD = 1;
    static final int START = 2;
    static final int _n = 0;
    static final int _m = 1;
    static final List<List<Integer>> dirs = Arrays.asList(
            Arrays.asList(-1, 0),
            Arrays.asList(0, 1),
            Arrays.asList(0, -1),
            Arrays.asList(1, 0)
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        List<List<Integer>> graph = new ArrayList<>(Collections.nCopies(N + 1, null));
        List<List<Integer>> visited = new ArrayList<>(Collections.nCopies(N + 1, null));

        for (int i = 0; i <= N; i++) {
            graph.set(i, new ArrayList<>(Collections.nCopies(M + 1, UND)));
            visited.set(i, new ArrayList<>(Collections.nCopies(M + 1, UND)));
        }

        List<Integer> start = null;

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                int value = Integer.parseInt(line[j - 1]);
                graph.get(i).set(j, value);
                if (value == START) {
                    start = Arrays.asList(i, j);
                }
            }
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(start);
        visited.get(start.get(_n)).set(start.get(_m), 0);

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();

            for (List<Integer> dir : dirs) {
                int next_n = cur.get(_n) + dir.get(_n);
                int next_m = cur.get(_m) + dir.get(_m);

                if (1 <= next_n && next_n <= N && 1 <= next_m && next_m <= M
                        && visited.get(next_n).get(next_m) == UND && graph.get(next_n).get(next_m) == ROAD) {
                    visited.get(next_n).set(next_m, visited.get(cur.get(_n)).get(cur.get(_m)) + 1);
                    queue.add(Arrays.asList(next_n, next_m));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited.get(i).get(j) == UND) {
                    if (graph.get(i).get(j) == WALL) {
                        System.out.print("0 ");
                    } else {
                        System.out.print("-1 ");
                    }
                } else {
                    System.out.print(visited.get(i).get(j) + " ");
                }
            }
            System.out.println();
        }

    }
}
