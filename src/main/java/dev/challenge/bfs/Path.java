package dev.challenge.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Path {

    static final int UND = -1;
    static final int WALL = 0;
    static final int ROAD = 1;
    static final int _n = 0;
    static final int _m = 1;
    static final List<List<Integer>> dirs = Arrays.asList(
            Arrays.asList(-1, 0),
            Arrays.asList(0, 1),
            Arrays.asList(1, 0),
            Arrays.asList(0, -1)
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>(Collections.nCopies(N + 1, null));
        List<List<Integer>> visited = new ArrayList<>(Collections.nCopies(N + 1, null));

        for (int i = 0; i <= N; i++) {
            graph.set(i, new ArrayList<>(Collections.nCopies(M + 1, UND)));
            visited.set(i, new ArrayList<>(Collections.nCopies(M + 1, UND)));
        }

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                graph.get(i).set(j, line.charAt(j - 1) - '0');
            }
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(1, 1));
        visited.get(1).set(1, 1);

        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll(); // 좌표
            for (List<Integer> dir : dirs) {
                int nextN = cur.get(_n) + dir.get(_n);
                int nextM = cur.get(_m) + dir.get(_m);

                if (1 <= nextN && nextN <= N && 1 <= nextM && nextM <= M && visited.get(nextN).get(nextM) == UND
                && graph.get(nextN).get(nextM) == ROAD) {
                    visited.get(nextN).set(nextM, visited.get(cur.get(_n)).get(cur.get(_m)) + 1);
                    queue.add(Arrays.asList(nextN, nextM));
                }
            }
        }

        System.out.println(visited.get(N).get(M));
    }
}
