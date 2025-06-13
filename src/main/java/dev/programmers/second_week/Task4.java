package dev.programmers.second_week;

import java.io.*;
import java.util.*;

/**
 * 6주차 문제 4번 :
 *
 * 문자열 s가 있을 때, 이 문자열을 재배치하여 만든 문자열을 '애너그램'이라고 한다.
 * 예를 들어, "fine"은 "infe"의 애너그램이라고 할 수 있다.
 * s가 영문 소문자로만 이루어져 있다고 할 때, 문자열 t가 문자열 s의 애너그램인지 판단하는 프로그램을 작성하시오.
 *
 * 입력 :
 *
 * s = "imfinethankyou"
 * t = "atfhinemnoyuki"
 *
 * 결과 : true
 */

public class Task4 {

    public static boolean solution(String s, String t) {
        if (s.length() != t.length() || s.isEmpty() || t.isEmpty()) {
            return false;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] sData = s.toCharArray();
        char[] tData = t.toCharArray();

        for (char item : sData) {
            hashMap.put(item, hashMap.getOrDefault(item, 0) + 1); // 알파벳 처음에 들어오는건 0, 그 다음 기존에 있는 데이터 들어오면 + 1 해주기
        }

        for (char item : tData) {
            if (!hashMap.containsKey(item) || hashMap.get(item) == 0) {
                return false;
            }
            hashMap.put(item, hashMap.get(item) - 1); // 기존에 있는 값 하나씩 빼기
        }

        for (int count : hashMap.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sInput = br.readLine();
        String tInput = br.readLine();

        boolean result = solution(sInput, tInput);
        System.out.println(result);
    }
}
