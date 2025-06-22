package dev.programmers.third_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 7주차 문제 10번 :
 *
 * 두 친구는 각각 알파벳 소문자로 이루어진 문자열을 각각 준비한다. 이 두 문자열을 각각 x, y라고 한다.
 * 문자열 중 0개 이상의 문자를 제거하고, 기존 문자의 순서를 바꾸지 않고 만든 문자열을 부분 문자열이라고 하자. 예를 들면 abcde는 azzbzzczzdzzezz의 부분 문자열이다.
 * 이 때 각 문자열에서 만들 수 있는 모든 부분 문자열 중 가장 긴 부분 문자열의 길이가 두 사람의 궁합 수치라고 한다.
 * 예를 들어, x = abcdef, y = cdehig일 경우에 가장 긴 부분 문자열은 cde이고, 따라서 두 사람의 궁합 수치는 3이다.
 *
 * 주어진 x, y에 대해 궁합 수치를 출력하는 프로그램을 구현하시오.
 *
 *
 */

public class Task10 {

    static int N;
    static int M;
    static int[][] dp;

    public static int solution(String x, String y) {
        N = x.length();
        M = y.length();
        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[N][M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();
        String y = br.readLine();

        System.out.println(solution(x, y));
    }
}
