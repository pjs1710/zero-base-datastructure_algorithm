package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 맥주잔은 2X1 크기로, 세로의 길이가 가로의 길이보다 두 배 더 길다. 옆으로 놓을 경우 1X2로 배치할 수도 있다.
 * 맥주잔을 높이 N까지 NX2의 직사각형 형태로 쌓아 올리는 방법의 수를 구하여라
 * 0 <= N <= 10
 *
 * N = 4
 * return = 5
 */

public class Num_2 {

    static int N;

    public static int solution(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }
}
