package dev.basic.ds.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 기준점 : 어떨 때, 데이터를 (배열을) 확장해야할까?
        // 즉, 배열의 index의 위치가 초과되었을 때를 확인해 확장한다.

        int[] arr = new int[1];
        int idx = 0;

        while (true) {
            int value = Integer.parseInt(br.readLine());

            if (idx == arr.length) {
                arr = expendArr(arr);
//                Arrays.copyOf(arr, arr.length + 1);
            }

            arr[idx] = value;
            idx++;
        }
    }

    private static int[] expendArr(int[] arr) {
        // 확장하는 시점 : index가 범위를 막 초과한 경우
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i]; // 기존 값 복사
        }
        return newArr;
    }
}
