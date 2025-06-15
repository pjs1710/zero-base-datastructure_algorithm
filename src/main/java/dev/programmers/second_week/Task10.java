package dev.programmers.second_week;

import java.io.*;
import java.util.*;

/**
 * 6주차 문제 10번 :
 *
 * 두 명의 플레이어가 경쟁하는 게임이 있다.
 * 이 게임은 시작할 때 여러 개의 돌을 내려 놓는다. 각 돌은 두 플레이어에게 서로 다른 가치를 가진다.
 * i번째 돌이 각 플레이어에게 주는 가치는 value[i][0], value[i][1]에 양의 정수로 주어진다.
 * 첫번째 플레이어부터 순서대로 돌아가면서 하나씩 돌을 선택하여 가져가며, 최종 점수는 각 플레이어의 돌의 가치의 합이다.
 * 각 플레이어는 양 플레이어에게 주는 돌의 가치를 모두 알고 있고, 최선의 선택을 한ㄷ다고 하자.
 * 이 때 경기가 끝날 때 그 결과를 1(첫번째 플레이어 승리), 0(동점), -1(두번째 플레이어 승리) 출력하시오.
 *
 * 입력 :
 * 5 3
 * 6 9
 * 4 5
 * 6 3
 * 2 8
 * 5 4
 *
 * 결과 :
 * 1
 *
 */

public class Task10 {

    public static int solution(int[][] value) {
        // value[i][0] + [i][1] 계산한 값이 큰 순서대로 출력 -> 내림차순 정렬
        Integer[] sumArr = new Integer[value.length];
        for (int i = 0; i < sumArr.length; i++) {
            sumArr[i] = i;
        }
        Arrays.sort(sumArr, (x, y) ->
                (value[y][0] + value[y][1]) - (value[x][0] + value[x][1]));

        int firstPlayerSum = 0;
        int secondPlayerSum = 0;
        for (int i = 0; i < sumArr.length; i++) {
            int idx = sumArr[i];
            if (i % 2 == 0) { // 0, 2, 4, ... 이렇게는 첫번째가 먼저 가져감
                firstPlayerSum += value[idx][0];
            } else {
                secondPlayerSum += value[idx][1];
            }
        }

        if (firstPlayerSum > secondPlayerSum) {
            return 1;
        } else if (firstPlayerSum < secondPlayerSum) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] valueData = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] values = br.readLine().split(" ");
            valueData[i][0] = Integer.parseInt(values[0]);
            valueData[i][1] = Integer.parseInt(values[1]);
        }
        System.out.println(solution(valueData));
    }
}
