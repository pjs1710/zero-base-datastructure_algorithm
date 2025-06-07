package dev.basic.ds.stack_vs_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제풀이 2번 :
 *
 * 큐 2개를 이용해서, 오름차순 정렬을 해보세요.
 *
 * 5 6 1 3 2 4 -> 1 2 3 4 5 6
 */

public class Practice2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();

        for (String value : data) {
            queue.offer(Integer.parseInt(value));
        }

        // TODO Queue 정렬
        sortQueue(queue);

        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void sortQueue(Queue<Integer> queue) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int now = queue.poll();

            int innerSize = queue.size();
            for (int j = 0; j < innerSize; j++) {
                int next = queue.poll();
                if (now < next) {
                    queue.offer(now);
                    now = next;
                } else {
                    queue.offer(next);
                }
            }

            queue.offer(now);
        }
    }
}
