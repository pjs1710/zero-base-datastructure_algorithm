package dev.challenge.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Set<Integer> s = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x = 0;
            if (!op.equals("all") && !op.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (op) {
                case "add":
                    s.add(x);
                    break;
                case "remove":
                    s.remove(x);
                    break;
                case "check":
                    sb.append(s.contains(x) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    if (s.contains(x)) {
                        s.remove(x);
                    } else {
                        s.add(x);
                    }
                    break;
                case "all":
                    for (int i = 1; i <= 20; i++) {
                        s.add(i);
                    }
                    break;
                case "empty":
                    s.clear();
                    break;
            }
            System.out.println(sb);
        }
    }
}
