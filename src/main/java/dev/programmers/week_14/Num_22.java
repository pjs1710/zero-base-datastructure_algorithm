package dev.programmers.week_14;

import java.util.*;

/**
 * 숫자 num이 주어졌을 때, 최대 한번의 자릿수 교환을 통해 최대의 숫자를 만들어 내려고 한다.
 * 즉, 자릿수 교환을 하지 않았을 때가 더 큰 숫자인 경우, 원래 숫자를 그대로 출력해야 한다.
 *
 * 입력 :
 * num = 43824
 *
 * 결과 :
 * 83424
 */

public class Num_22 {

    public static int solution(int num) {
        // 숫자를 문자 배열로 변환
        char[] digits = String.valueOf(num).toCharArray();
        int maxNum = num; // 원래 숫자로 초기화

        // 모든 가능한 자릿수 교환을 시도
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                // i번째와 j번째 자릿수 교환
                swap(digits, i, j);

                // 교환된 숫자 계산
                int swappedNum = Integer.parseInt(new String(digits));

                // 최댓값 갱신
                maxNum = Math.max(maxNum, swappedNum);

                // 원래대로 되돌리기
                swap(digits, i, j);
            }
        }

        return maxNum;
    }

    // 배열의 두 요소를 교환하는 헬퍼 메서드
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

    }
}
