package dev.timer.nonlineards_03.practice;

public class Practice1 {

    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 오른쪽, 왼쪽, 아래쪽, 위쪽

    public static boolean solution(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, int x, int y, int i, String word) {
        int row = board.length;
        int col = board[0].length;
        if (i == word.length()) {
            return true;
        }

        if (x < 0 || x >= row || y < 0 || y >= col) { // board의 범위를 벗어나는 경우
            return false;
        }

        if (visited[x][y]) { // 이미 방문한 배열인 경우
            return false;
        }

        if (board[x][y] != word.charAt(i)) {
            return false;
        }

        visited[x][y] = true;
        for (int[] dir : dirs) {
            int xNext = x + dir[0];
            int yNext = y + dir[1];

            if (dfs(board, visited, xNext, yNext, i + 1, word)) {
                return true;
            }
        }
        visited[x][y] = false;

        return false;
    }

    public static void main(String[] args) {
        // Test Code
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        System.out.println(solution(board, "ABCCED")); // true
        System.out.println(solution(board, "SEE")); // true
        System.out.println(solution(board, "ABCB")); // false
    }
}
