package dev.basic.ds.array.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제풀이 3번 :
 *
 * 사용자가 원하는 개수를 입력 받고, 연달아오는 개수만큼의 값으로 초기화합니다.
 * 합/평균/최소/최대값을 순서대로 출력하세요.
 *
 */

public class Practice3 {

    public static final String ENTER = "\n";
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 사용자가 원하는 개수 입력 받고,
        int size = Integer.parseInt(br.readLine());
        // 해당 개수만큼의 배열 선언
        int[] arr = new int[size];

        // 2. 연달아오는 개수만큼의 값으로 초기화한다.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 3. 합/최대/최소/평균을 구한다.
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (arr[i] < MIN) {
                MIN = arr[i];
            }
            if (arr[i] > MAX) {
                MAX = arr[i];
            }
        }

        // 4. 합/평균/최소/최대 순으로 StringBuffer를 이용해 출력한다.
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sum).append(ENTER).append((double) sum / size).append(ENTER).append(MIN).append(ENTER).append(MAX);
        System.out.println(stringBuffer.toString());
    }
}
