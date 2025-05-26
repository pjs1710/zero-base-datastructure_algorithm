package dev.timer.nonlineards_03.practice2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice4 {

    public static int solution(int n, int[] speed, int[] efficiency, int k) {
        if (speed == null || efficiency == null || speed.length == 0 || efficiency.length == 0 || k == 0) {
            return -1;
        }

        if (speed.length != efficiency.length) {
            return -1;
        }

        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; i++) {
            engineers[i] = new int[]{efficiency[i], speed[i]};
        }

        Arrays.sort(engineers, (x, y) -> y[0] - x[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (x, y) -> x - y);
        int sum = 0;
        int result = 0;
        for (int[] eg : engineers) {
            pq.offer(eg[1]);
            sum += eg[1];

            if (pq.size() > k) {
                sum -= pq.poll();
            }

            result = Math.max(result, (sum * eg[0]));
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Code
        int[] speed = {2, 10, 3, 1, 5, 8};
        int[] efficiency = {5, 4, 3, 9, 7, 2};
        System.out.println(solution(6, speed, efficiency, 2));
        System.out.println(solution(6, speed, efficiency, 3));
        System.out.println(solution(6, speed, efficiency, 4));
    }
}
