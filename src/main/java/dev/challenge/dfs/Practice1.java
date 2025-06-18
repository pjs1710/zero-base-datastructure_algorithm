package dev.challenge.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Vertex implements Comparable<Vertex> {
    int v; // 현재 값
    int w; // 가중치

    public Vertex(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "v=" + v +
                ", w=" + w +
                '}';
    }

    @Override
    public int compareTo(Vertex other) {
        return this.v - other.v;
    }
}

public class Practice1 {

    static List<List<Vertex>> graph;
    static List<Integer> visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        graph.add(null);
        for (int i = 1; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Vertex(e, 1));
            graph.get(e).add(new Vertex(s, 1));
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new ArrayList<>(Collections.nCopies(N + 1, 0)); // N + 1 크기의 배열을 0으로 모두 초기화

        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited.get(i));
        }
    }

    public static void dfs(int start) {
        count++;
        visited.set(start, count);
        for (Vertex next : graph.get(start)) {
            if (visited.get(next.v) == 0) {
                dfs(next.v);
            }
        }
    }
}
