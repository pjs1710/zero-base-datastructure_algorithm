package dev.programmers.week_14;

import java.util.*;

/**
 * 민수와 영희는 함께 여행을 가기로 했다. 함께 공부하며 단짝이 된 두 친구는 계속 붙어다니기로 하고 각자의 짐을 모두 모아서, 두 가방에 적절하게 함께 나누어 담기로 했다.
 * 즉, 총 N개의 짐을 무게 K1, K2만큼 담을 수 있는 가방에 각각 나누어 담고자 한다.
 * i번째 짐의 무게와 가치가 각각 W[i]와 V[i]로 주어졌을 때, 두 사람이 담을 수 있는 짐의 가치의 합 중 최대값을 구하시오.
 *
 * 입력 :
 * N = 8
 * K1 = 10
 * K2 = 15
 * W = 6 4 5 6 8 9 10 3
 * V = 10 4 6 8 2 8 5 6
 *
 * 결과 :
 * 34
 */

public class Num_15 {

    public static int solution(int N, int K1, int K2, int[] W, int[] V) {
        int[][][] dp = new int[N + 1][K1 + 1][K2 + 1];

        for (int i = 1; i <= N; i++) {
            int weight = W[i - 1];
            int value = V[i - 1];

            for (int w1 = 0; w1 <= K1; w1++) {
                for (int w2 = 0; w2 <= K2; w2++) {
                    dp[i][w1][w2] = dp[i - 1][w1][w2];

                    if (w1 >= weight) {
                        dp[i][w1][w2] = Math.max(dp[i][w1][w2],
                                dp[i - 1][w1 - weight][w2] + value);
                    }

                    if (w2 >= weight) {
                        dp[i][w1][w2] = Math.max(dp[i][w1][w2],
                                dp[i - 1][w1][w2 - weight] + value);
                    }
                }
            }
        }

        return dp[N][K1][K2];
    }

    public static void main(String[] args) {

    }
}
