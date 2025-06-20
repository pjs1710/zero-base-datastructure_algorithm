package dev.challenge.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int INF = 987654321;
    static int cnt = 0;

    public static int f(int x) {
        cnt++;
        if (x == 1) {
            return 0;
        }

        int ret = INF;

        if (x % 3 == 0) {
            ret = Math.min(f(x / 3), ret);
        }
        if (x % 2 == 0) {
            ret = Math.min(f(x / 2), ret);
        }

        return Math.min(f(x - 1), ret) + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int result = f(X);
        System.out.println(result);
        System.out.println("cnt : " + cnt);
    }
}
