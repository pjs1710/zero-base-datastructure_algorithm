package dev.challenge.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 인접 리스트 구현
 */

class Vertex {
    int v; // 현재 번호
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
}

public class Main2 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Vertex>> graph = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(new Vertex(1, 3), new Vertex(3, 4))),
                new ArrayList<>(Arrays.asList(new Vertex(2, 1), new Vertex(4, 2))),
                new ArrayList<>(Arrays.asList(new Vertex(1, 7))),
                new ArrayList<>(Arrays.asList(new Vertex(4, 8), new Vertex(6, 5))),
                new ArrayList<>(Arrays.asList(new Vertex(5, 9))),
                new ArrayList<>(Arrays.asList()),
                new ArrayList<>(Arrays.asList(new Vertex(7, 6))),
                new ArrayList<>(Arrays.asList())
        ));

        for (int i = 0; i < graph.size(); i++) {
            System.out.println(i + " - " + graph.get(i));
        }
    }
}
