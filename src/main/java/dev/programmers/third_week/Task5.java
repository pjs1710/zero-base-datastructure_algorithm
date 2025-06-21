package dev.programmers.third_week;

/**
 * 7주차 문제 5번 :
 *
 * 제로 카드 게임
 * - N개의 카드를 카드 더미에서 뽑는다.
 * - 정해진 시간 내에 카드를 두 그룹으로 나눈다.
 * - 각 그룹에 속한 카드에 적힌 수의 합을 각각 구한다. 그룹에 속한 카드의 수는 0개일 수 있다.
 * - 두 수의 차이를 패널티라 하며, 이 패널티가 더 작은 사람이 승리한다.
 * 카드 더미에서 이번에 뽑은 N개의 카드에 적힌 수를 모은 정수 배열 cards가 주어진다.
 * 이 때, 뽑은 카드를 이용해서 만들 수 있는 가장 작은 패널티를 구하시오.
 *
 * 입력 :
 * N = 5
 * cards = 1 3 5 6 7 10
 *
 * 결과 :
 * 0
 *
 * 설명 :
 * 1번째 그룹 - 1 3 5 7 -> 합 = 16
 * 2번째 그룹 - 6 10 -> 합 = 16
 */

import java.io.*;
import java.util.*;

public class Task5 {

    public static int solution(int N, int[] cards) {
        int sum = 0;
        for (int card : cards) {
            sum += card;
        }
        int half = sum / 2; // 가장 가까운 값 찾기
        boolean[] dp = new boolean[half + 1];
        // 0은 true로
        dp[0] = true;

        //* TODO : dp[]는 카드들의 합이 i인 부분 그룹을 만들 수 있는지를 확인할 배열

        for (int card : cards) {
            for (int i = half; i >= card; i--) { // 역순 탐색
                if (dp[i - card]) {
                    dp[i] = true;
                }
            }
        }

        for (int i = half; i >= 0; i--) {
            if (dp[i]) {
                int other = sum - i;
                return Math.abs(other - i); // 가장 작은 패널티 값
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < data.length; i++) {
            cards[i] = Integer.parseInt(data[i]);
        }

        System.out.println(solution(N, cards));
    }
}
