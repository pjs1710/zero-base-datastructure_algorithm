package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 윤식이는 검색 엔진 개발자로, 단어를 검색하는 프로그램을 만들어 달라는 의뢰를 받았다.
 *
 * 윤식이의 클라이언트는 아래와 같은 방식으로 단어를 검색하고 싶어 한다.
 * - words에 검색 대상이 되는 단어 풀이 배열로 주어진다.
 * - queries에 검색하고자 하는 검색어들이 배열로 주어진다.
 * -- 검색하고자 하는 입력은 "[알파벳][? 여러개]"로 주어진다.
 * -- 예를 들어, "hel??"로 검색한 경우, "hello"는 검색 대상이 되지만, "hell"은 검색 대상이 되지 않는다.
 * -- 검색어의 검색 결과는 검색 대상이 되는 모든 단어를 words에 나타난 순서대로 하는 배열이다.
 * 프로그램의 출력은 각 검색어에 대한 결과(문자열 배열)를 모아 2차원 배열로 반환한다.
 * 프로그램을 구현하시오. (검색어에서 ?는 반드시 한 개 이상 존재한다.)
 *
 * 입력 :
 * words = {"hello", "hear", "hell", "good", "goose", "children", "card", "teachable"}
 * queries = {"he??", "g???", "childre?", "goo????", "?"}
 *
 * 결과 :
 * {{"hear", "hell"}, {"good"}, {"children"}, {}, {}}
 */

public class Num_11 {

    public static String[][] solution(String[] words, String[] queries) {
        String[][] result = new String[queries.length][];

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            List<String> matchingWords = new ArrayList<>();

            for (String word : words) {
                if (isMatch(word, query)) {
                    matchingWords.add(word);
                }
            }

            result[i] = matchingWords.toArray(new String[matchingWords.size()]);
        }

        return result;
    }

    public static boolean isMatch(String word, String query) {
        if (word.length() != query.length()) {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            char queryChar = query.charAt(i);

            if (queryChar != '?' && wordChar != queryChar) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
