package dev.programmers.week_14;

import java.util.*;

/**
 * 당신은 신호처리 전문가로, 임베디드 머신에 들어갈 알고리즘을 의뢰받았다.
 * 의뢰받은 알고리즘은 '슬라이딩 윈도우 최댓값'으로, 연속된 k개의 값의 최댓값을 한 칸씩 이동하면서 구하는 기법이다.
 * 예를 들어, 주어진 입력이 아래와 같다고 하자.
 * arr = [4, 2, 6, 4, 2, 3]
 * 이 때, k = 3인 슬라이딩 윈도우와 그 최댓값은 아래와 같이 계산된다.
 * 4 2 6 4 2 3
 * 4 2 6 -> 6
 * 2 6 4 -> 6
 * 6 4 2 -> 6
 * 4 2 3 -> 4
 * 따라서 주어진 입력 arr에 대한 슬라이딩 윈도우 최댓값은 아래와 같다.
 * 6 6 6 4
 * 해당 알고리즘을 구현하시오.
 */

public class Num_4 {

    public static int[] solution(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || k > arr.length) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
