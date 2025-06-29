package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 8번 :
 *
 * 현재 미용실에서 커트를 받고 싶은 사람의 수가 N명이다. N명의 사람들은 각각 초단위로 예약을 진행했다고 가정하자.
 * 각 사람이 예약한 커트 시간은 시작 시각(start)과 종료 시각(end)으로 표시된다.
 * 이를 배열로 나타낸다면 [start, end] 형태(원소가 2개인 1차원 배열)로 이해할 수 있을 것이다.
 * 이때, 하루는 86,400초이므로, 시작 시각(start)은 0이상 86,399이하의 정수로 주어진다.
 * 또한 미용사는 동시에 여러 명의 손님에 대하여 커트를 진행할 수 없다. 예를 들어 예약 시간이 [3000, 6000]인 손님과 [4000, 7000]인 손님 두 명이 있을 때, 두 손님을 모두 받는 것은 불가능하다.
 * 또한, 손님들의 미용실 입장 시간 및 대기 시간은 0초라고 가정하자.
 * 이때, 1명의 미용사가 받을 수 있는 손님의 수의 최대값을 계산하는 프로그램을 작성하여라.
 *
 * 입력 조건 :
 * 가장 먼저 예약자 수 N이 자연수로 주어진다.(N은 100,000보다 작거나 같은 자연수다.)
 * 이어서 각 예약자가 원하는 커트 시간 정보가 담긴 배열 reserved가 주어진다.
 * 배열은 행의 크기가 N이고, 열의 크기가 2인 형태의 2차원 배열이다.
 * 각 손님에 대한 예약 시간은 [start, end]형태로 주어진다.
 * 각 손님에 대해 start는 0이상 86,399이하의 정수이며, end는 start + 1이상 86,400이하의 정수이다.
 *
 * 출력 조건 :
 * 한 명의 미용사가 받을 수 있는 최대한 많은 손님의 수를 반환하여라.
 */

public class Task8 {

    public static int solution(int N, int[][] reserved) {
        Arrays.sort(reserved, Comparator.comparingInt(x -> x[1]));
        int cnt = 0;
        int lastEnd = -1;

        for (int[] item : reserved) {
            int start = item[0];
            int end = item[1];

            if (start >= lastEnd) {
                cnt++;
                lastEnd = end;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

    }
}
