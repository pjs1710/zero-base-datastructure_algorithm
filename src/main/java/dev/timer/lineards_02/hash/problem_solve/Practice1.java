package dev.timer.lineards_02.hash.problem_solve;

// 해시 테이블을 이용한 수 찾기
// 주어진 첫 번째 배열을 이용하여 해시 테이블을 초기화 한 후
// 두 번째 배열이 주어졌을 때 해당 배열 내 데이터가 해시 테이블에 있는지 확인하는 코드를 작성하세요.

// 입출력 예시)
// 배열1 : 1, 3, 5, 7, 9
// 배열2 : 1, 2, 3, 4, 5
// 출력 : True, False, True, False, True

import java.util.Arrays;
import java.util.Hashtable;

public class Practice1 {
    // 내 풀이
//    public static void solution(int[] arr1, int[] arr2) {
//        Hashtable<Integer, Integer> ht = new Hashtable<>();
//        Boolean[] result = new Boolean[arr2.length];
//        for (int i = 0; i < arr1.length; i++) {
//            ht.put(i, arr1[i]);
//        }
//        for (int i = 0; i < ht.size(); i++) {
//            for (int j = 0; j < arr2.length; j++) {
//                if (ht.containsValue(arr2[j])) {
//                    result[j] = true;
//                } else {
//                    result[j] = false;
//                }
//            }
//        }
//
//        System.out.print(Arrays.toString(result));
//    }

    // 강사님 풀이
    public static void solution(int[] arr1, int[] arr2) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();

        for (int i = 0; i < arr1.length; i++) {
            ht.put(arr1[i], arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (ht.containsKey(arr2[i])) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Code
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 2, 3, 4, 5};
        solution(arr1, arr2);
    }
}
