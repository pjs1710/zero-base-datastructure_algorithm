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
    static List<Set<Integer>> setLink;
    static List<Order> orders;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        setLink = new ArrayList<>(Collections.nCopies(N + 1, null));

        for (int n = 0; n <= N; n++) {
            setLink.set(n, new HashSet<>());
            setLink.get(n).add(n);
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
                var setA = setLink.get(o.a);
                var setB = setLink.get(o.b);
                setA.addAll(setB);
                for (Integer item : setA) {
                    setLink.set(item, setA);
                }
            } else {
                if (setLink.get(o.a).contains(o.b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
