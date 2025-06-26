package dev.challenge.algorithm;

import java.io.*;
import java.util.*;

public class FloydWarshall {

    static final int INF = 0XFFFFFFF;
    static int N;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(Collections.nCopies(N + 1, null));
        for (int i = 0; i <= N; i++) {
            graph.set(i, new ArrayList<>(Collections.nCopies(N + 1, INF)));
        }

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                int tmp = Integer.parseInt(st.nextToken());
                graph.get(r).set(c, tmp == 0 ? INF : tmp);
            }
        }


        // Floyd Warshall 적용
        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <= N; e++) {
                    int mn = Math.min(graph.get(s).get(e), graph.get(s).get(m) + graph.get(m).get(e));
                    graph.get(s).set(e, mn);
                }
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (graph.get(r).get(c) == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
    }
}
