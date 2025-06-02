package dev.timer.algorithm_04.sort.practice;

import java.util.Arrays;

// nums 배열에 3가지 색으로 구분되는 데이터들이 들어 있다.
// 0은 흰색, 1은 파랑, 2는 빨강이라고 할 때
// 주어진 nums 배열에서 흰색부터 빨강 순으로 인접하게 정렬시킨 후 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 : 2, 0, 2, 1, 1, 0
// 출력 : 0, 0, 1, 1, 2, 2

public class Practice1 {

    public static void solution(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int[] cntArr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++; // cntArr = [2, 2, 2]
        }

        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) {
            while (cntArr[i] > 0) {
                arr[idx++] = i;
                // arr[0] = 0 -> idx = 1, cntArr[0] = 1, cntArr = [1, 2, 2]
                // arr[1] = 0 -> idx = 2, cntArr[0] = 0, cntArr = [0, 2, 2]
                cntArr[i] -= 1;
            }
        }
    }

    public static void main(String[] args) {
        // Test Code
        int[] arr = {2, 0, 2, 1, 1, 0};
        solution(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        arr = new int[]{2, 0, 1};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
}
