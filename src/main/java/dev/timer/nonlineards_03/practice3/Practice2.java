package dev.timer.nonlineards_03.practice3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Practice2 {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static class room {
        int x;
        int y;

        public room(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int solution(int n, int[][] switches) {
        if (switches == null || switches.length == 0 || switches[0].length == 0) {
            return -1;
        }

        ArrayList<room>[][] graph = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < switches.length; i++) {
            graph[switches[i][0] - 1][switches[i][1] - 1].add(new room(switches[i][2] - 1, switches[i][3] - 1));
        }

        boolean[][] switched = new boolean[n][n];
        switched[0][0] = true;

        int cnt = bfs(n, graph, switched);

        return cnt + 1;
    }

    public static int bfs(int n, ArrayList<room>[][] graph, boolean[][] switched) {
        Queue<room> queue = new LinkedList<>();
        queue.offer(new room(0, 0));

        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            room cur = queue.poll();

            for (room r : graph[cur.x][cur.y]) {
                if (!switched[r.x][r.y]) {
                    switched[r.x][r.y] = true;
                    cnt++;
                }
            }

            for (int[] dir : dirs) {
                int xNext = cur.x + dir[0];
                int yNext = cur.y + dir[1];

                if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < n) {
                    if (switched[xNext][yNext] && !visited[xNext][yNext]) {
                        queue.offer(new room(xNext, yNext));
                        visited[xNext][yNext] = true;
                    }
                }
            }
        }

        return cnt == 0 ? cnt : cnt + bfs(n, graph, switched);
    }

    public static void main(String[] args) {
        // Test Code
        int[][] switches = {{1, 1, 1, 2}, {2, 1, 2, 2}, {1, 1, 1, 3}, {2, 3, 3, 1}, {1, 3, 1, 2}, {1, 3, 2, 1}};
        System.out.println(solution(3, switches)); // 5
    }
}
