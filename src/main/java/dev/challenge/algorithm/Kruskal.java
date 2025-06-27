package dev.challenge.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w, o.w);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "u=" + u +
                ", v=" + v +
                ", w=" + w +
                '}';
    }
}

public class Kruskal {

    static int N, M;
    static List<Integer> set;
    static List<Edge> edges;
    static List<Edge> resultEdge;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        resultEdge = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int tu = Integer.parseInt(st.nextToken());
            int tv = Integer.parseInt(st.nextToken());
            int tw = Integer.parseInt(st.nextToken());
            edges.add(new Edge(tu, tv, tw));
        }

        set = new ArrayList<>(Collections.nCopies(N + 1, 0));
        for (int i = 0; i <= N; i++) {
            set.set(i, i);
        }

        Collections.sort(edges);

        for (Edge e : edges) {
            if (findSet(e.u) != findSet(e.v)) {
                resultEdge.add(e);
                result += e.w;
                unionSet(e.u, e.v);
            }
        }

        System.out.println(result);
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
