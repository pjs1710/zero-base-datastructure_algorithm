package dev.programmers.week_14;

import java.util.*;

/**
 * 만수는 연속된 두 수의 합이 계속되는 피보나치 수열이 너무나도 마음에 든 나머지, 세상에 숨어있는 모든 유사 피보나치 수열을 찾고자 한다.
 * 여기서 유사 피보나치 수열은 피보나치 수열처럼 연속된 두 수의 합이 반복되지만, 첫 두 숫자는 자유롭게 선택할 수 있는 수열을 말한다.
 * 숫자로 이루어진 문자열 nums가 있다고 할 때, 이것을 적절히 나누어 유사 피보나치 수열로 만들려고 한다.
 * 예를 들어, nums = "14152944"로 문자열이 주어질 때, 이것을 유사 피보나치 수열로 나눈 결과는 {14, 15, 29, 44}이다.
 * 단, 유사 피보나치 수열로 나눌 수 없는 경우 {}을 출력하고, 숫자를 나눌 때 숫자 앞에 앞선 0이 있어서는 안된다.
 * 또한 각 숫자는 2^31 - 1 (int 자료형 최댓값)을 넘지 않아야 한다.
 */

public class Num_9 {

    public int[] solution(String nums) {
        for (int i = 1; i <= nums.length() / 2; i++) {
            for (int j = 1; j <= (nums.length() - i) / 2; j++) {
                String first = nums.substring(0, i);
                String second = nums.substring(i, i + j);

                if ((first.length() > 1 && first.charAt(0) == '0') ||
                        (second.length() > 1 && second.charAt(0) == '0')) {
                    continue;
                }

                try {
                    long n1 = Long.parseLong(first);
                    long n2 = Long.parseLong(second);
                    if (n1 > Integer.MAX_VALUE || n2 > Integer.MAX_VALUE) continue;

                    int num1 = (int) n1;
                    int num2 = (int) n2;
                    List<Integer> result = new ArrayList<>();
                    result.add(num1);
                    result.add(num2);

                    int pos = i + j;
                    int prev1 = num1, prev2 = num2;

                    while (pos < nums.length()) {
                        long next = (long) prev1 + prev2;
                        if (next > Integer.MAX_VALUE) break;

                        String nextStr = String.valueOf(next);
                        if (pos + nextStr.length() > nums.length() ||
                                !nums.substring(pos, pos + nextStr.length()).equals(nextStr)) {
                            break;
                        }

                        result.add((int) next);
                        pos += nextStr.length();
                        prev1 = prev2;
                        prev2 = (int) next;
                    }

                    if (pos == nums.length() && result.size() >= 3) {
                        return result.stream().mapToInt(Integer::intValue).toArray();
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {

    }
}
