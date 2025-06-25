package dev.challenge.algorithm;

import java.io.*;
import java.util.*;

class Vertex {
    int n;
    int w;

    public Vertex(int n, int w) {
        this.n = n;
        this.w = w;
    }
}

public class BFS {

    static final int UND = -1;
    static int N, K, MAX;
    static List<Integer> visited;
    static Deque<Vertex> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        MAX = Math.max(N, 2 * K);

        visited = new ArrayList<>(Collections.nCopies(MAX + 1, UND));
        dq.addLast(new Vertex(N, 0));

        while (!dq.isEmpty()) {
            Vertex cur = dq.pollFirst();
            if (visited.get(cur.n) == UND) {
                visited.set(cur.n, cur.w);
                List<Vertex> nextList = Arrays.asList(
                        new Vertex(cur.n * 2, cur.w),
                        new Vertex(cur.n + 1, cur.w + 1),
                        new Vertex(cur.n - 1, cur.w + 1)
                );

                for (Vertex next : nextList) {
                    if (0 <= next.n && next.n <= MAX) {
                        if (next.w == cur.w) {
                            dq.addFirst(next);
                        } else {
                            dq.addLast(next);
                        }
                    }
                }
            }
        }
        System.out.println(visited.get(K));
    }
}
