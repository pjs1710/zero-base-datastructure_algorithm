package dev.timer.basicmath;

public class Practice5 {

    public static int solution(int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int cnt = 0;

        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d : directions) {
                        int x = i + d[0];
                        int y = j + d[1];

                        if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0) { // 경계를 확인했을 때 4방향이 바운더리 끝이거나, 물의 영역이면 +1
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    // 재귀 풀이
    public static int solution2(int[][] grid) {
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return recursion(grid, directions, i, j);
                }
            }
        }

        return 0;
    }

    public static int recursion(int[][] grid, int[][] directions, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        grid[i][j] = -1; // 방문한 곳은 -1로 바꿔줌
        int cnt = 0;
        for (int[] d : directions) {
            int x = i + d[0];
            int y = j + d[1];

            if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == 0) { // 경계를 확인했을 때 4방향이 바운더리 끝이거나, 물의 영역이면 +1
                cnt++;
            } else {
                if (grid[x][y] == 1) {
                    cnt += recursion(grid, directions, x, y);
                }
            }
        }

        return cnt;
    }


    public static void main(String[] args) {

        //Test code
        int[][] grid = {{1}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
        System.out.println();

        grid = new int[][] {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(solution(grid));
        System.out.println(solution2(grid));
    }
}
