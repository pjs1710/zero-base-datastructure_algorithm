package dev.challenge.algorithm;

import java.io.*;
import java.util.*;

public class LIS {

    static final int UND = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        List<Integer> table = new ArrayList<>(Collections.nCopies(N + 1, 0));
        arr.add(UND);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (arr.get(j) < arr.get(i) && max < table.get(j)) {
                    max = table.get(j);
                }
            }
            table.set(i, max + arr.get(i));
            result = Math.max(result, table.get(i));
        }

        System.out.println(result);
    }
}
