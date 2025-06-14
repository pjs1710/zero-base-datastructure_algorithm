package dev.programmers.second_week;

import java.io.*;
import java.util.*;

/**
 * 6주차 문제 6번 :
 *
 * 철수는 개발자에서 은퇴하여 치킨집을 하게 되었다. 철수는 뛰어난 개발 실력으로 N대의 자동 튀김기를 만들어냈다.
 * 각 튀김기는 양산에 들어가기 전, 프로토타입으로 만든 튀김기라 각각 동작 특성이 다르다.
 * i번째 자동 튀김기는 치킨을 한 번 튀기는 데에 fry[i] 만큼의 시간이 걸리며, 튀김이 한번 끝나면 clean[i]만큼의 시간동안 자동 세척을 한다.
 * 철수가 M번 치킨을 튀겨내려고 할 때, 최소한 몇 시간 동안 자동 튀김기를 가동해야 하는지 계산하시오.
 *
 * N = 2
 * M = 20
 * fry = {3, 6}
 * clean = {2, 1}
 *
 * 결과 :
 * 58
 */

public class Task6 {

    public static int solution(int N, int M, int[] fry, int[] clean) {
        int left = 0, right = 10000;
        int minTime = right;


        while (left <= right) {
            int mid = (left + right) / 2;
            int total = 0;

            for (int i = 0; i < N; i++) {
                int chickenSum = fry[i] + clean[i];
                total += mid / chickenSum;
            }

            if (total >= M) {
                minTime = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        List<Integer> resultTime = new ArrayList<>(M);
        for (int i = 0; i < N; i++) {
            int chickenSum = fry[i] + clean[i];
            for (int start = 0; ; start += chickenSum) {
                int end = start + fry[i];
                if (end > minTime) break;
                resultTime.add(end);
            }
        }

        Collections.sort(resultTime);
        return resultTime.get(M - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] fryData = br.readLine().split(" ");
        int[] fry = new int[N];

        String[] cleanData = br.readLine().split(" ");
        int[] clean = new int[N];

        for (int i = 0; i < N; i++) {
            fry[i] = Integer.parseInt(fryData[i]);
            clean[i] = Integer.parseInt(cleanData[i]);
        }

        int result = solution(N, M, fry, clean);
        System.out.println(result);
    }
}
