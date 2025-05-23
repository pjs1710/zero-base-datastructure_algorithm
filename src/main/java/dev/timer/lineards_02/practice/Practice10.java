package dev.timer.lineards_02.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.stream.Stream;

public class Practice10 {

    public static ArrayList<Integer> solution(String[] gems) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>(); // 구매 가능한 구간들의 리스트들

        HashSet<String> set = new HashSet<>();
        Stream.of(gems).forEach(x -> set.add(x));
        int n = set.size();

        if (n == 1) {
            result.add(new ArrayList<>(Arrays.asList(1, 1)));
            return result.get(0);
        }

        Hashtable<String, Integer> ht = new Hashtable<>();
        boolean isCandidate = false;

        int left = 0;
        int right = 0;
        ht.put(gems[0], 1);

        while (true) {
            if (isCandidate == false) {
                right += 1;
                if (right >= gems.length) {
                    break;
                }

                if (ht.containsKey(gems[right]) == false) { // 현재 위치에 보석이 해시테이블에 없으면
                    ht.put(gems[right], 1); // 해시테이블에 보석을 넣고 1개 있다는 표시
                } else {
                    ht.put(gems[right], ht.get(gems[right]) + 1); // 현재 위치에 보석이 해시테이블에 있으면 1 증가시켜서 넣기
                }

                if (ht.size() == n) {
                    isCandidate = true;
                    result.add(new ArrayList<>(Arrays.asList(left + 1, right + 1)));
                }
            } else {
                left += 1;
                int cnt = ht.get(gems[left - 1]) - 1;

                if (cnt == 0) {
                    ht.remove(gems[left - 1]);
                    isCandidate = false;
                } else {
                    ht.put(gems[left - 1], cnt);
                    result.add(new ArrayList<>(Arrays.asList(left + 1, right + 1)));
                }
            }
        }

        int minIdx = 0;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> cur = result.get(i);
            left = cur.get(0);
            right = cur.get(1);

            if (right - left < minNum) {
                minNum = right - left;
                minIdx = i;
            }
        }

        return result.get(minIdx);
    }

    public static void main(String[] args) {
        // Test Code
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(solution(gems));

        gems = new String[]{"AA", "AB", "AC", "AA", "AC"};
        System.out.println(solution(gems));

        gems = new String[]{"XYZ", "XYZ", "XYZ"};
        System.out.println(solution(gems));

        gems = new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        System.out.println(solution(gems));
    }
}
