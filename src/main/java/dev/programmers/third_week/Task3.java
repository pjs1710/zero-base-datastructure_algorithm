package dev.programmers.third_week;

/**
 * 7주차 문제 3번 :
 *
 * 깃슬레이어는 총 N개의 보스로 이루어져 있다. 게이머는 보스를 잡는 순서를 마음대로 결정할 수 있으며, 각 보스를 물리치는 데에는 기본적으로 특정한 시간이 소요된다.
 * 보스를 물리치면 특수한 기술을 얻게 되는데, 이 기술은 바로 다음 보스와의 전투에서만 사용할 수 있으며 보스와의 전투 시간을 특정 시간만큼 줄여준다.
 * 이 기술은 바로 다음 보스에게만 사용할 수 있으며, 다른 보스에게는 사용할 수 없다.
 * 보스를 물리치는 데에는 소요되는 시간과 해당 보스를 물리쳤을 때 얻는 기술의 위력은 각각 정수 배열 boss, skill로 주어진다.
 * 갓게이머는 게임을 완료하는 데에 필요한 최소의 시간을 계산하는 프로그램을 제작하고자 한다.
 * 즉, 보스를 물리치는 순서를 달리하여 달성할 수 있는 최소의 게임 시간을 구하시오.
 *
 * 입력 :
 * N = 5
 * boss = 10 8 12 5 20
 * skill = 0 19 5 10 3
 *
 * 결과 :
 * 18
 */

import java.io.*;
import java.util.*;

public class Task3 {

    static int min = Integer.MAX_VALUE;

    public static int solution(int N, int[] boss, int[] skill) {
        boolean[] visited = new boolean[N];
        // 초기에는 잡은 보스가 없으니까 0마리, 이전 보스도 0으로 하면 안되니까 -1로 초기화
        dfs(0, -1, 0,N, boss, skill, visited);

        return min;
    }

    /**
     *
     * @param bossCnt : 잡은 보스의 수
     * @param prevBossIdx : 이전 보스의 인덱스
     * @param timeSum : 현재까지 걸린 시간
     * @param N
     * @param boss
     * @param skill
     * @param visited
     */
    public static void dfs(int bossCnt, int prevBossIdx, int timeSum, int N, int[] boss, int[] skill, boolean[] visited) {
        if (bossCnt == N) { // 보스 모두 잡으면 끝
            min = Math.min(timeSum, min);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) { // 방문하지 않은 곳이라면
                visited[i] = true; // 방문 체크 해주기
                int clearTime = boss[i];

                if (prevBossIdx != -1) { // 이전에 잡은 보스가 있다면
                    clearTime = Math.max(clearTime - skill[prevBossIdx], 0); // 직전에 잡은 보스의 스킬만큼 빼주기
                }
                // 처음 실행 후 다음 부터는 visited가 true 여서 i = 1, 2, ... 이런식으로 증가함
                dfs(bossCnt + 1, i, timeSum + clearTime, N, boss, skill, visited);
                visited[i] = false; // back tracking
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] boss = new int[N];
        int[] skill = new int[N];

        String[] data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            boss[i] = Integer.parseInt(data[i]);
        }

        String[] data2 = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            skill[i] = Integer.parseInt(data2[i]);
        }

        System.out.println(solution(N, boss, skill));
    }
}
