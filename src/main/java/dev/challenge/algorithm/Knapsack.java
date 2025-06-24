package dev.challenge.algorithm;

import java.io.*;
import java.util.*;

class Item {
    int v;
    int w;

    public Item(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Knapsack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Item> items = new ArrayList<>();
        items.add(new Item(0, 0));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items.add(new Item(v, w));
        }

        List<List<Integer>> table = new ArrayList<>(Collections.nCopies(N + 1, null));
        for (int i = 0; i <= N; i++) {
            table.set(i, new ArrayList<>(Collections.nCopies(K + 1, 0)));
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= K; k++) {
                if (items.get(n).w > k) {
                    table.get(n).set(k, table.get(n - 1).get(k));
                } else {
                    var pre = table.get(n - 1).get(k);
                    var cur = items.get(n).v + table.get(n - 1).get(k - items.get(n).w);
                    var max = Math.max(cur, pre);
                    table.get(n).set(k, max);
                }
            }
        }

        System.out.println(table.get(N).get(K));
    }
}
