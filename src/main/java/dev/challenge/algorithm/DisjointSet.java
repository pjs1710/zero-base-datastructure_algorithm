package dev.challenge.algorithm;

import java.util.*;
import java.io.*;

class Order {
    int op, a, b;

    public Order(int op, int a, int b) {
        this.op = op;
        this.a = a;
        this.b = b;
    }
}

public class DisjointSet {
    static int N, M;
    static List<Integer> set;
    static List<Order> orders;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new ArrayList<>(Collections.nCopies(N + 1, 0));
        for (int i = 0; i <= N; i++) {
            set.set(i, i);
        }
        orders = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            orders.add(new Order(op, a, b));
        }

        for (Order o : orders) {
            if (o.op == 0) {
                unionSet(o.a, o.b);
                System.out.println(set);
            } else {
                if (findSet(o.a) == findSet(o.b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
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
