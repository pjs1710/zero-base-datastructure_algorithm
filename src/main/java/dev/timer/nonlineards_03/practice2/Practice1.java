package dev.timer.nonlineards_03.practice2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice1 {

    public static int solution(int[][] times, int targetFriend) {
        if (times == null || times.length == 0 || times[0].length == 0) {
            return -1;
        }

        int targetArrival = times[targetFriend][0];

        Arrays.sort(times, (x, y) -> x[0] - y[0]);

        PriorityQueue<Integer> pqChair = new PriorityQueue<>();
        for (int i = 0; i < times.length; i++) {
            pqChair.offer(i);
        }

        PriorityQueue<int[]> pqFriend = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        for (int i = 0; i < times.length; i++) {

            while (!pqFriend.isEmpty() && pqFriend.peek()[0] <= times[i][0]) {
                pqChair.offer(pqFriend.poll()[1]);
            }

            if (times[i][0] == targetArrival) {
                break;
            }
            pqFriend.offer(new int[]{times[i][1], pqChair.poll()});
        }

        return pqChair.peek();
    }

    public static void main(String[] args) {
        // Test Code
        int[][] times = {{1, 4}, {2, 3}, {4, 6}};
        System.out.println(solution(times, 1)); // 1

        times = new int[][]{{3, 10}, {1, 5}, {2, 6}};
        System.out.println(solution(times, 0)); // 2
    }
}
