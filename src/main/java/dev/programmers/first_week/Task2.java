package dev.programmers.first_week;

import java.io.*;
import java.util.*;

/**
 * 5주차 문제 2번 :
 *
 * 촘촘이는 무엇이든 연속으로 가득찬 것을 좋아한다. 이번에 촘촘이가 빠진 취미는 빠짐없이 연속된 숫자를 모으는 것이다.
 * 촘촘이는 연속된 숫자가 무작위 순서로 배치된 배열 numbers를 입력받았다.
 * 이 배열에는 최소한 하나 이상 비어있는 숫자가 있으며, 배열에서 가장 작은 숫자는 알려져 있지 않다.
 * 배열에서 비어있는 숫자 중, 가장 작은 숫자를 출력하는 프로그램을 작성하시오.
 *
 * 0 <= numbers[i] <= 100000
 * 2 <= numbers.length <= 100000
 *
 * numbers : 9 4 2 3 7 5
 * 출력 : 6
 */

public class Task2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int size = data.length;
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }

        Arrays.stream(numbers).sorted();

        //* TODO : while 순회하면서 다음 값이 +1만큼 값(연속된 값)인지 확인 && 최소한 하나 이상 비어있는지 확인(비어있지 않다면 -1 반환)
        //* 비어있는 수들은 따로 배열에 저장해두고 마지막에 min 값 반환
        int result = solution(numbers);
        System.out.println(result);

    }

    public static int solution(int[] numbers) {
        int[] emptyArr = new int[numbers.length];
        int idx = 0, firstIdx = 0, nextIdx = 1;
        int firstValue;
        while (nextIdx != numbers.length) {
            firstValue = numbers[firstIdx];
            if (!(firstValue + 1 == numbers[nextIdx])) {
                emptyArr[idx++] = firstValue + 1;
            }
            firstIdx++;
            nextIdx++;
        }

        if (idx > 0) {
            return emptyArr[0]; // 오름차순 정렬해서 최소값은 0번째임
        } else {
            return -1;
        }
    }
}
