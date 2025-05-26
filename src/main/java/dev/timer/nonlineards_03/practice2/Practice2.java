package dev.timer.nonlineards_03.practice2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice2 {

    public static int[] solution(int[][] intervals, int[] queries) {
        if (intervals == null || queries == null) {
            return null;
        }

        if (intervals.length == 0 || intervals[0].length == 0 || queries.length == 0) {
            return null;
        }
        int[][] queriesBak = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            queriesBak[i] = new int[]{queries[i], i};
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((x, y) -> (x[1] - x[0]) - (y[1] - y[0])); // 간격이 작은 순으로 정렬
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        Arrays.sort(queriesBak, (x, y) -> x[0] - y[0]);

        int[] result = new int[queries.length];
        int j = 0;
        for (int i = 0; i < queries.length; i++) {
            int queryVal = queriesBak[i][0];
            int queryIndex = queriesBak[i][1];

            while (j < intervals.length && intervals[j][0] <= queryVal) {
                minHeap.add(intervals[j]);
                j++;
            }

            while (!minHeap.isEmpty() && minHeap.peek()[1] < queryVal) {
                minHeap.remove();
            }

            result[queryIndex] = minHeap.isEmpty() ? -1 : (minHeap.peek()[1] - minHeap.peek()[0] + 1);
        }


        return result;
    }

    public static void main(String[] args) {
        // Test Code
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};
        System.out.println(Arrays.toString(solution(intervals, queries)));

        intervals = new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}};
        queries = new int[]{2, 19, 5, 22};
        System.out.println(Arrays.toString(solution(intervals, queries)));

    }
}
