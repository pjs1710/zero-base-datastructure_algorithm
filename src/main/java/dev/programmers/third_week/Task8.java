package dev.programmers.third_week;

/**
 * 7주차 문제 8번 :
 *
 * N X N 크기의 보드 판에 주인공 1명, 기사 2명이 존재하며, 적군은 최소한 1명 이상 존재한다.
 * 주인공의 위치는 "H", 기사의 위치는 "K", 적군의 위치는 "E"로 표시된다. 또한 빈 공간은 "B", 벽은 "X"로 표시된다. 한 위치에 여러 명이 존재하지 않는다.
 * 주인공은 움직일 수 없으며, 기사는 원한다면 체스 말처럼 현재 위치에서 8가지 위치 중 하나로 이동할 수 있다.
 * 예를 들어 (행, 열)의 형태로 각 위치를 나타낸다고 가정하자. 행과 열의 인덱스가 0부터 시작한다고 하면, (3, 3)의 위치에서 이동이 가능한 위치는
 * (1,2), (1,4), (2,1), (2,5), (4,1), (4,5), (5,2), (5,4)이다.
 * 2명의 기사는 처음 놓인 위치에 가만히 있는 것도 가능하며, 각자 빈 공간 혹은 적군이 있는 위치로 최대 1회 움직일 수 있다. 단, 벽이 있는 위치로는 이동할 수 없다.
 * 적군이 있는 위치로 이동하게 되면, 적군은 제거되고, 그 위치를 기사가 차지한다. 특정한 기사는 최대 1회 이동을 수행하면 더 이상 움직일 수 없으며, 두 기사의 이동이 모두 끝나고 나면 적군의 이동이 시작된다.
 * 기사 및 적군의 이동 과정에서 한 위치에 여러 명이 존재할 수 없다.
 * 각 적군은 매 초마다 현재 위치에서 상,하,좌,우로 이동할 수 있다. 기사 혹은 벽이 존재하는 위치로는 이동할 수 없으며, 주인공이 위치한 곳까지 도달하면 전체 과정이 종료된다.
 *
 * 2명의 기사를 적절히 활용하여 가장 가까운 적군이 주인공에 도달하기 위한 시간을 최대화하는 것이 목표다.
 * 목표에 맞게 2명의 기사를 적절히 활용했을 때, 가장 가까운 적군이 주인공에 도달하기 위한 최소 시간을 출력하는 프로그램을 작성하여라.
 * 적군이 도달 불가능하게 만들 수 있다면 0을 출력. 항상 행과 열의 인덱스는 0부터 시작.
 *
 * 입력 :
 * N = 5
 * board = [["B", "K", "B", "B", "B"], ["B", "K", "E", "E", "B"], ["B", "B", "E", "X", "B"], ["B", "B", "X", "X", "B"], ["H", "B", "X", "B", "E"]]
 *
 * 결과 :
 * 7
 */

import java.io.*;
import java.util.*;

public class Task8 {

    static int[] enemyDx = {-1, 1, 0, 0};
    static int[] enemyDy = {0, 0, -1, 1};
    static int[] knightDx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] knightDy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static int solution(int N, String[][] board) {
        List<int[]> knights = new ArrayList<>();
        List<int[]> enemies = new ArrayList<>();
        int[] hero;
        int minTime = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j].equals("K")) {
                    knights.add(new int[]{i, j});
                } else if (board[i][j].equals("E")) {
                    enemies.add(new int[]{i, j});
                } else {
                    hero = new int[]{i, j};
                }
            }
        }

        return minTime;
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

        System.out.println(solution(N, board));
    }
}
