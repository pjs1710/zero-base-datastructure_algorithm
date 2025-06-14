package dev.programmers.second_week;

import java.io.*;
import java.util.*;

/**
 * 6주차 문제 7번 :
 *
 * 자연수 n이 주어집니다.
 * 이때, 1 이상 n 이하의 자연수 중 연속된 정수의 합이 'n'과 같은 경우의 수를 구하는 프로그램을 구현하세요.
 *
 * 입력 :
 * n = 15
 *
 * 출력 :
 * 4
 *
 * 설명 :
 * 15, 7 + 8, 4 + 5 + 6, 1 + 2 + 3 + 4 + 5 : 4가지
 */

public class Task7 {

    public static int solution(int n) {
        int cnt = 0;

        for (int i = 1; (i * (i - 1)) / 2 < n; i++) {
            int remain = n - (i * (i - 1)) / 2;
            if (remain % i == 0) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(Integer.parseInt(br.readLine())));
    }
}
