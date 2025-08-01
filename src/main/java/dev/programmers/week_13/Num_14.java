package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 정수로 이루어진 리스트 arr에서 피크의 인덱스 peak를 다음과 같이 정의하자.
 * - 0 < peak < arr.length - 1
 * - x[peak - 1] < x[peak]
 * - x[peak + 1] < x[peak]
 * 주어진 리스트 arr에서 피크가 최대 한 개 존재할 때, 피크의 인덱스 peak를 출력하시오.
 * 단, 배열에 피크가 존재하지 않을 경우 -1을 출력하시오.
 *
 * arr = -3, 0, 3, 4, 5, 12, 15, 14, 12, 11
 *
 * return = 6
 */

public class Num_14 {

    public static int solution(int[] arr) {
        if (arr.length < 3) {
            return -1;
        }

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i-1] < arr[i] && arr[i+1] < arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] input = br.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        System.out.println(solution(arr));
    }
}
