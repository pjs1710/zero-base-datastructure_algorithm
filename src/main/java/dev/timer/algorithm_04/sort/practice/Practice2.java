package dev.timer.algorithm_04.sort.practice;

import java.util.ArrayList;
import java.util.HashMap;

// 문자열 배열 strs가 주어졌을 때 anagram으로 묶어서 출력하는 프로그램을 작성하세요.
// anagram은 철자 순서를 바꾸면 같아지는 문자를 의미한다.
// 예 elvis -> lives
// anagram 그룹 내에서 출력 순서는 상관 없다.

// 입출력 예시
// 입력 : "eat", "tea", "tan", "ate", "nat", "bat"
// 출력 : [[eat, tea, ate], [bat], [tan, nat]]

public class Practice2 {

    public static ArrayList<ArrayList<String>> solution(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s : strs) { // String s 값을 문자 하나의 단위로 쪼개서 배열로 만들고 해당 문자 배열을 정렬. ex) [e, a, t] -> [a, e, t]
            char[] cArr = s.toCharArray();
            // sort
            sort(cArr);
            String key = String.valueOf(cArr); // 정렬된 문자를 합침 -> aet

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void sort(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    char tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test Code
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(strs));

        strs = new String[]{"abc", "bac", "bca", "xyz", "zyx", "aaa"};
        System.out.println(solution(strs));
    }
}
