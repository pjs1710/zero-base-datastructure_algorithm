package dev.programmers.second_week;

/**
 * 6주차 문제 1번 :
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
 * 버블 정렬 사용
 */

import java.io.*;
import java.util.*;

public class Task1 {

    public static String solution(String input) {
        StringBuffer sb = new StringBuffer();
        String[] data = input.split("");
        int[] countNums = new int[10]; // 등장 횟수를 저장할 배열
        int[] nums = new int[10]; // 0 ~ 9까지 숫자

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        for (int i = 0; i < data.length; i++) {
            int index = Integer.parseInt(data[i]);
            countNums[index]++;
        }

        //* TODO : 버블정렬 이용하기
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 - i; j++) {
                if (countNums[nums[j]] < countNums[nums[j + 1]] || (countNums[nums[j]] == countNums[nums[j + 1]] && nums[j + 1] < nums[j])) { // 0번 나오는 애들은 다 같은 경우니까 해당 부분도 처리해줘야함. 대신 nums 인덱스가 더 커야함
                    // nums 정렬해주기 (내림차순)
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

        // nums에는 정렬이 다 되어있음. 2 1 3 0 4 5 6 7 8 9 <<
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
