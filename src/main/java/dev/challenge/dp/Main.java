package dev.challenge.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static final int INF = 987654321;
    static final int UND = -1;
    static int cnt = 0;
    static List<Integer> memo;

    public static int f(int x) {
        cnt++;
        if (x == 1) {
            return 0;
        }

        if (memo.get(x) != UND) {
            return memo.get(x);
        }

        int ret = INF;

        if (x % 3 == 0) {
            if (memo.get(x / 3) != UND) {
                ret = Math.min(memo.get(x / 3), ret);
            } else {
                ret = Math.min(f(x / 3), ret);
            }
        }
        if (x % 2 == 0) {
            if (memo.get(x / 2) != UND) {
                ret = Math.min(memo.get(x / 2), ret);
            } else {
                ret = Math.min(f(x / 2), ret);
            }
        }
        memo.set(x, Math.min(f(x - 1), ret) + 1);

        return memo.get(x);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        memo = new ArrayList<>(Collections.nCopies(X + 1, UND));

        int result = f(X);
        System.out.println(result);
        System.out.println("cnt : " + cnt);
    }
}
