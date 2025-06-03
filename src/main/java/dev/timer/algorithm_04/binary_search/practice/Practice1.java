package dev.timer.algorithm_04.binary_search.practice;

// 이진 탐색 추가 구현
// target 값이 arr 내에 있으면 해당 인덱스 반환
// 없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값을 반환

// 입출력 예시
// 입력 arr : 1, 2, 5, 10, 20, 30, 40, 50, 60

// target : 30
// 출력 : 5

// target : 3
// 출력 : -3

public class Practice1 {

    public static int solution(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2; // Overflow 발생 할 수 있음
//            int mid = left + (right - left) / 2; // Overflow 발생을 방지
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) { // 타겟이 중앙 기준 왼쪽에 있다는 말
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -left - 1; // 만족하는 값이 없는 경우
    }

    public static void main(String[] args) {
        // Test Code
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr, 30)); // 5
        System.out.println(solution(arr, 3)); // -3
        System.out.println(solution(arr, 11)); // -5
        System.out.println(solution(arr, 35)); // -7

    }
}
