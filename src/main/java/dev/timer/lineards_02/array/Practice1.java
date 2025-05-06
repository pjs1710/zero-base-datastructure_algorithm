package dev.timer.lineards_02.array;

// 배열 arr의 모든 데이터에 대해서,
// 짝수 데이터들의 평균과 홀수 데이터들의 평균을 출력하세요.

// 입출력 예시)
// 배열 arr : 1, 2, 3, 4, 5, 6, 7, 8, 9
// 결과 :
// 짝수 평균 : 5.0
// 홀수 평균 : 5.0

import java.util.Arrays;

public class Practice1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("arr = " + Arrays.toString(arr));

        double oddSum = 0, evenSum = 0;
        int oddCount = 0, evenCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenSum += arr[i];
                evenCount++;
            } else {
                oddSum += arr[i];
                oddCount++;
            }
        }
        double oddAvg = oddSum / oddCount;
        double evenAvg = evenSum / evenCount;

        System.out.println("짝수 평균: " + evenAvg);
        System.out.println("홀수 평균: " + oddAvg);
    }

}
