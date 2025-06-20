package dev.challenge.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main1 {

    static final int INF = 987654321;

    static int X;
    static List<Integer> table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());

        table = new ArrayList<>(Collections.nCopies(X + 1, INF));
        table.set(1, 0);

        for (int i = 1; i <= X; i++) {
            for (int next : Arrays.asList(i * 2, i * 3, i + 1)) {
                if (next <= X) {
                    int min = Math.min(table.get(next), table.get(i) + 1);
                    table.set(next, min);
                }
            }
        }

        System.out.println(table.get(X));
    }
}
