package dev.challenge.algorithm;

import java.io.*;
import java.util.*;

public class CumulativeSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        arr.add(0);

        while (st.hasMoreElements()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> table = new ArrayList<>(Collections.nCopies(N + 1, 0));

        table.set(0, arr.get(0));

        for (int n = 1; n <= N; n++) {
            table.set(n, arr.get(n) + table.get(n - 1));
        }

        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(table.get(e) - table.get(s - 1));
        }
    }
}
