package dev.timer.lineards_02.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice5 {

    public static Integer solution(int n, int k, int l, ArrayList<ArrayList> apples, Queue<ArrayList> moves) {
        int[][] board = new int[n + 1][n + 1];
        for (ArrayList item : apples) { // [3, 4] 같은 경우에 사과 위치가 3, 4이니까 3행 4열에 board 위치를 1로 설정
            board[(int) item.get(0)][(int) item.get(1)] = 1; // get(0) = 3, get(1) = 4
        }

        Queue<ArrayList> snake = new LinkedList<>();
        snake.add(new ArrayList(Arrays.asList(1, 1))); // 뱀의 머리 위치

        ArrayList<ArrayList> direction = new ArrayList<>();
        direction.add(new ArrayList(Arrays.asList(0, 1))); // 오른쪽
        direction.add(new ArrayList(Arrays.asList(1, 0))); // 아래쪽
        direction.add(new ArrayList(Arrays.asList(0, -1))); // 왼쪽
        direction.add(new ArrayList(Arrays.asList(-1, 0))); // 위쪽

        int dIdx = 0;
        int score = 0;
        int x = 1;
        int y = 1;

        while (true) {
            score += 1;
            x += (int) direction.get(dIdx).get(0);
            y += (int) direction.get(dIdx).get(1);

            if (1 <= x && x <= n && 1 <= y && y <= n) {
                ArrayList cur = new ArrayList(Arrays.asList(x, y));
                if (snake.contains(cur)) {
                    return score;
                }
                snake.add(cur);

                if (board[x][y] == 0) {
                    snake.poll();
                } else {
                    board[x][y] = 0;
                }
            } else {
                return score;
            }

            if (moves.size() > 0 && score == (int) moves.peek().get(0)) { // score는 몇초 지났는지의 정보, 그 정보와 moves에 정해놨는 시간초의 정보와 같다면 -> 방향 바꾸기
                if ((char) moves.peek().get(1) == 'D') {
                    dIdx = (dIdx + 1) % 4;
                    moves.poll();
                } else if ((char) moves.peek().get(1) == 'L') {
                    dIdx = (dIdx - 1) % 4;
                    moves.poll();
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test Code
        int n = 6;
        int k = 3;
        int l = 3;
        ArrayList<ArrayList> apples = new ArrayList<>();
        apples.add(new ArrayList<>(Arrays.asList(3, 4)));
        apples.add(new ArrayList<>(Arrays.asList(2, 5)));
        apples.add(new ArrayList<>(Arrays.asList(5, 3)));

        Queue<ArrayList> moves = new LinkedList<>();
        moves.add(new ArrayList(Arrays.asList(3, 'D')));
        moves.add(new ArrayList(Arrays.asList(15, 'L')));
        moves.add(new ArrayList(Arrays.asList(7, 'D')));
        System.out.println((solution(n, k, l, apples, moves)));
    }
}
