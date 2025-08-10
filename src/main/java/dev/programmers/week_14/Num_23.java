package dev.programmers.week_14;

import java.util.*;

/**
 * 정수로 이루어진 배열 nums가 주어지고, 0번 인덱스에서 시작한다고 하자.
 * 최대 현재 인덱스의 숫자 nums[i]만큼 우측으로 이동이 가능하다고 할 때, 최종적으로 마지막 위치까지 도달할 수 있는지 여부를 논리형 값으로 출력하시오.
 *
 * 입력 :
 * nums = {3, 4, 1, 1, 0, 3}
 *
 * 결과 :
 * true
 */

public class Num_23 {

    public boolean solution(int[] nums) {
        int maxReach = 0; // 현재까지 도달 가능한 최대 인덱스

        for (int i = 0; i < nums.length; i++) {
            // 현재 위치가 도달 불가능한 경우
            if (i > maxReach) {
                return false;
            }

            // 현재 위치에서 점프할 수 있는 최대 거리 업데이트
            maxReach = Math.max(maxReach, i + nums[i]);

            // 마지막 인덱스에 도달할 수 있는 경우
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return maxReach >= nums.length - 1;
    }

    public static void main(String[] args) {

    }
}
