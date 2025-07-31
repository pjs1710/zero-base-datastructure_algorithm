package dev.programmers.week_13;

import java.io.*;
import java.util.*;

/**
 * 아메바가 분열하여 두 개체로 완전히 나뉘는 데에는 1분이 걸린다.
 * 분열한 아메바 중 하나는 곧바로 분열을 시작하고, 다른 하나는 delay분 동안 휴식 후 분열을 시작한다.
 * 분열하면 기존의 개체는 사라지고 새로운 두 개체가 생긴 것으로 본다.
 * 분열되는 도중에는 기존의 개체가 남아있고, 아직 새로운 개체가 생겨나지 않은 것으로 본다.
 * 종찬이는 아메바 한 개체를 분열 시키기 시작한 후, N분 후까지 만들어진 모든 아메바 개체에 새로운 이름을 지어주기로 했다.
 * 종찬이가 준비해야 하는 아메바의 이름은 총 몇 개인가?
 *
 * 입력 :
 * delay = 1
 * N = 2
 *
 * 결과 :
 * return = 5
 */

public class Num_8 {

    static int delay;
    static int N;

    public static int solution(int delay, int N) {
        int totalAmoebas = 1;

        Map<Integer, Integer> newAmoebas = new HashMap<>();
        newAmoebas.put(1, 1);

        for (int time = 1; time <= N; time++) {
            if (newAmoebas.containsKey(time)) {
                int splittingCount = newAmoebas.get(time);
                int newlyCreated = splittingCount * 2;
                totalAmoebas += newlyCreated;

                if (time + 1 <= N) {
                    newAmoebas.put(time + 1, newAmoebas.getOrDefault(time + 1, 0) + splittingCount);
                }

                if (time + 1 + delay <= N) {
                    newAmoebas.put(time + 1 + delay, newAmoebas.getOrDefault(time + 1 + delay, 0) + splittingCount);
                }
            }
        }

        return totalAmoebas;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        delay = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        System.out.println(solution(delay, N));
    }
}
