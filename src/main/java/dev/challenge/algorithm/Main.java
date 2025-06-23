package dev.challenge.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static long t(int n) {
        if (n == 0) {
            return 1;
        }
        long ret = 0;

        for (int i = 0; i < n; i++) {
            ret += t(i) * t(n - i - 1); // i + n - i - 1 = n - 1
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(t(N));
    }
}
