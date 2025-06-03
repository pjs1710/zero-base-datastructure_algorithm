package dev.basic.ds.array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 문제풀이 1번 :
 *
 * 사용자에게 데이터의 크기를 입력받고, 값을 0 ~ 10 내로 랜덤하게 초기화하세요.
 * 마지막엔 특정 숫자를 입력받아, 해당 숫자의 개수를 출력하세요.
 *
 */

public class Practice1 {

    public static void main(String[] args) throws IOException {
        // 사용자에게 입력(input)을 받는다.
        // 결과를 출력(output)한다.
        // > IO (input / output)
        // 오류의 가능성을 갖고 있다.
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        // 1. 사용자에게 배열의 크기를 입력받는다.
        int size = Integer.parseInt(buffer.readLine());
        int[] arr = new int[size];

        // 2. 랜덤하게 배열을 초기화한다.
        Random rd = new Random();
        for (int index = 0; index < arr.length; index++) {
            arr[index] = rd.nextInt(10);
        }

        // 3. 사용자에게 특정 숫자를 입력받는다.
        int findNumber = Integer.parseInt(buffer.readLine());

        // 4. 개수를 세어 출력한다.
        int cnt = 0;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == findNumber) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
