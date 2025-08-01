package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 문자열 s가 있을 때, 이 문자열을 재배치하여 만든 문자열을 애너그램이라고 한다.
 * "fine"은 "infe"의 애너그램이라고 할 수 있다.
 * s가 영문 소문자로만 이루어져 있다고 할 때, 문자열 t가 문자열 s의 애너그램인지 판단하는 프로그램을 작성하시오.
 */

public class Num_13 {

    public static boolean solution(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        System.out.println(solution(s, t));
    }
}
