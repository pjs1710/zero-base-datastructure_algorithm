package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 7번 :
 *
 * 지난 해 한 국가에서는 N명이 세금을 납부했다. 세금을 관리하는 직원은 지난 해 사람들이 세금을 낸 정보를 수합하는 과정에서 K번의 정보 수집을 진행하고자 한다.
 * 각 정보 수집에는 X와 Y 두 가지 변수가 사용되는데, 이는 납부한 세금의 금액이 X이상 Y이하인 사람의 수를 계산하는 작업을 의미한다.
 * 각 K번의 정보 수집에 대하여, 납부한 세금의 금액이 X이상 Y이하인 사람의 수를 차례대로 계산하는 프로그램을 작성하여라.
 *
 * 입력 조건 :
 * 가장 먼저 세금을 낸 사람의 수 N과 정보 수집 횟수 K가 주어진다. 이때 N과 K는 모두 4이상 100,000이하의 자연수다.
 * 이어서 N명의 사람들이 낸 세금에 대한 정보가 담긴 배열 arr가 주어진다.
 * 이때, 각 사람이 납부한 세금의 금액은 1이상 1,000,000,000이하의 자연수다.
 * 이어서 K회의 정보 수집 작업에 대한 정보가 담긴 배열 queries가 주어진다.
 * 구체적으로 행의 크기가 N이고, 열의 크기가 2인 형태의 2차원 배열이다.
 * 각 정보 수집 작업에서의 X와 Y는 모두 1이상 1,000,000,000이하의 자연수로, 이때 X는 Y보다 작거나 같다.
 *
 * 출력 조건:
 * K번의 정보 수집에 대하여, 납부한 세금의 금액이 X이상 Y이하인 사람의 수를 차례대로 계산하여 1차원 배열 형태로 반환한다.
 */

public class Task7 {

    public static int[] solution(int N, int K, int[] arr, int[][] queries) {
        Arrays.sort(arr);
        int[] result = new int[K];

        for (int i = 0; i < K; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            int lower = lowerBound(arr, x);
            int upper = uppperBound(arr, y);

            result[i] = upper - lower;
        }

        return result;
    }

    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static int uppperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }
}
