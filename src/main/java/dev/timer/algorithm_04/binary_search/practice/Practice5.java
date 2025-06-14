package dev.timer.algorithm_04.binary_search.practice;

// 정수형 배열 nums와 정수 m이 주어졌다.
// nums에는 양의 정수 값들이 들어있고, m은 배열을 부분 배열로 분리할 수 있는 수이다.
// nums 배열을 m개의 부분 배열로 분리할 때,
// 각 부분 배열의 합 중 가장 큰 값이 최소가 되도록 분리했을 때의 합을 출력하세요.

// 입출력 예시
// nums : 7, 2, 5, 10, 8
// m : 2
// 출력 : 18

// nums : 1, 2, 3, 4, 5
// m : 2
// 출력 : 9

public class Practice5 {

    public static int solution(int[] nums, int m) {
        int left = 0;
        int right = 0;

        for (int num : nums) {
            left = Math.max(num, left);
            right += num;
        }

        if (m == 1) {
            return right;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int total = 0;

            for (int num : nums) {
                total += num;
                if (total > mid) {
                    total = num;
                    cnt++;
                }
            }

            if (cnt <= m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        // Test Code
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(solution(nums, 2)); // 18

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums, 2)); // 9

        nums = new int[]{1, 4, 4};
        System.out.println(solution(nums, 3)); // 4
    }
}
