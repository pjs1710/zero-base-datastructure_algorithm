package dev.challenge.algorithm;

import java.io.*;
import java.util.*;

class Edge1 implements Comparable<Edge1> {
    int u, v, w;

    @Override
    public int compareTo(Edge1 o) {
        return Integer.compare(this.w, o.w);
    }

    public Edge1(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Edge1{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}

public class KruskalExample {

    static int N, M;
    static List<Integer> set;
    static List<Edge1> edges;
    static List<Edge1> resultEdges;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        resultEdges = new ArrayList<>();

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int tu = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int tw = Integer.parseInt(st.nextToken());
            edges.add(new Edge1(tu, tv, tw));
        }

        set = new ArrayList<>(Collections.nCopies(N + 1, 0));
        for (int i = 0; i <= N; i++) {
            set.set(i, i);
        }

        Collections.sort(edges);

        for (Edge1 e : edges) {
            /**
             * 마지막 연산 하지 않는 방법
             */
//            if (resultEdges.size() == N - 2) {
//                break;
//            }
            if (findSet(e.u) != findSet(e.v)) {
                resultEdges.add(e);
                unionSet(e.u, e.v);
            }
        }

        for (Edge1 e : resultEdges) {
            result += e.w;
        }

        System.out.println(result);
        // System.out.println(result - resultEdges.getLast().w); 마지막 연산을 빼주는 방법
    }

    static int findSet(int a) {
        if (set.get(a) != a) {
            set.set(a, findSet(set.get(a)));
        }
        return set.get(a);
    }

    static void unionSet(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        set.set(b, a);
    }
}
