package dev.timer.algorithm_04.binary_search.practice;

// 정수형 배열 weights와 정수 days가 주어졌다.
// weights에는 각 상품의 무게들의 정보가 들어있고, days는 운송 납기일이다.
// 상품들은 weights에 적혀있는 순서대로 실어서 운송해야 하는데,
// days 이내에 운송을 하기 위한 차량의 최소한의 적재량을 계산하는 프로그램을 작성하세요.

// 입출력 예시
// weights : 1, 2, 3, 4, 5, 6, 7, 8, 9, 10  -> 1 2 3 4 || 5 6 || 7 8 || 9 || 10 최소 적재량 15
// days : 5
// 출력 : 15

// weights : 3, 2, 2, 4, 1, 4
// days : 3
// 출력 : 6

public class Practice4 {

    public static int solution(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 1;
            int cur = 0;

            for (int w : weights) {
                if (cur + w > mid) {
                    cnt += 1;
                    cur = 0;
                }
                cur += w;
            }

            if (cnt > days) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        // Test Code
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(solution(weights, 5)); // 15

        weights = new int[]{3, 2, 2, 4, 1, 4};
        System.out.println(solution(weights, 3)); // 6

    }
}
