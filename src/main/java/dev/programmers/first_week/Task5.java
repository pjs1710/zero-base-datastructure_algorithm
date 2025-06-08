package dev.programmers.first_week;

import java.io.*;
import java.util.*;

/**
 * 5주차 문제 5번 :
 *
 * 문자열에 연속한 2개의 같은 문자가 존재하지 않도록 만들고 싶습니다.
 * 연속한 2개의 같은 문자가 존재한다면 이 문자를 지우고 남은 문자열을 이어 붙입니다.
 * 이 과정을 연속한 2개의 같은 문자가 없을 때까지 반복하면 목표한 문자열을 얻게 됩니다.
 * 문자열 s가 주어질 때, 위와 같은 과정을 적용해서 나오는 문자열을 출력하는 프로그램을 구현하세요.
 */

public class Task5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();

        String result = solution(data);
        System.out.println(result);
    }

    public static String solution(String S) {
        String[] split = S.split("");
        String joined = S;
        int idx = 0;
        while (true) {
            if (idx >= split.length - 1) {
                break;
            }

            if (!split[idx].equals(split[idx + 1])) {
                idx++;
            } else {
                split[idx] = "";
                split[idx + 1] = "";
                idx = 0;

                joined = String.join("", split); // split에서 제거한 split배열을 joined로 합치기 ABBA -> AA
                split = joined.split(""); // AA를 다시 split으로 나눠서 저장
            }
        }
        return joined;
    }
}
