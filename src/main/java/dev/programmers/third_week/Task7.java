package dev.programmers.third_week;

/**
 * 7주차 문제 7번 :
 *
 * 한 명의 봉술가는 N X N 크기의 보드 판에서 다수의 그래플러와 싸워야 한다. 보드 판에서 빈 공간은 "B", 그래플러의 위치는 "G"로 표시되며, 한 위치에 여러 명이 존재할 수 없다.
 * 그래플러는 최소 2명 이상 주어지며, 초기 그래플러들은 서로 다른 칸에 위치해있다. 그래플러가 존재하지 않는 빈 칸(빈 공간)은 1개 이상 주어진다.
 *
 * 봉술가가 빈 칸 중에서 자신의 시작 위치를 선택하고 나면, 이어서 그래플러들의 이동이 시작된다. 각 그래플러는 매 초마다 현재 위치에서 상, 하, 좌, 우로 이동할 수 있으며,
 * 그래플러들의 이동 과정에서 한 위치에 여러 명이 존재할 수 없다.
 * 봉술가는 싸움이 시작되기 전에 최대한 그래플러들로부터 멀리 떨어지고 싶다.
 *
 * 결과적으로 봉술가가 시작 위치를 결정하기 위해, 빈 칸 중에서 가장 가까운 그래플러와의 거리가 최대가 되는 빈 칸을 계산하는 프로그램을 작성하여라.
 * 가장 가까운 그래플러와의 거리가 최대가 되는 빈 칸이 여러 곳이라면, 가장 낮은(작은) 번호의 행을 갖는 위치를 반환한다.
 * 만약 가장 낮은 번호의 행을 갖는 위치가 여러 개라면, 가장 낮은 번호의 열을 갖는 위치를 반환한다.
 *
 * 입력 :
 * N = 5
 * board = [["B", "B", "B", "B", "B"], ["B", "G", "B", "B", "B"], ["B", "B", "B", "G", "B"], ["B", "B", "B", "B", "B"], ["B", "B", "G", "B", "B"]]
 *
 * 출력 :
 * [0, 4]
 */

import java.io.*;
import java.util.*;

public class Task7 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int[] solution(int N, String[][] board) {
        int[][] dist = bfs(N, board);
        List<int[]> resultList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j].equals("B")) {
                    resultList.add(new int[]{i, j, dist[i][j]});
                }
            }
        }

        resultList.sort((x, y) -> {
            if (y[2] != x[2]) {
                return y[2] - x[2];
            }
            if (x[0] != y[0]) {
                return x[0] - y[0];
            }
            return x[1] - y[1];
        });

        int[] bestResult = resultList.getFirst();
        return new int[]{bestResult[0], bestResult[1]};
    }

    public static int[][] bfs(int N, String[][] board) {
        int[][] dist = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j].equals("G")) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                if (next_x >= 0 && next_y >= 0 &&
                        next_x < N && next_y < N && !visited[next_x][next_y]) {
                    visited[next_x][next_y] = true;
                    dist[next_x][next_y] = dist[x][y] + 1;
                    queue.offer(new int[]{next_x, next_y});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] board = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = data[j];
            }
        }

        int[] result = solution(N, board);
        System.out.println(Arrays.toString(result));
    }
}
