package dev.programmers.week_14;

import java.util.*;

/**
 * 당신은 배열 천재가 되기 위해 수련중이다. 배열 천재가 되기 위해서는 조건에 맞는 부분 배열을 항상 빠르게 찾아낼 수 있어야 한다.
 * 이번에 당신이 찾아야 하는 부분 배열의 조건은 아래와 같다.
 * - 부분 배열의 총 합과 부분 배열 중 가장 작은 원소의 곱을 부분 배열의 점수로 하자. (sum(subArray) * min(subArray))
 * - 이 때, 가장 높은 점수를 가지는 부분 배열을 찾아라.
 * - 단, 전체 배열의 모든 원소는 자연수이다.
 * 예를 들면, 아래와 같은 배열이 주어졌다고 하자.
 * nums = {2, 5, 10, 9, 8, 5}
 * 이 때, 위 조건에 해당하는 부분 배열과 그 점수는 아래와 같다.
 * {10, 9, 8} -> (10 + 9 + 8) * 8 = 216
 * 위와 같이 주어진 배열 nums에서 조건에 맞는 부분 배열의 점수를 출력하시오.
 */

public class Num_10 {

    public static int solution(int[] nums) {
        int maxScore = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int min = nums[i];

            for (int j = i; j < n; j++) {
                sum += nums[j];
                min = Math.min(min, nums[j]);

                int score = sum * min;
                maxScore = Math.max(maxScore, score);
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {

    }
}
