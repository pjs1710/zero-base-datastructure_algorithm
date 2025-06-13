package dev.programmers.second_week;

/**
 * 6주차 문제 3번 :
 *
 * 내용이 정수로 이루어진 문자열 s가 있습니다.
 * 이 때 문자열에 더 많이 포함된 순서대로 숫자를 출력하는 프로그램을 작성하세요.
 * 출력할 때 각 숫자는 공백으로 구분하고, 문자열에 포함되지 않은 숫자도 0번 등장한 것으로 간주하여 0 ~ 9 숫자를 모두 출력하세요.
 *
 * 1 <= s <= 100000
 *
 * 입력 :
 * s = "221123"
 *
 * 출력 :
 * 2 1 3 0 4 5 6 7 8 9
 *
 * 많이 나타낸 순서대로 2, 1, 3을 출력, 나타난 횟수가 0번인 나머지 숫자들은 작은 수부터 차례대로 출력
 * 선택 정렬 사용
 */

import java.io.*;
import java.util.*;

public class Task3 {

    public static String solution(String input) {
        String[] data = input.split("");
        StringBuffer sb = new StringBuffer();
        int[] countNums = new int[10];
        int[] nums = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        for (int i = 0; i < data.length; i++) {
            int index = Integer.parseInt(data[i]);
            countNums[index]++;
        }

        //* TODO : 선택 정렬을 이용해서 많이 나타낸 순서대로 정렬하기.
        /*
        countNums = 0 2 3 1 0 0 0 0 0 0
        nums =      0 1 2 3 4 5 6 7 8 9
        min = MAX_VALUE;
        if (!countNums[nums[j]] == 0) {
            countNums[nums[j]] < min -> min = countNums[nums[j]]
        }
         */

        for (int i = 0; i < nums.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (countNums[nums[j]] > countNums[nums[maxIdx]] || (countNums[nums[j]] == countNums[nums[maxIdx]] && nums[j] < nums[maxIdx])) {
                    maxIdx = j;
                }
            }

            int tmp = nums[maxIdx];
            nums[maxIdx] = nums[i];
            nums[i] = tmp;
        }

        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String result = solution(input);
        System.out.println(result);
    }
}
