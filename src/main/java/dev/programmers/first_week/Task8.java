package dev.programmers.first_week;

import java.io.*;
import java.util.*;

/**
 * 5주차 문제 8번 :
 *
 * 문자열에 적용할 수 있는 연산을 아래와 같이 정의하자.
 * - 문자열에서 모든 'a' 문자의 위치를 찾는다.
 * - 'a' 문자가 연속으로 나타날 경우, 'a'를 한 개로 바꾼다.
 * - 'a' 문자가 단독으로 나타날 경우, 왼쪽 문자와 오른쪽 문자를 'a'로 바꾼다.
 *
 * 예를 들면, abcabcaaa에 위 연산을 적용하면 aaaaaca가 된다.
 * 문자열 s가 주어졌을 때, 이 문자열이 a가 될 때까지 위 연산을 몇번 적용해야 하는지 계산하는 함수를 구현하시오.
 *
 * 입력 : azbacefbaaaa
 *
 * 출력 : 5
 */

public class Task8 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(solution(input));
    }

    // 현재 기준 인덱스를 비교하면서 만약 a가 나왔으면 left, right 비교
    // 만약 오른쪽 값이 a이면 a가 아닐 때까지 오른쪽으로 쭉
    // 그 후 a 하나로 바꾸기
    public static int solution(String s) {
        String[] data = s.split("");
        String[] result = s.split("");
        int cnt = 0;

        while (true) {
            int idx = 0;
            while (idx < data.length) {
                if (!data[idx].equals("a")) {
                    idx++;
                    continue;
                }

                if ((idx - 1) < 0) { // 맨 처음 a가 나오는 경우 오른쪽만 변경
                    if (idx + 1 < result.length) {
                        result[idx + 1] = "a";
                    }
                } else if ((idx + 1) == data.length) { // 마지막에 a가 나오는 경우 왼쪽만 변경
                    result[idx - 1] = "a";
                } else if (!data[idx + 1].equals("a")) { // 사이에 a가 나오면 양쪽 변경
                    result[idx - 1] = "a";
                    result[idx + 1] = "a";
                } else { // 오른쪽에 쭉 a가 나오는 경우
                    int right = idx + 1;
                    while (right < data.length && data[right].equals("a")) {
                        right++; // 계속 증가시키면서 비교
                    }
                    // 첫 idx는 a였으니까 놔두고 나머지 idx부터 right 표시한 곳까지 전부 ""로 바꾸기
                    for (int i = idx + 1; i < right; i++) {
                        result[i] = "";
                    }
                    idx = right - 1; // a 처리가 끝난 곳까지 인덱스 위치 바꿔주기
                }
                idx++;
            }

            StringBuilder sb = new StringBuilder();
            for (String item : result) {
                if (!item.isEmpty()){
                    sb.append(item);
                }
            }
            String next = sb.toString();
            if (next.equals("a") || next.equals(s)) {
                break;
            }

            cnt++;
            s = next;
            data = next.split("");
            result = next.split("");
        }
        return cnt;
    }
}
