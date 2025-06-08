package dev.programmers.first_week;

import java.io.*;
import java.util.*;

/**
 * 5주차 문제 4번 :
 *
 * S는 알파벳으로 이루어진 문자열
 * 순서대로 문자열을 확인하여, 해당 문자열에서 2회 연속으로 동일한 문자가 나타나면, 해당 두 문자를 소거한다.
 * 소거한뒤에 나온 문자열에서 다시 연속해서 나오는 알파벳을 소거하는 작업을 더 이상 작업할 것이 없을 때까지 반복
 * 이때 최종 문자열이 완전히 소거되어 빈 문자열이라면 1을 반환하고, 알파벳이 남아있으면 0을 반환하는 프로그램을 구현하세요.
 */
public class Task4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();

        int result = solution(data);
        System.out.println(result);
    }

    public static int solution(String S) {
        String[] split = S.split("");
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

                String joined = String.join("", split); // split에서 제거한 split배열을 joined로 합치기 ABBA -> AA
                if (joined.isEmpty()) {
                    return 1;
                }
                split = joined.split(""); // AA를 다시 split으로 나눠서 저장
            }
        }
        return 0;
    }
}
