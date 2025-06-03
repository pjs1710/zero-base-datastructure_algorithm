package dev.basic.ds.array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제풀이 2번 :
 *
 * 10개의 입력을 받아 총합과 최소값을 출력하세요.
 *
 */

public class Practice2 {

    public static void main(String[] args) throws IOException {
        // 1. 10개 입력 받기
        // 2. 총합 계산
        // 3. 최소값 찾아서 출력하기
        // ! 입력값 예외 처리 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[10];
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sum).append("\n").append(min);
        System.out.println(stringBuffer.toString());

    }
}
