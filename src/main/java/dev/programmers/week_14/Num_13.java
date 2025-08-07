package dev.programmers.week_14;

import java.util.*;

/**
 * 당신은 제로국으로 급파된 암살자로, 제로국의 주요 인사들을 암살하는 임무를 맡았다.
 * 제로국에는 총 N개의 성이 잇고 이 성들은 일정한 가격으로 원형으로 배치되어 있다.
 * 당신은 조사원들을 통해서 다음과 같은 사실을 알아내었다.
 * - 각 성마다 주요 인사는 한 명씩 배치되어 있다.
 * - 각 성의 주요 인사를 암살했을 때의 보상은 rewards[i]로 주어진다.
 * - 하나의 성의 주요 인사를 암살할 경우, 인접한 성은 경계태세가 되어 침입할 수 없다.
 * 위 조건에서 달성할 수 있는 최대의 보상을 구하시오.
 * 단, 원형 배치의 특성상 첫 번째 성은 마지막 성과 인접해 있다.
 *
 * 입력 :
 * N = 6
 * rewards = 5 10 5 7 5 9
 *
 * 결과 :
 * 26
 */

public class Num_13 {

    public static int solution(int N, int[] rewards) {
        if (N == 1) return rewards[0];
        if (N == 2) return Math.max(rewards[0], rewards[1]);

        int case1 = robLinear(rewards, 0, N - 2);
        int case2 = robLinear(rewards, 1, N - 1);

        return Math.max(case1, case2);
    }

    private static int robLinear(int[] rewards, int start, int end) {
        int prevMax = 0;
        int currMax = 0;

        for (int i = start; i <= end; i++) {
            int temp = currMax;
            currMax = Math.max(currMax, prevMax + rewards[i]);
            prevMax = temp;
        }

        return currMax;
    }

    public static void main(String[] args) {

    }
}
