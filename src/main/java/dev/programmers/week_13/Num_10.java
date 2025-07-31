package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 시작 가사 일부를 입력 받아, 해당 가사와 일치하는 모든 노래를 빠르게 찾는 프로그램을 만들기로 했다.
 * 프로그램이 동작하는 조건은 아래와 같다.
 * - 문제로 출제될 노래는 미리 선정된 N개의 노래 중에서 출제하기로 했다.
 * - 길이가 N인 배열 titles에는 각 노래의 제목이 적혀있다.
 * - 길이가 N인 배열 lyrics에는 각 노래의 가사가 공백 없이 적혀 있다.
 * - 총 M개의 문제를 한번에 해결한다.
 * - 길이가 M인 배열 problems에는 시작 가사 일부가 공백 없이 적혀있다.
 * 프로그램은 각 문제에 대한 M개의 답을 배열로 반환한다.
 * - 각 문제에 대한 답은 시작 가사가 일치하는 모든 노래의 제목을 배열로 나열한 것이다.
 * -- 해당 배열 내 노래 제목의 순서는 titles 배열에 나타난 순서를 따른다.
 * - 즉, 최종 출력은 2차원 문자열 배열로 이루어진다.(M개의 문제에 대해 가사가 일치하는 제목)
 *
 * 입력 :
 * titles = {"", "", ...}
 * lyrics = {"", "", ...}
 * problems = {"", "", "", ...}
 *
 * 결과 :
 * {{"", ""}, {""}, {}}
 */

public class Num_10 {

    public static String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[][] result = new String[problems.length][];

        for (int i = 0; i < problems.length; i++) {
            String problem = problems[i];
            List<String> matchingTitles = new ArrayList<>();

            for (int j = 0; j < lyrics.length; j++) {
                String lyric = lyrics[j];

                if (lyric.startsWith(problem)) {
                    matchingTitles.add(titles[j]);
                }
            }

            result[i] = matchingTitles.toArray(new String[matchingTitles.size()]);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
