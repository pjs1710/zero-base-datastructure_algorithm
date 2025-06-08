package dev.programmers.first_week;

import java.io.*;
import java.util.*;

/**
 * 5주차 문제 3번 :
 *
 * 컴퓨터는 정수를 표현할 때, 자료형에 따라 표현 가능한 숫자의 범위가 정해져있다. 기산이는 어리한 한계를 해결하고자, 숫자를 배열로 표현하기로 하였다.
 * 기산이가 선택한 방법은 아래와 같다.
 * - 양수의 경우, 숫자의 각 자리를 큰 자릿수부터 순서대로 배열에 저장한다.
 * - 음수는 사용하지 않는다.
 * - 0의 경우, 빈 배열로 표현한다.
 * 위 방법을 이용하여 배열로 표현된 숫자의 예는 아래와 같다.
 *
 * 1523 -> {1, 5, 2, 3}
 * 0 -> {}
 * 기산이는 이 표현법을 이용하여 덧셈기를 구현하고자 한다.
 * 첫 번째 인자인 a와 두 번째 인자인 b를 입력받아, 배열 표현법으로 결과를 출력하시오.
 *
 * 0 <= a.length, b.length <= 1000
 *
 * 입력 :
 * a = 5 2 1 4 6
 * b = 6 1 0 4 4
 *
 * 출력 :
 * 1 1 3 1 9 0
 */
public class Task3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data1 = br.readLine().trim().split(" ");
        String[] data2 = br.readLine().trim().split(" ");
        int[] a = parse(data1);
        int[] b = parse(data2);
        int[] result = solution(a, b);

        System.out.println(Arrays.toString(result));
    }

    public static int[] parse(String[] data) {
        if (data.length == 1 && data[0].equals("0")) {
            return new int[0];
        }
        int[] arr = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }
        return arr;
    }

    public static int[] solution(int[] a, int[] b) {
        int maxLen = Math.max(a.length, b.length);
        int[] result = new int[maxLen + 1];

        int aIdx = a.length - 1;
        int bIdx = b.length - 1;
        int rIdx = result.length - 1;

        int carry = 0;

        while (aIdx >= 0 || bIdx >= 0 || carry > 0) {
            int digitA = aIdx >= 0 ? a[aIdx--] : 0;
            int digitB = bIdx >= 0 ? b[bIdx--] : 0;
            int sum = digitA + digitB + carry;
            result[rIdx--] = sum % 10;
            carry = sum / 10;
        }

        int startIdx = 0;
        while (startIdx < result.length && result[startIdx] == 0) {
            startIdx++;
        }

        return Arrays.copyOfRange(result, startIdx, result.length);
    }
}
