package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 4번 :
 *
 * 벽 피하기 게임에서는 N X M 크기의 격자가 주어진다. 격자의 각 칸에 대하여 0은 빈칸, 1은 벽, 2는 플레이어의 위치를 의미한다. 플레이어는 1명이다.
 * 플레이어는 초기에 항상 가장 아래 행(줄)의 한 위치에 존재한다. 플레이어는 매 번 (1)가만히 있거나, (2)왼쪽으로 한 칸 이동하거나, 혹은 (3)오른쪽으로 한 칸 이동할 수 있다.
 * 플레이어가 이동한 뒤에는 위에서부터 존재하는 모든 벽이 한 칸씩 아래로 내려온다.
 *
 * 구체적으로 1초동안 *1* 초기 플레이어가 먼저 행동하고, *2* 이후에 모든 벽에 해당하는 칸이 한 칸씩 아래로 내려온다.
 * 플레이어가 벽에 부딪힌다면 즉시 게임이 종료되며, 부딪히지 않은 경우 플레이어가 생존한 시기가 1초만큼 증가하는 것으로 간주한다.
 * 벽이 내려온 직후에 플레이어가 살아남았을 경우 1초만큼 생존한 시간이 증가한 것으로 간주하기 때문에, 만약 처음부터 플레이어가 존재하는 위치의 윗줄의 칸들이 모두 벽으로 막혀있다면 0초를 출력해야 한다.
 * 플레이어는 벽 피하기 게임으로부터 최대한 오랜 시간을 버티는 것이 목표다. 전체 행(줄)의 수가 최대 N이라는 점에서 최대로 버틸 수 있는 시간은 N - 1초이다.
 * 결과적으로 플레이어가 최적의 움직임을 보인다고 했을 때, 플레이어가 생존 가능한 최대 시간을 계산하는 프로그램을 작성하여라.
 *
 * 입력 조건 :
 * 가장 먼저 벽 피하기 게임을 진행할 보드 판에 대한 크기 정보 N과 M이 주어진다.
 * N과 M은 3보다 크거나 같고 100보다 작거나 같은 자연수다.
 * 이어서 벽 피하기 게임을 진행할 보드 판에 대한 정보가 담긴 N X M 크기의 2차원 배열 board가 주어진다.
 * 격자의 각 칸에 대하여 0은 빈 칸, 1은 벽, 2는 플레이어의 초기 위치를 의미한다.
 * 플레이어는 항상 1명이며, 플레이어는 초기에 가장 아래 행(줄)의 한 위치에 존재한다.
 *
 * 출력 조건 :
 * 플레이어가 최선의 선택을 함으로써 생존 가능한 최대 시간을 반환한다.
 */

public class Task4 {

    static final int[] dir = {0, -1, 1};

    public static int solution(int N, int M, int[][] board) {
        int start = -1;
        for (int i = 0; i < M; i++) {
            if (board[N - 1][i] == 2) {
                start = i;
                board[N - 1][i] = 0;
                break;
            }
        }

        List<boolean[][]> wall = new ArrayList<>();
        boolean[][] init = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                init[i][j] = board[i][j] == 1;
            }
        }
        wall.add(init);

        for (int i = 1; i < N; i++) {
            boolean[][] prev = wall.get(i - 1);
            boolean[][] next = new boolean[N][M];

            for (int j = 0; j < N - 1; j++) {
                for (int k = 0; k < M; k++) {
                    next[j + 1][k] = prev[j][k];
                }
            }
            wall.add(next);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][N];
        queue.offer(new int[]{N - 1, start, 0});
        visited[N - 1][start][0] = true;

        int max = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];

            if (t >= N - 1) {
                return N - 1;
            }

            boolean[][] now = wall.get(t);
            boolean[][] next = wall.get(Math.min(t + 1, N - 1));
            if (now[r][c]) {
                continue;
            }

            max = Math.max(max, t);

            for (int i = 0; i < 3; i++) {
                int n_c = c + dir[i];
                int n_r = (i == 0) ? r : r - 1;
                if (n_c < 0 || n_r < 0 || n_c >= M) {
                    continue;
                }
                if (next[n_r][n_c]) {
                    continue;
                }
                if (i == 0 && next[r][c]) {
                    continue;
                }
                if (!visited[n_r][n_c][t + 1]) {
                    visited[n_r][n_c][t + 1] = true;
                    queue.offer(new int[]{n_r, n_c, t + 1});
                }
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(data[j]);
            }
        }

        System.out.println(solution(N, M, board));
    }
}
