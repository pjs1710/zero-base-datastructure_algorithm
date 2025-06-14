package dev.programmers.second_week;

import java.io.*;
import java.util.*;

/**
 * 6주차 문제 8번 :
 *
 * 양의 정수가 담긴 문자열 s가 있다고 하자. 이 문자열에서 k개의 숫자를 제거해, 가장 작은 숫자를 만들고자 한다.
 * 이렇게 만든 가장 작은 숫자를 담은 문자열을 출력하시오.
 * 단, k개의 문자열을 제거한 결과는 앞에 불필요한 0이 포함될 수 있으며,
 * 최종 출력에는 이 불필요한 0은 제거하여 출력하시오.
 *
 * 입력 :
 * s = "105990"
 * k = 1
 *
 * 출력 :
 * "5990"
 * 05990 -> 5990
 */

public class Task8 {

    public static String solution(String s, int k) {
        int remain = s.length() - k;
        Deque<Character> stack = new ArrayDeque<>();

        for (char item : s.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > item) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(item);
        }

        while (k > 0) {
            stack.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (char item : stack) {
            if (cnt == remain) break;
            sb.append(item);
            cnt++;
        }

        // 앞의 0 제거
        String result = sb.toString().replaceFirst("^0+", ""); // 정규표현식으로 앞에 0 다 제거
        return result.isEmpty() ? "0" : result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int k = Integer.parseInt(br.readLine());
        System.out.println(solution(s, k));
    }
}
