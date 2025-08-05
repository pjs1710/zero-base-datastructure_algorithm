package dev.programmers.week_14;

import java.util.*;

/**
 * 당신은 이미 한번 개표를 마쳐서 과반수 성립한다는 점을 알고 있는 투표를 검수하게 되었다.
 * 공정함을 위해서 당신에게는 누가 투표에서 승리했는지 알려지지 않았고, 모든 투표용지에는 후보의 기호 숫자만이 기재되어 있다.
 * 예를 들어, 투표 결과가 votes = {1, 4, 2, 2, 2, 3, 2, 2, 1}로 주어졌을 때, 과반수 투표 결과는 2가 된다.
 * 위 과반수 투표 결과를 출력하는 프로그램을 작성하시오.
 *
 * 입력 :
 * votes = {4, 3, 2, 3, 3, 3, 3, 1, 2, 2, 3}
 *
 * 결과 :
 * 3
 */

public class Num_7 {

    public static int solution(int[] votes) {
        Map<Integer, Integer> count = new HashMap<>();
        int majority = votes.length / 2;

        for (int vote : votes) {
            count.put(vote, count.getOrDefault(vote, 0) + 1);
            if (count.get(vote) > majority) {
                return vote;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}
