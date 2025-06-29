package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 9번 :
 *
 * N X N 보드 판 형태뢔 산이 존재하며, 여행가는 등산을 하고자 한다.
 * 여행가의 위치는 초기에 (1, 1)로 가장 왼쪽 위의 칸에 서 있으며, 결과적으로 가장 오른쪽 아래의 위치인 (N, N)의 위치로 이동하는 것이 목표다.
 * 보드 판의 각 위치는 0이상 100이하의 정수로 표현되는데, 이것은 해당 위치의 고도(높이)를 의미한다.
 * 시작 위치에는 해당하는 (1, 1)위치의 고도(높이)값은 항상 0이며, 도착 위치인 (N, N)까지 최소한의 체력을 소모하여 이동하는 것이 목표다.
 * 여행가는 자신의 위치에서 인접한 상, 하, 좌, 우 위치로 이동이 가능하다.
 * 여행가는 산을 벗어나지만 않는다면 현재 위치에서 인접한 위치(상, 하, 좌, 우)로 이동이 가능하다.
 * 이때 현재 위치에서 인접한 위치 중 하나를 골라 다음 위치로 이동할 때, 고도가 다르더라도 이동이 가능하다.
 * 단, 현재 위치와 이동할 인접 위치의 높이(고도)가 다르다면, 이동하기 위해 고도의 차이만큼 체력이 소모된다.
 * 반면에 고도가 동일하다면 체력은 소모되지 않는다.
 * 여행가가 (1, 1)의 위치에서 (N, N)의 위치로 이동하기 위한 체력 소모량의 최소 값을 계산하는 프로그램을 작성하여라.
 *
 * 입력 조건 :
 * 가장 먼저 전체 공간의 크기 N이 주어진다. N은 300보다 작거나 같은 자연수다.
 * 이어서 보드 판 형태의 산의 각 위치에 대한 고도(높이) 정보가 담긴 N X N 크기의 배열 arr이 주어진다.
 * 각 위치의 고도 값은 0이상 100이하의 정수이다.
 * 시작 위치에 해당하는 (1, 1) 위치의 고도(높이)값은 항상 0이다.
 *
 * 촐력 조건 :
 * 여행가가 (1, 1)의 위치에서 (N, N)의 위치로 이동하기 위한 최소 체력 소모량을 반환한다.
 */

public class Task9 {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    static class Node {
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static int solution(int N, int[][] arr) {
        int[][] dist = new int[N][N];
        for (int[] item : dist) {
            Arrays.fill(item, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        pq.offer(new Node(0, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.x == N - 1 && cur.y == N - 1) {
                return cur.cost;
            }

            if (cur.cost > dist[cur.x][cur.y]) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                int heightDiff = Math.abs(arr[cur.x][cur.y] - arr[nx][ny]);
                int newCost = cur.cost + heightDiff;

                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    pq.offer(new Node(nx, ny, newCost));
                }
            }
        }

        return dist[N - 1][N - 1];
    }

    public static void main(String[] args) {

    }
}
