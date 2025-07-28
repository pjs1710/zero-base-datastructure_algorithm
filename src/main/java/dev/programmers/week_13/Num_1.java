package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * n보다 작은 소수의 개수를 세 주는 프로그램 개발
 *
 * n = 15
 *
 * return = 6
 *
 * 2, 3, 5, 7, 11, 13
 */

public class Num_1 {

    static int N;
    static int count = 0;

    public static int solution(int n) {
        for (int i = 2; i < n; i++) {
            int primeCnt = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    primeCnt++;
                }
            }

            if (primeCnt == 2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }
}
