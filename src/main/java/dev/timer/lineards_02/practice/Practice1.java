package dev.timer.lineards_02.practice;

import java.util.Arrays;

public class Practice1 {

    public static int[] solution(int[] arr) {
        int[] arrNew = new int[arr.length];

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arrNew[idx] == 0) { // 인덱스 위치에 데이터가 없는 경우 for문 탈출 후 데이터 삽입
                    break;
                }
                idx = (idx + 1) % arr.length; // 인덱스 위치에 데이터가 있는 경우 해당 위치부터 1칸씩 옮기면서 없는 구간 찾기
            }
            arrNew[idx] = arr[i];
            idx = (idx + arr[i]) % arr.length;
        }
        return arrNew;
    }

    public static int[] modification(int[] arr) {
        int[] arrNew = new int[arr.length];

        int idx = 0;
        int cnt = 0;
        int val = arr[idx];

        while (cnt < arr.length) {
            while (val == 0) {
                idx = (idx + 1) % arr.length;
                val = arr[idx];
            }
            arrNew[cnt++] = val;
            arr[idx] = 0;
            idx = (val + idx) % arr.length;
            val = arr[idx];
        }
        return arrNew;
    }

    public static void main(String[] args) {
        // Test Code
        // Modification test
        int[] arr = {1, 3, 7, 9, 5};
        int[] arrNew = modification(arr);
        System.out.println(Arrays.toString(arrNew));

        // Revert data
        arr = new int[]{1, 3, 5, 7, 9};
        int[] arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));

        arr = new int[]{3, 2, 6, 8};
        arrOrigin = solution(arr);
        System.out.println(Arrays.toString(arrOrigin));
    }
}
