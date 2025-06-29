package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 6번 :
 *
 * 원이는 친구들을 속이는 재미를 뒤늦게 깨닫고, 효율적인 거짓말 놀이를 하기로 하였다.
 * 원이는 0번 친구에게 단 한번의 거짓말을 하여 N명의 모든 친구들을 속이고자 한다.
 * 한 사람이 거짓말을 믿게 되면, 그 사람의 친한 친구들은 일정 시간 후에 거짓말을 믿게 된다.
 * friend[i] 에는 i번째 친구와 친한 친구들의 인덱스가 배열로 주어진다.
 * time[i]에는 i번째 친구가 거짓말을 믿기 시작한 후에, 그 사람의 친한 친구들이 거짓말을 믿는 데에 걸리는 시간이 배열로 주어진다.
 * 이 때, 단 한번의 거짓말로 원이의 모든 친구들이 거짓말을 믿게 되는 데에 걸리는 시간을 계산하시오.
 * 단, 한 번의 거짓말로 모든 친구가 거짓말을 믿게 할 수 없으면 -1을 반환하시오.
 *
 * 입력 :
 * N = 5
 * friend = {{1, 4}, {2, 3}, {4}, {1}, {0, 2}}
 * time = {{5, 2}, {6, 4}, {9}, {1}, {2, 6}}
 *
 * 출력 :
 * 9
 */

public class Task6 {

    public static int solution(int N, int[][] friend, int[][] time) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int curTime = cur[1];

            if (curTime > dist[now]) {
                continue;
            }

            for (int i = 0; i < friend[now].length; i++) {
                int next = friend[now][i];
                int cost = time[now][i];
                int nextTime = curTime + cost;

                if (nextTime < dist[next]) {
                    dist[next] = nextTime;
                    pq.offer(new int[]{next, nextTime});
                }
            }
        }

        int max = 0;
        for (int item : dist) {
            if (item == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, item);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {

    }
}
