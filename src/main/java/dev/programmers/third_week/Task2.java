package dev.programmers.third_week;

/**
 * 7주차 문제 2번 :
 *
 * 3-반전 스위치
 * 3-반전 스위치는 한 버튼을 누르면, 그 버튼을 포함해 양 옆의 상태 값이 변화하는 방식이다.
 * 예를 들어, {1, 1, 0, 1, 1, 1} 상태에서 두 번째 버튼을 누르면, {0, 0, 1, 1, 1, 1}로 변화하는 식이다.
 * 가장 좌측이나 우측 버튼을 누를 경우, 두 개의 상태만 변화한다.
 * 현재 상태가 정수 배열 status로 주어졌을 때, 3-반전 스위치를 여러번 눌러 모든 상태 값을 1로 바꾸려고 한다.
 * 이 때, 최소로 버튼을 눌러야 하는 횟수를 구하시오. 단, 모든 상태 값을 1로 바꿀 수 없으면 -1을 반환하시오.
 *
 * 입력 :
 * {1, 1, 0, 1, 0, 1}
 *
 * 출력 :
 * 3
 */

import java.io.*;
import java.util.*;

public class Task2 {

    static int min = Integer.MAX_VALUE;

    public static int solution(int[] status) {
        int N = status.length;

        for (int i = 0; i < 2; i++) {
            int[] tmp = status.clone();
            int cnt = 0;

            //* TODO : 왼쪽 0번째 버튼 누르는 경우 && 나머지 경우 확인

            if (i == 1) {
                press(tmp, 0);
                cnt++;
            }

            for (int j = 1; j < N; j++) {
                if (tmp[j - 1] == 0) {
                    press(tmp, j);
                    cnt++;
                }
            }

            boolean allOne = true;
            for (int j = 0; j < N; j++) {
                if (tmp[j] != 1) {
                    allOne = false;
                    break;
                }
            }

            if (allOne) {
                min = Math.min(min, cnt);
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }

    public static void press(int[] tmp, int idx) {
        if (idx - 1 >= 0) { // 왼쪽
            tmp[idx - 1] = 1 - tmp[idx - 1]; // 0, 1 바꿔주기
        }

        tmp[idx] = 1 - tmp[idx]; // 자기 자신

        if (idx + 1 < tmp.length) { // 오른쪽
            tmp[idx + 1] = 1 - tmp[idx + 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int[] status = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            status[i] = Integer.parseInt(data[i]);
        }

        System.out.println(solution(status));
    }
}
