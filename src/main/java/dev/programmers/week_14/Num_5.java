package dev.programmers.week_14;

import java.util.*;

/**
 * 개발자로 이름을 날리던 당신은, 제로초등학교의 일일 직업 체험 강사로 섭외되었다.
 * 일일 수업을 무사히 마치고, 학생들에게 퀴즈를 풀게 하여 각 학생의 점수를 scores[i]에 기록하였다.
 * 학생들을 인덱스 순서대로 일렬로 세워둔 후, 학생의 점수에 따라 초코렛을 나눠주려 한다.
 * 예산이 부족한 바람에 초코렛을 최대한 아껴야 하지만, 아래 조건을 만족하게끔 초코렛을 나눠주어야 한다.
 * - 최소 1개 이상의 초코렛은 각 학생에게 나누어 주어야 한다.
 * - 바로 인접한 친구보다 점수가 높다면, 더 많은 초코렛을 받아야 한다.
 * 위 조건을 만족하면서 최소로 초코렛을 나누어 줄 때, 각 학생이 받는 초코렛의 개수를 출력하시오.
 *
 * 입력 :
 * scores = {1, 3, 5, 4, 5, 5, 5, 1}
 *
 * 결과 :
 * {1, 2, 3, 1, 2, 1, 2, 1}
 */

public class Num_5 {

    public static int[] solution(int[] scores) {
        int n = scores.length;
        int[] chocolates = new int[n];

        Arrays.fill(chocolates, 1);

        for (int i = 1; i < n; i++) {
            if (scores[i] > scores[i - 1]) {
                chocolates[i] = chocolates[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                chocolates[i] = Math.max(chocolates[i], chocolates[i + 1] + 1);
            }
        }

        return chocolates;
    }

    public static void main(String[] args) {

    }
}
