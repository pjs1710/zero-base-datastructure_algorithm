package dev.challenge.algorithm;

import java.io.*;
import java.util.*;

public class LCS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = "!" + br.readLine();
        String B = "!" + br.readLine();

        int size = Math.max(A.length(), B.length());
        List<List<Integer>> table = new ArrayList<>(Collections.nCopies(size, null));

        for (int i = 0; i < size; i++) {
            table.set(i, new ArrayList<>(Collections.nCopies(size, 0)));
        }

        for (int a = 1; a < A.length(); a++) {
            for (int b = 1; b < B.length(); b++) {
                if (A.charAt(a) == B.charAt(b)) {
                    table.get(a).set(b, table.get(a - 1).get(b - 1) + 1);
                } else {
                    int max = Math.max(table.get(a - 1).get(b), table.get(a).get(b - 1));
                    table.get(a).set(b, max);
                }
            }
        }

        System.out.println((int) table.get(A.length() - 1).get(B.length() - 1));
    }
}
