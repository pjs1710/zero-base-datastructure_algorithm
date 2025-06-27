package dev.challenge.algorithm;

import java.util.*;

public class Main4 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("호랑이");
        set.add("사자");
        set.add("팬더");
        set.add("고양이");
        set.add("고릴라");

        Set<String> set1 = new LinkedHashSet<>();
        set1.add("호랑이");
        set1.add("사자");
        set1.add("팬더");
        set1.add("고양이");
        set1.add("고릴라");

        Set<String> set2 = new TreeSet<>();
        set2.add("호랑이");
        set2.add("사자");
        set2.add("팬더");
        set2.add("고양이");
        set2.add("고릴라");

        System.out.println(set + "\n" + set1 + "\n" + set2);

        Set<String> set3 = new HashSet<>(List.of("호랑이", "사자", "팬더", "고양이", "고릴라"));
        set3.addAll(List.of("독수리", "송골매")); // Set.of도 가능
        System.out.println(set3);
    }
}
