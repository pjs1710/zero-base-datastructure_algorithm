package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 촘촘이는 연속된 숫자가 무작위 순서로 배치된 배열 numbers를 입력 받았다.
 * 이 배열에는 최소한 하나 이상 비어있는 숫자가 있으며, 배열에서 가장 작은 숫자는 알려져 있지 않다.
 * 배열에서 비어있는 숫자 중, 가장 작은 숫자를 출력하는 프로그램을 작성하시오.
 *
 * numbers = 9 4 2 3 7 5
 *
 * return = 6
 */

public class Num_4 {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int num : numbers) {
            set.add(num);
            if (num < min) min = num;
            if (num > max) max = num;
        }

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[st.countTokens()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(numbers));
    }
}