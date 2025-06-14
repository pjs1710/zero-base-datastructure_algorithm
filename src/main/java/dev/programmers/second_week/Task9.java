package dev.programmers.second_week;

import java.io.*;
import java.util.*;

/**
 * 6주차 문제 9번 :
 *
 * 당신은 수영장 건설의 전문가로, 구조물의 "높이 지도"를 보고 수영장을 채우는 데에 필요한 물의 양을 구하는 프로그램을 만들고자 한다.
 * 2차원 정수 배열 heights에는 숫자가 기록되어 있으며, 각 위치에는 정육면체 상자가 해당 숫자만큼 쌓여있다.
 * 정육면체 상자의 부피를 1이라 할 때, 해당 구조물에 물을 가둘 수 있는 공간의 부피를 구하시오.
 *
 * 입력 :
 * heights = {{3, 4, 5, 4, 3, 3},
 *            {3, 2, 1, 1, 2, 3},
 *            {4, 2, 1, 1, 2, 3},
 *            {3, 3, 3, 3, 5, 3}}
 *
 * 출력 :
 * 12
 *
 * 물을 가둘 수 있는 공간은 1, 2, 2, 1 - 1, 2, 2, 1 이렇게 총 12이다.
 */

public class Task9 {

    // 방향 설정
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static int solution(int[][] heights) {
        int N = heights.length;
        int M = heights[0].length;
        int[][] pool = new int[N][M]; // 수영장 배열
        int maxHeight = Integer.MIN_VALUE;

        if (N <= 2 || M <= 2) { // 가둘 수 있는 수영장이 아닌 경우니까 0 반환하도록 하기 (기본적으로 2X2 구조보다는 넓어야됨)
            return 0;
        }

        for (int[] arr : heights) {
            for (int value : arr) {
                maxHeight = Math.max(maxHeight, value); // 가장 큰 높이 찾기
            }
        }

        for (int i = 0; i < N; i++) Arrays.fill(pool[i], maxHeight);

        // 외곽 pool을 heights로 맞춰줌
        for (int i = 0; i < N; i++) {
            pool[i][0] = heights[i][0];
            pool[i][M - 1] = heights[i][M - 1];
        }
        for (int i = 0; i < M; i++) {
            pool[0][i] = heights[0][i];
            pool[N - 1][i] = heights[N - 1][i];
        }

        while (true) {
            boolean updated = false;
            for (int x = 1; x < N - 1; x++) {
                for (int y = 1; y < M - 1; y++) {
                    int minAround = pool[x][y];
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                            continue;
                        }

                        minAround = Math.min(minAround, pool[nx][ny]);
                    }
                    int newValue = Math.max(heights[x][y], minAround);
                    if (pool[x][y] > newValue) {
                        pool[x][y] = newValue;
                        updated = true;
                    }
                }
            }
            if (!updated) {
                break;
            }
        }

        int sum = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (pool[i][j] > heights[i][j])
                    sum += (pool[i][j] - heights[i][j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int col = Integer.parseInt(br.readLine());
        int row = Integer.parseInt(br.readLine());
        int[][] heights = new int[col][row];
        for (int i = 0; i < col; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < row; j++) {
                heights[i][j] = Integer.parseInt(data[j]);
            }
        }

        int result = solution(heights);
        System.out.println(result);
    }
}

/**
 *
 * ### 1. 입력 및 초기화
 * - **N, M**: 높이 행렬의 행, 열 개수.
 * - **heights 배열**: 각 칸에 쌓여있는 정육면체(=높이) 수.
 * - **pool 배열**: 해당 칸에 최대로 채울 수 있는 “수면 높이”값.
 * (처음엔 모든 칸을 지도 내 최댓값으로 채움)
 * - **maxHeight**: 전체 구조물에서 제일 높은 칸(가장 높은 담장이 물을 가둘 수 있는 최대 수면이므로)
 *
 * ### 2. 외곽 초기화
 * - **pool 배열의 테두리(외곽) 부분**:
 * 테두리는 물이 흘러나가기 때문에,
 * 최대로 채울 수 있는 물의 높이(pool)는 높이 그대로(heights)로 설정.
 *
 * ### 3. 내부 수면 높이 전파 (while 반복)
 * - 내부 칸(1~N-2, 1~M-2)을 훑으면서,
 *     - **상하좌우(pool[주변]) 중 가장 낮은 값**이 이 칸의 실제 가둘 수 있는 최대 물높이!
 *     - '내려줄 수 있으면'(즉, pool값이 주변들과 비교해서 너무 높으면) 줄여줌.
 *     - 최소값이 heights보다 작을 수 있으니, heights 이상으로 유지.
 *
 * - 한 바퀴에서 정보가 바뀌었다면 updated = true로 표기.
 * - 더 이상 변화가 없을 때 반복을 멈춤.
 *
 * ### 4. 갇힌 물 부피 계산
 * - pool에서 heights를 빼면, 그 칸에 머무는 물의 부피.
 * - 전체 내부 칸(테두리 제외) 합산.
 *
 */
