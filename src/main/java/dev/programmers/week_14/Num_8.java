package dev.programmers.week_14;

import java.util.*;

/**
 * 당신은 네트워크 전문가로, 회사의 모든 IP 주소를 관리하고 있다.
 * 어느날 신입으로 들어온 사원이 사색이 되어 진땀을 흘리고 있는 모습을 보게 되었다.
 * 어깨너머로 보니 사내의 모든 IP주소에서 구두점(.)을 실수로 삭제한 것으로 보인다.
 * 당신은 수작업으로 IP주소를 하나하나 복구하고 있는 신입사원을 복고, 몰래 프로그램을 만들어 도와주기로 마음 먹었다.
 * 프로그램의 입력은 숫자만으로 이루어진 문자열이며 (ex. "2552552551")
 * 프로그램의 출력은 이 문자열에 .을 3개 끼워 넣어 가능한 모든 IP 주소를 나열한 배열이다.
 * IP 주소의 각 숫자는 0이상 255이하의 숫자로만 이루어지며, 숫자 앞에 붙는 0(leading zero)는 허용되지 않는다.
 * 결과 배열은 문자열 오름차순으로 정렬하여 출력하시오.
 * 4 <= s.length <= 12
 *
 * 입력 :
 * s = "11011"
 * 결과 :
 * {"1.1.0.11", "1.10.1.1", "11.0.1.1"}
 */

public class Num_8 {

    public static String[] solution(String s) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= 3 && i < s.length(); i++) {
            for (int j = i + 1; j <= i + 3 && j < s.length(); j++) {
                for (int k = j + 1; k <= j + 3 && k < s.length(); k++) {
                    String part1 = s.substring(0, i);
                    String part2 = s.substring(i, j);
                    String part3 = s.substring(j, k);
                    String part4 = s.substring(k);

                    if (isValid(part1) && isValid(part2) && isValid(part3) && isValid(part4)) {
                        result.add(part1 + "." + part2 + "." + part3 + "." + part4);
                    }
                }
            }
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private static boolean isValid(String part) {
        if (part.length() == 0 || part.length() > 3) {
            return false;
        }
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {

    }
}
