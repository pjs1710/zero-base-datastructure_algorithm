package dev.programmers.week_14;

import java.util.*;
import java.io.*;

/**
 * 제로상담소를 운영하고 있는 금쪽이는 최근 TV 방송 출연으로 최고의 인기를 끌고 있다.
 * 금쪽이의 스케줄을 담당하고 있는 당신은 금쪽이가 최대의 수익을 올릴 수 있도록 스케줄을 잡아주려고 한다.
 * 당신은 우선 인터넷으로 모든 예약 요청을 받아둔 후에, 상담 비용의 총 합이 최대가 되도록 약속을 확정지으려 한다.
 * 수집된 예약 요청은 약속 시작 시간 start[i], 종료 시간 end[i], 그리고 상담 비용 price[i]이다.
 * 시간이 겹치지 않게 예약을 확정하려 할 때, 가능한 최대의 상담 비용을 구하시오.
 *
 * 입력 :
 * start = 1 5 10 6 5
 * end = 5 6 12 9 12
 * price = 10 40 30 20 50
 *
 * 결과 :
 * 100
 */

public class Num_11 {

    public static int solution(int[] start, int[] end, int[] price) {
        int n = start.length;

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> end[a] - end[b]);

        int[] dp = new int[n];
        dp[0] = price[indices[0]];

        for (int i = 1; i < n; i++) {
            int currentIdx = indices[i];
            int exclude = dp[i - 1];
            int include = price[currentIdx];

            for (int j = i - 1; j >= 0; j--) {
                int prevIdx = indices[j];
                if (end[prevIdx] <= start[currentIdx]) {
                    include += dp[j];
                    break;
                }
            }

            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

    }

}
