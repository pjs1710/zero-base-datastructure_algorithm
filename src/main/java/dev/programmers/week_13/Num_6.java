package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 레나는 영상처리의 기초적인 계산 중 하나인 주변 평균을 구현하려고 한다.
 * 주어진 2-D 배열 입력 image에 대해, K X K 주변 평균 이미지를 2-D 배열로 출력하시오. (단, 평균값은 내림하여 정수로 구하시오.)
 *
 * image = {{4 5 2 6 7}, {5 4 2 4 6}, {6 8 4 8 7}, {7 3 6 6 4}, {5 0 4 1 5}}
 * K = 3
 *
 * return = {{2 2 2 3 2}, {3 4 4 5 4}, {3 5 5 5 3}, {3 4 4 5 3}, {1 2 2 2 1}}
 */

public class Num_6 {

    public static int[][] solution(int[][] image, int K) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[rows][cols];

        int offset = K / 2; // K=3이면 offset=1, 중심에서 상하좌우 1칸씩

        // 각 위치에 대해 K×K 영역의 평균 계산
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int count = 0;

                // K×K 영역을 순회
                for (int di = -offset; di <= offset; di++) {
                    for (int dj = -offset; dj <= offset; dj++) {
                        int ni = i + di;
                        int nj = j + dj;

                        // 경계 체크: 범위 내에 있는 경우만 합계에 포함
                        if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                            sum += image[ni][nj];
                        }
                        // 경계 밖은 0으로 처리 (sum에 0을 더하므로 별도 처리 불필요)
                        count++; // 전체 K×K 개수로 나누어야 함
                    }
                }

                // 평균 계산 후 내림 (정수 나눗셈으로 자동 내림)
                result[i][j] = sum / count;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        // 테스트 케이스
        int[][] image = {
                {4, 5, 2, 6, 7},
                {5, 4, 2, 4, 6},
                {6, 8, 4, 8, 7},
                {7, 3, 6, 6, 4},
                {5, 0, 4, 1, 5}
        };
        int K = 3;

        int[][] result = solution(image, K);

        // 결과 출력
        System.out.println("결과:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        // 예상 결과와 비교
        int[][] expected = {
                {2, 2, 2, 3, 2},
                {3, 4, 4, 5, 4},
                {3, 5, 5, 5, 3},
                {3, 4, 4, 5, 3},
                {1, 2, 2, 2, 1}
        };

        System.out.println("\n예상 결과:");
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                System.out.print(expected[i][j] + " ");
            }
            System.out.println();
        }
    }
}
