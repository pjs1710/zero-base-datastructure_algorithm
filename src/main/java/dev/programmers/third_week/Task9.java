package dev.programmers.third_week;

/**
 * 7주차 문제 9번 :
 *
 * 두 명이서 하는 베스킨라빈스 게임은 아래와 같이 진행된다.
 * - 첫 시작 시 게임 수는 1부터 시작한다.
 * - 자신의 차례에 1, 2, 3 중 하나를 골라 이 수를 게임 수에 더한다.
 * - 차례는 번갈아 가며 진행하며, 자기 차례에 게임 수가 31 이상의 수가 되면 패배한다.
 * --- 룰 변경 ---
 * - 게임은 두명이서 진행한다.
 * - 첫 시작 시 게임 수는 0부터 시작한다.
 * - 도달하면 게임을 종료하는 수 31 대신 자연수 target으로 한다.
 * - target값 이상이 되면 게임에서 승리한다.
 * - 1 이상 3 이하의 수 대신, 1 이상 r 이하의 수를 선택할 수 있다.
 * - 수를 선택할 때에는 한 번 사용한 수는 재사용할 수 없다.
 *
 * 예를 들어, target = 10, r = 4
 * 첫번째 사람은 1~4중 아무거나 선택할 수 있다. 4를 선택하면 현재 수는 4.
 * 두번째 사람은 1, 2, 3중 선택할 수 있다. 2를 선택하면 현재 수는 6.
 * 첫번째 사람은 1, 3중 선택할 수 있다. 1을 선택하면 현재 수는 7.
 * 두번째 사람은 3을 선택할 수 있다. 3을 선택하면 현재 수는 10이 된다.
 * 두번째 사람이 target값에 도달하였으므로 두번째 사람이 게임에서 승리하낟.
 *
 * target, r에 대해서 첫번째 사람이 항상 승리할 수 있는지 여부를 논리값으로 반환하시오.
 * 단, 두 사람은 모두 항상 자신이 이길 수 있는 최선의 수를 선택한다.
 * 또한 사용할 수 있는 모든 수를 더해도 target에 도달할 수 없으면 승리할 수 없는 것으로 본다.
 */

import java.io.*;
import java.util.*;

public class Task9 {

    public static boolean solution(int target, int r) {
        Set<Integer> alreadyUsed = new HashSet<>();
        Map<String, Boolean> memo = new HashMap<>();
        int maxSum = r * (r + 1) / 2;

        if (maxSum < target) { // 다 더해도 target에 도달할 수 없음
            return false;
        }

        return win_or_lose(0, alreadyUsed, true, target, r, memo);
    }

    public static boolean win_or_lose(int curSum, Set<Integer> alreadyUsed, boolean myTurn, int target, int r, Map<String, Boolean> memo) {
        if (curSum >= target) { // 현재 합이 target을 이미 넘었으니 졌음
            return !myTurn;
        }

        String key = curSum + "|" + encode(alreadyUsed) + "|" + myTurn;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean canCurrentPlayerWin = false;

        for (int i = 1; i <= r; i++) {
            if (alreadyUsed.contains(i)) {
                continue;
            }
            alreadyUsed.add(i);
            boolean result = win_or_lose(curSum + i, alreadyUsed, !myTurn, target, r, memo);
            alreadyUsed.remove(i);

            if (myTurn && result) {
                canCurrentPlayerWin = true;
                break;
            }

            if (!myTurn && !result) {
                canCurrentPlayerWin = true;
                break;
            }
        }

        memo.put(key, canCurrentPlayerWin);
        return canCurrentPlayerWin;
    }

    public static String encode(Set<Integer> alreadyUsed) {
        List<Integer> sorted = new ArrayList<>(alreadyUsed);
        Collections.sort(sorted);
        return sorted.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());

        System.out.println(solution(target, r));
    }
}
