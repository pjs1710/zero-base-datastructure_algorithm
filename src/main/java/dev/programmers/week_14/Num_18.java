package dev.programmers.week_14;

import java.util.*;

/**
 * 당신은 좀비 바이러스 치료제를 단 하나 가지고 있다.
 * 이번에 매우 전염성이 높은 좀비 바이러스가 퍼져, 긴급히 방역이 필요한 상황이다.
 * 총 N명의 인원이 관리 대상으로, i번째 인원과 j번째 인원이 서로 가까이 있어 감염시킬수 있는 경우 graph[i][j]가 1로 주어진다.
 * 서로 가까이 있는 인원 중에 한 명이라도 감염된 인원이 있다면, 결국 모두 서로를 감염시키게 된다.
 * 현재 좀비 바이러스에 감염된 인원은 infected 배열에 주어진다.
 * 당신은 치료제가 단 하나 있기 때문에, infected의 인원 중 한 명을 치료할 수 있다.
 * 이 때, 어떤 인원을 치료해야 좀비 바이러스에 감염되는 인원을 최소화할 수 있는지 해당 인원의 인덱스를 출력하시오.
 * 단, 정답이 여럿인 경우 더 작은 인덱스를 출력하시오.
 *
 * 입력 :
 * N = 3
 * graph = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}
 * infected = {0, 2}
 *
 * 결과 :
 * 0
 */

public class Num_18 {

    public static int solution(int N, int[][] graph, int[] infected) {
        int minInfected = Integer.MAX_VALUE;
        int bestChoice = Integer.MAX_VALUE;

        // 각 감염된 인원을 치료하는 경우를 시뮬레이션
        for (int treatTarget : infected) {
            // 치료 대상을 제외한 나머지 감염된 인원들로 감염 시뮬레이션
            Set<Integer> remainingInfected = new HashSet<>();
            for (int person : infected) {
                if (person != treatTarget) {
                    remainingInfected.add(person);
                }
            }

            // 감염 확산 시뮬레이션
            boolean[] isInfected = new boolean[N];

            // 남은 감염자들을 시작점으로 BFS 실행
            Queue<Integer> queue = new LinkedList<>();
            for (int person : remainingInfected) {
                if (!isInfected[person]) {
                    isInfected[person] = true;
                    queue.offer(person);
                }
            }

            // BFS로 감염 확산
            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int i = 0; i < N; i++) {
                    if (graph[current][i] == 1 && !isInfected[i] && i != treatTarget) {
                        isInfected[i] = true;
                        queue.offer(i);
                    }
                }
            }

            // 최종 감염자 수 계산
            int totalInfected = 0;
            for (int i = 0; i < N; i++) {
                if (isInfected[i]) {
                    totalInfected++;
                }
            }

            // 최소 감염자 수 업데이트 (같은 경우 더 작은 인덱스 선택)
            if (totalInfected < minInfected ||
                    (totalInfected == minInfected && treatTarget < bestChoice)) {
                minInfected = totalInfected;
                bestChoice = treatTarget;
            }
        }

        return bestChoice;
    }

    public static void main(String[] args) {

    }
}
