package dev.programmers.first_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * 5주차 문제 1번 :
 *
 * 어떤 정수 배열 original이 있다고 가정하자.
 * 이 정수 배열은 중복된 값이 있을 수 있으며, 오름차순으로 정렬되어 있다.
 * 이 정수 배열의 모든 값에 2를 곱한 뒤, 기존의 배열과 함께 임의로 섞는 변환을 적용하여 만든 배열을 nums라고 하자.
 * 예를 들어, original = {1, 4, 5}인 경우, nums는 {1, 4, 5, 2, 8, 10}을 포함하여 순서가 다른 모든 배열이 될 수 있다.
 * nums 배열이 주어졌을 때, original 배열을 찾아 출력하시오.
 * 단, nums 배열이 어떤 배열을 변환해서도 만들 수 없다면 빈 배열을 출력하시오.
 *
 * 0 < nums.length <= 10000
 *
 * 입력 예시 :
 * 1 8 2 4 5 10
 *
 * 출력 예시 :
 * {1, 4, 5}
 */

public class Task1 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(", ");
        int numsSize = data.length;
        int[] nums = new int[numsSize];

        for (int i = 0; i < numsSize; i++) {
            nums[i] = Integer.parseInt(data[i]);
        }

        int[] findArr = findArr(nums);
        Arrays.stream(findArr).sorted();
        System.out.println(Arrays.toString(findArr));

    }

    private static int[] findArr(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        int[] resultArr = new int[nums.length / 2];
        int i = 0, idx = 0;

        while (i < nums.length) {
            if (visited[i]) {
                i++;
                continue;
            }

            boolean found = false;

            for (int j = i + 1; j < nums.length; j++) {
                if (!visited[j] && nums[j] == nums[i] * 2) {
                    visited[i] = true;
                    visited[j] = true;
                    resultArr[idx++] = nums[i];
                    found = true;
                    break;
                }
            }

            if (!found) {
                return new int[]{};
            }

            i++;
        }

        return Arrays.copyOf(resultArr, idx);
    }
}
