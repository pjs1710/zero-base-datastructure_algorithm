package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 병선이는 압축된 문자열 code의 압축을 햊제하는 프로그램을 작성하려고 한다.
 * code는 기본적으로 다음과 같이 압축되어 있다.
 * - n{알파벳_문자열} -> 알파벳_문자열 을 n번 만큼 반복
 *
 * 즉, 3{abc}e는 abcabcabce로 압축을 해제할 수 있다.
 * 효율을 높이고자, 위 방법을 다중으로 사용하기로 하였다.
 *
 * 즉, f2{a3{bc}}z 는 f2{abcbcbc}z -> fabcbcbcabcbcbcz로 압축을 해제할 수 있다.
 * code를 입력받아 압축을 해제하여 문자열로 출력하시오.
 */
public class Num_5 {

    public static String solution(String code) {
        return decode(code, new int[]{0});
    }

    private static String decode(String code, int[] index) {
        StringBuilder result = new StringBuilder();

        while (index[0] < code.length()) {
            char ch = code.charAt(index[0]);

            if (Character.isLetter(ch)) {
                result.append(ch);
                index[0]++;
            } else if (Character.isDigit(ch)) {
                int num = 0;
                while (Character.isDigit(code.charAt(index[0]))) {
                    num = num * 10 + (code.charAt(index[0]) - '0');
                    index[0]++;
                }

                if (code.charAt(index[0]) == '{') {
                    index[0]++;
                    String inner = decode(code, index);
                    for (int i = 0; i < num; i++) {
                        result.append(inner);
                    }
                }
            } else if (ch == '}') {
                index[0]++;
                break;
            } else {
                index[0]++;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine();
        System.out.println(solution(code));
    }
}
