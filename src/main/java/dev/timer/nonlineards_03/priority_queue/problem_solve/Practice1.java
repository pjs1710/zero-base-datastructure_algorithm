package dev.timer.nonlineards_03.priority_queue.problem_solve;

// nums 배열에 주어진 정수들 중에서 k번째로 큰 수를 반환하는 프로그램 작성

// 입력 예시
// 입력 : 3, 1, 2, 7, 6, 4
// k : 2
// 출력 : 6

// 입력 : 1, 3, 7, 4, 2, 8, 9
// k : 7
// 출력 : 1

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice1 {
    // 우선순위 큐를 이용한 접근
    public static int solution(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본은 오름차순
        for (int num : nums) {
            pq.offer(num); // 큐에 값들 넣기

            if (pq.size() > k) {
                pq.poll(); // 사이즈 만큼 빼기 k 사이즈를 유지하는 트리
            }
        }

        return pq.peek();
    }


    public static int solution2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        // Test Code
        int[] nums = {3, 1, 2, 7, 6, 4};
        System.out.println(solution(nums, 2));
        System.out.println(solution2(nums, 2));
        System.out.println();

        nums = new int[]{1, 3, 7, 4, 2, 8, 9};
        System.out.println(solution(nums, 7));
        System.out.println(solution2(nums, 7));
    }
}
