package dev.programmers.second_week;

import java.io.*;
import java.util.*;

/**
 * 6주차 과제 5번 :
 *
 * 마을에 1부터 N의 고유 번호를 가진 사람들이 있다. 소문으로는 마을 사람 중에 마을 판사가 있다고 한다. 마을 판사가 실제로 존재한다면,
 * - 마을 판사는 아무도 믿지 않는다.
 * - 다른 모든 사람들은 마을 판사를 믿는다.
 * - 마을 판사가 있다면 오직 한명 뿐이다.
 *
 * 2차원 배열 trust가 주어졌을 때, trust[i] = {a, b}는 고유 번호가 a인 사람이 고유 번호 b인 사람을 믿는다는 것을 의미한다.
 * 마을 판사가 존재한다면 마을 판사의 고유 번호를, 존재하지 않는다면 -1을 출력하는 프로그램을 작성하세요.
 * (단, a가 b를 믿고 b가 c를 믿는다고 했을 때, a가 c를 믿는다는 의미는 아니다.
 *
 * 입력 :
 * N = 3
 * trust = {{1, 3}, {2, 3}}
 *
 * 출력 :
 * 3
 */

public class Task5 {

    public static int solution(int N, int[][] trust) {
        if (trust.length == 0 || trust == null) {
            return -1;
        } else if (N == 1) {
            return 1;
        }

        Set<Integer> peopleSet = new HashSet<>(); // 누군가를 신뢰하는 사람 : 마을 사람
        HashMap<Integer, Integer> isJudge = new HashMap<>(); // 판사인지 판단할 HashMap 선언해서
        // 값을 추가한다음 해당 value가 N-1인지 확인하기 위한 HashMap

        for (int[] personToJudge : trust) {
            peopleSet.add(personToJudge[0]); // peopleSet에 trust[i][0]을 저장해놓기 -> 누군가를 신뢰하는 사람
            isJudge.put(personToJudge[1], isJudge.getOrDefault(personToJudge[1], 0) + 1); // trust[i][0]이 지목한
            // trust[i][1]을 isJudge에 저장하고, 추가로 계속 저장되면 +1 해주기
        }

        for (int i = 1; i <= N; i++) {
            if (!peopleSet.contains(i)) { // 1부터 N까지 돌았을 때 값이 없는 경우
                // 판사는 아무도 믿지 않기 때문에 값이 없는 경우는 판사임
                // 이 경우 판사의 신뢰 개수?가 N-1개여야 정확히 return
                if (isJudge.get(i) == N - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] trust = new int[M][2]; // a, b -> a가 b를 믿음

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");

            trust[i][0] = Integer.parseInt(input[0]);
            trust[i][1] = Integer.parseInt(input[1]);
        }

        int result = solution(N, trust);
        System.out.println(result);
    }
}
