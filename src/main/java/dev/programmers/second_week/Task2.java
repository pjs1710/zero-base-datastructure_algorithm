package dev.programmers.second_week;

import java.io.*;
import java.util.*;

/**
 * 6주차 문제 2번 :
 *
 * '제로 지니어스' 프로그램에서는 주어진 숫자를 이어붙여 가장 큰 수를 만드는 프로그램을 작성하는 미션이 주어졌다.
 *
 * 조건 :
 * - 0 또는 양의 정수가 numbers 배열로 주어진다.
 * - numbers 배열에 주어진 정수를 이어붙여 만들 수 있는 가장 큰 수를 출력한다.
 *
 * 예를 들어, 주어진 정수가 {6, 10, 2}라면 {6102, 6210, 1062, 1026, 2610, 2106}를 만들 수 있고, 이 중 가장 큰 수는 6210이다.
 * 위 미션을 수행하여 프로그램을 작성하시오. 단, 출력 정수 값이 너무 클 것을 대비하여 문자열로 출력하시오.
 *
 * 입력 :
 * numbers = {3, 30, 34, 5, 9}
 *
 * 결과 :
 * 9534330
 */

public class Task2 {

    //* 예상 풀이 solution : 문자로 이루어진 숫자를 정렬하면 3, 30, 34, 5, 9도 34가 먼저가 아니라 문자는 9가 큰 숫자로 취급.
    //* 예상되는 문제 : 3, 30, 34 같은 경우 34,3,30 순으로 출력되어야 함. 가장 높은 자릿수보다 커지는 경우는 해당 문자를 먼저 출력
    //* ex) 3, 30, 31, 32, 33 같은 경우 3 33 32 31 30 이렇게 출력되어야 함. ex) 3, 30, 31, 32, 33, 34 같은 경우 34 3 33 32 31 30 이렇게 출력
    public static String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums,
                (x, y) -> (y + x).compareTo(x + y)); // 람다식으로 문자열 정렬 표현하기
        // ex) 3, 34가 들어온 경우 3 + 34와 34 + 3을 비교해서 334, 343중 큰 값으로 정렬 -> 34, 3

        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        String result = solution(numbers);
        System.out.println(result);
    }
}
