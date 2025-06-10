package dev.basic.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 동전 거스름돈
 *
 * 특정 금액을 입력했을 때, 동전으로 거슬러줍니다.
 * 종류는 500, 100, 50, 10원이 있고 개수에는 제한이 없다고 합니다.
 * 이때, 동전의 개수를 가장 적게 주는 방법으로 거슬러준다면, 몇개를 반환할 지 출력합니다.
 *
 * 예시 :
 * 950 -> 6
 * 1930 -> 10
 */

public class Greedy1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(br.readLine());

        int[] coins = {500, 100, 50, 10};
        int cnt = 0;

        for (int coin : coins) {
            cnt += amount / coin;
            amount = amount % coin;
        }

        System.out.println(cnt);
    }
}
