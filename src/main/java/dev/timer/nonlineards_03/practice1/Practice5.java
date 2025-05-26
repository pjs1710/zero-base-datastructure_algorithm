package dev.timer.nonlineards_03.practice1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Practice5 {

    public static int solution(int[] forbidden, int a, int b, int x) {
        int cnt = 0;
        int limit = x + a + b;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        HashSet<int[]> visited = new HashSet<>();
        for (int pos : forbidden) {
            visited.add(new int[]{0, pos});
            visited.add(new int[]{1, pos});
            limit = Math.max(limit, pos + a + b);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] cur = queue.poll();
                int dir = cur[0];
                int pos = cur[1];

                if (pos == x) {
                    return cnt;
                }

                int[] forward = new int[]{0, pos + a};
                if (pos + a <= limit && visited.add(forward)) {
                    queue.offer(forward);
                }

                int[] backward = new int[]{1, pos - b};
                if (dir == 0 && pos - b >= 0 && visited.add(backward)) {
                    queue.offer(backward);
                }
            }
            cnt++;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test Code
        int[] forbidden = {14, 4, 18, 1, 15};
        System.out.println(solution(forbidden, 3, 15, 9));

        forbidden = new int[]{8, 3, 16, 6, 12, 20};
        System.out.println(solution(forbidden, 15, 13, 11));

        forbidden = new int[]{1, 6, 2, 14, 5, 17, 4};
        System.out.println(solution(forbidden, 16, 9, 7));
    }
}
