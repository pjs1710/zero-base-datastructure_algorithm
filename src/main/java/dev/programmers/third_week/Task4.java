package dev.programmers.third_week;

/**
 * 7주차 문제 4번 :
 *
 * 하나의 게임이 존재하며, 이 게임을 플레이하면 플레이 결과로 점수를 얻게 된다.
 * 해당 게임을 N명의 학생이 플레이하여 각각 점수를 얻었다.
 * 이 때 각 학생이 얻은 점수는 모두 1 이상 10,000,000 이하의 자연수다.
 * 우리는 게임을 플레이 한 N명의 학생들의 실력 격차가 전반적으로 얼마나 큰지 궁금하다.
 * 따라서 실력 격차에 대한 지표로, 모든 학생들이 얻은 점수 중에서 가장 큰 점수와 가장 작은 점수의 차이를 반환하는 프로그램을 작성하여라.
 *
 * 입력 :
 * N = 8
 * scores = 7 7 5 8 9 4 6 2
 *
 * 결과 :
 * 7
 */

import java.io.*;
import java.util.*;

public class Task4 {

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static int solution(int N, int[] scores) {
        for (int i = 0; i < N; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
            if (scores[i] < min) {
                min = scores[i];
            }
        }
        return max - min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < data.length; i++) {
            scores[i] = Integer.parseInt(data[i]);
        }

        System.out.println(solution(N, scores));
    }
}
