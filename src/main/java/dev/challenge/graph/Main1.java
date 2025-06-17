package dev.challenge.graph;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * 인접 행렬 구현
 */

public class Main1 {

    public static void main(String[] args) {
        final int INF = 987654321;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(INF, 1, INF, 1, INF, INF, INF, INF)), // 1 ~ 8까지 A ~ H
                new ArrayList<>(Arrays.asList(INF, INF, 1, INF, 1, INF, INF, INF)),
                new ArrayList<>(Arrays.asList(INF, 1, INF, INF, INF, INF, INF, INF)),
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, 1, INF, 1, INF)),
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, 1, INF, INF)),
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, INF)),
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, 1)),
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, INF))
        ));

        for (int i = 0; i < graph.size(); i++) {
            System.out.println(graph.get(i));
        }
    }
}
