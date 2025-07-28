package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 총 학생은 N명, M개의 교실에 모든 학생과 감독관을 한 명씩 배치.
 * 교실에 학생이 배치되지 않을 수도 있고, 교실이 비어있더라도 감독관은 배치해야 한다.
 * 각 교실에 수용 가능한 최대 인원은 capacity 배열에 저장되어 있다. i번째 교실에 수용 가능한 최대 인원은 capacity[i]이다.
 * 모든 교실에 수용 가능한 최대 인원의 총 합은 수강생의 수보다 항상 많거나 같다. 즉, capacity 배열에 담긴 모든 수의 합은 N보다 크거나 같다.
 * 감독관은 총 K명이 있으며, 감독관의 수가 부족한 일은 없다. M <= K
 * 학생과 감독관을 교실에 배정하는 모든 경우의 수를 구하시오.
 *
 * N = 10
 * M = 3
 * K = 4
 * capacity = {3, 3, 4}
 *
 * return = 100800
 */

public class Num_3 {

    static int N;
    static int M;
    static int K;

    public static long solution(int N, int M, int K, int[] capacity) {
        long[] factorial = new long[N + 1];
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        long[] answer = new long[1];
        dfs(0, 0, N, M, capacity, new int[M], factorial, answer);

        long supervisorPerm = 1;
        for (int i = 0; i < M; i++) {
            supervisorPerm *= (K - i);
        }
        return answer[0] * supervisorPerm;
    }

    public static void dfs(int depth, int totalAssigned, int N, int M, int[] capacity,
                           int[] assigned, long[] factorial, long[] answer) {
        if (depth == M) {
            if (totalAssigned == N) {
                long denom = 1;
                for (int val : assigned) {
                    denom *= factorial[val];
                }
                long ways = factorial[N] / denom;
                answer[0] += ways;
            }
            return;
        }

        int maxStudents = capacity[depth];

        for (int i = 0; i <= maxStudents; i++) {
            if (totalAssigned + i <= N) {
                assigned[depth] = i;
                dfs(depth + 1, totalAssigned + i, N, M, capacity, assigned, factorial, answer);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        int[] capacity = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < capacity.length; i++) {
            capacity[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, K, capacity));
    }
}
