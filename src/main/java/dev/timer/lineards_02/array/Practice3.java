package dev.timer.lineards_02.array;

// 배열 arr의 데이터 순서를 거꾸로 변경하세요.
// 추가 배열을 사용하지 않고 구현

import java.util.Arrays;

// 입출력 예시)
// arr : 1, 3, 5, 7, 9
// 결과 : 9, 7, 5, 3, 1
public class Practice3 {

    // 내 풀이
//    public static void main(String[] args) {
//        int arr[] = {1, 3, 5, 7, 9};
//        System.out.println("arr = " + Arrays.toString(arr));
//
//        for (int i = 0; i < arr.length; i++) {
//            if (i < arr.length - 1 - i) {
//                int tmp = arr[i];
//                arr[i] = arr[arr.length - 1 - i];
//                arr[arr.length - 1 - i] = tmp;
//            } else {
//                break;
//            }
//        }
//
//        System.out.println("결과 = " + Arrays.toString(arr));
//    }

    // 강사님 풀이
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};

        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
