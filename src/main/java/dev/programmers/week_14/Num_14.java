package dev.programmers.week_14;

import java.util.*;

/**
 * 영재는 방이 N X M 그리드 형태로 연결된 미로에 갇혀있다. 각 방은 서로 문으로 연결되어 있으며, 어떤 방들은 문이 잠겨서 열리지 않는다.
 * 영재는 가장 왼쪽 상단에 위치한 방에서 출발하며, 출구가 있는 방은 가장 우측 하단에 위치한 방이다.
 * 출구를 열기 위해서는 미로에 단 1개 있는 열쇠를 찾은 후에 미로에 도달해야 한다.
 * 영재는 반드시 오른쪽 방이나 아래쪽 방으로만 이동할 수 있다.
 * 2차원 배열 maze에 평범한 방은 0, 열리지 않는 방은 1, 열쇠가 있는 방은 2로 기록되어 있다.
 * 이 때, maze에 대해서 탈출할 수 있는 방법의 수를 구하시오.
 * 단, 숫자가 너무 커질 수 있으므로 정답을 1007로 나눈 나머지를 반환하시오.
 */

public class Num_14 {

    public static int solution(int[][] maze) {
        int N = maze.length;
        int M = maze[0].length;
        final int MOD = 1007;

        int keyRow = -1, keyCol = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == 2) {
                    keyRow = i;
                    keyCol = j;
                    break;
                }
            }
            if (keyRow != -1) break;
        }

        int pathsToKey = calculatePaths(maze, 0, 0, keyRow, keyCol, MOD);
        int pathsToExit = calculatePaths(maze, keyRow, keyCol, N - 1, M - 1, MOD);

        return (int)((long)pathsToKey * pathsToExit % MOD);
    }

    public static int calculatePaths(int[][] maze, int startRow, int startCol, int endRow, int endCol, int MOD) {
        int rows = endRow - startRow + 1;
        int cols = endCol - startCol + 1;

        int[][] dp = new int[rows][cols];
        if (maze[startRow][startCol] != 1) {
            dp[0][0] = 1;
        }

        for (int j = 1; j < cols; j++) {
            if (maze[startRow][startCol + j] != 1) {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < rows; i++) {
            if (maze[startRow + i][startCol] != 1) {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (maze[startRow + i][startCol + j] != 1) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {

    }
}
