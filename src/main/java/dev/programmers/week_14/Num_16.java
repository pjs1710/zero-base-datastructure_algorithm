package dev.programmers.week_14;

import java.util.*;

/**
 * 원이는 친구들을 속이는 재미를 뒤늦게 깨닫고, 효율적인 거짓말 놀이를 하기로 하였다.
 * 원이는 0번 친구에게 단 한번의 거짓말을 하여 N명의 모든 친구들을 속이고자 한다.
 * 한 사람이 거짓말을 믿게 되면, 그 사람의 친한 친구들은 일정 시간 후에 거짓말을 믿게 된다.
 * friend[i]에는 i번째 친구와 친한 친구들의 인덱스가 배열로 주어진다.
 * time[i]에는 i번째 친구가 거짓말을 믿기 시작한 후에, 그 사람의 친한 친구들이 거짓말을 믿는 데에 걸리는 시간이 배열로 주어진다.
 * 이때, 단 한번의 거짓말로 원이의 모든 친구들이 거짓말을 믿게 되는 데에 걸리는 시간을 계산하시오.
 * 단, 한 번의 거짓말로 모든 친구가 거짓말을 믿게 할 수 없다면 -1을 반환하시오.
 *
 * 입력 :
 * N = 5
 * friend = {{1, 4}, {2, 3}, {4}, {1}, {0, 2}}
 * time = {{5, 2}, {6, 4}, {9}, {1}, {2, 6}}
 *
 * 결과 :
 * 9
 */

public class Num_16 {

    public static int solution(int N, int[][] friend, int[][] time) {
        // 거리 배열 초기화 (INF로 설정)
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // 시작점은 0

        // 우선순위 큐 (시간, 노드) - 시간 기준 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0];
            int currentNode = current[1];

            // 이미 더 짧은 경로로 방문한 경우 스킵
            if (currentTime > dist[currentNode]) {
                continue;
            }

            // 현재 노드의 친구들에게 거짓말 전파
            for (int i = 0; i < friend[currentNode].length; i++) {
                int nextNode = friend[currentNode][i];
                int nextTime = currentTime + time[currentNode][i];

                // 더 짧은 시간으로 도달 가능한 경우 업데이트
                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.offer(new int[]{nextTime, nextNode});
                }
            }
        }

        // 모든 친구가 거짓말을 믿는지 확인하고 최대 시간 반환
        int maxTime = 0;
        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // 도달할 수 없는 노드가 있음
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }

    public static void main(String[] args) {

    }
}
