package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 1번 :
 *
 * 총 N개의 짐을 무게 K1, K2만큼 담을 수 있는 가방에 각각 나누어 담고자 한다.
 * i번째 짐의 무게와 가치가 각각 W[i]와 V[i]로 주어졌을 때, 두 사람이 담을 수 있는 짐의 가치의 합 중 최대값을 구하시오.
 *
 * 입력 :
 * N = 8
 * K1 = 10
 * K2 = 15
 * W = 6 4 5 6 8 9 10 3
 * V = 10 4 6 8 2 8 5 6
 *
 * 출력 :
 * 34
 */

public class Task2 {

    public static int solution(int N, int K1, int K2, int[] W, int[] V) {
        int[][] memo = new int[K1 + 1][K2 + 1];

        for (int i = 0; i < N; i++) {
            int w = W[i];
            int v = V[i];

            for (int j = K1; j >= 0; j--) {
                for (int k = K2; k >= 0; k--) {
                    if (j >= w) {
                        memo[j][k] = Math.max(memo[j][k], memo[j - w][k] + v);
                    }

                    if (k >= w) {
                        memo[j][k] = Math.max(memo[j][k], memo[j][k - w] + v);
                    }
                }
            }
        }

        return memo[K1][K2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K1 = Integer.parseInt(br.readLine());
        int K2 = Integer.parseInt(br.readLine());
        int[] W = new int[N];
        int[] V = new int[N];

        String[] data1 = br.readLine().split(" ");
        String[] data2 = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(data1[i]);
        }

        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(data2[i]);
        }

        System.out.println(solution(N, K1, K2, W, V));
    }
}
