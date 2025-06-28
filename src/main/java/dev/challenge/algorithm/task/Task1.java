package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 1번 :
 *
 * 카지노의 손님들은 칩의 개수를 가능한 적게, 그리고 거스름돈 없이 모두 칩으로 교환하고 싶어한다.
 * 카지노에서 사용되는 칩의 단위가 정수 배열 chips로 주어질 때, 금액 money를 모두 칩으로 교환한다고 하자.
 * 이 때, 가장 적은 수의 칩으로 교환했을 경우 칩의 개수를 출력하시오.
 *
 * 입력 :
 * money = 3000
 * chips = 1100 500 200 150 25
 *
 * 출력 :
 * 5
 *
 * 설명 :
 * 1100원 2개 500원 1개 150원 2개
 */

public class Task1 {

    public static int solution(int money, int[] chips) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= money; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            for (int chip : chips) {
                if (i + chip <= money && dp[i] + 1 < dp[i + chip]) {
                    dp[i + chip] = dp[i] + 1;
                }
            }
        }

        return dp[money] == Integer.MAX_VALUE ? -1 : dp[money];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        String[] data = br.readLine().split(" ");
        int[] chips = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            chips[i] = Integer.parseInt(data[i]);
        }

        System.out.println(solution(money, chips));
    }
}
