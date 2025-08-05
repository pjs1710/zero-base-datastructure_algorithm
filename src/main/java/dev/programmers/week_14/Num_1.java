package dev.programmers.week_14;

import java.io.*;
import java.util.*;

/**
 * 일원이는 큰 뜻을 품고, 주식 자동 트레이딩 프로그램을 만들어 대박을 내려고 한다.
 * 자동 트레이딩을 하기 위해, 수집한 방대한 양의 주가 데이터를 분석해 가장 오랫동안 '우상향'하는 부분을 찾아내고자 한다.
 * 시간 순으로 나열된 주가 데이터 values 배열에서 가장 오랫동안 단조 증가가 이루어진 구간을 찾아 {시작인덱스, 끝인덱스}의 형식으로 출력하시오.
 * 단, 단조 증가란 시작인덱스 <= i < 끝인덱스 에서 values[i] < values[i + 1]인 경우를 말한다.
 * 동일 길이의 구간이 여러번 나타날 경우, 가장 먽저 나온 구간으로 출력하시오.
 * 또한, 전체 구간에서 단조 증가하는 구간이 없는 경우 {0, 0}으로 출력하시오.
 *
 * 입력 :
 * values = {103, 152, 124, 165, 152, 154, 159, 160, 200, 195, 205, 206, 204, 189, 156}
 *
 * 결과 :
 * {4, 8}
 */

public class Num_1 {

    public static int[] solution(int[] values) {
        if (values == null || values.length < 2) {
            return new int[]{0, 0};
        }

        int maxLength = 0;
        int bestStart = 0;
        int bestEnd = 0;

        int currentStart = 0;
        int currentLength = 0;

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] < values[i + 1]) {
                if (currentLength == 0) {
                    currentStart = i;
                }
                currentLength++;

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    bestStart = currentStart;
                    bestEnd = i + 1;
                }
            } else {
                currentLength = 0;
            }
        }

        if (maxLength == 0) {
            return new int[]{0, 0};
        }

        return new int[]{bestStart, bestEnd};
    }

    public static void main(String[] args) {

    }
}
