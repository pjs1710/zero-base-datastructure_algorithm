package dev.basic.ds.queue.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제풀이 2번 :
 *
 * 사용자에게 1부터 N까지의 값을 입력 받습니다.
 * 한 라운드를 지날 때마다 값은 10배 증가하며, M의 값 이하의 값만 표출합니다.
 * 각 라운드의 숫자와 개수, 값을 출력합니다.
 *
 *  sol : 1 2 3 4 5 6 값을 넣고
 *  poll 하면서 1 * 10한 value를 다시 offer 한다.
 *  만약 value * 10한 값이 M보다 크다면 continue를 진행한다.
 */

public class Practice2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]); // 1 ~ N
        int M = Integer.parseInt(data[1]); // M 이하의 값만 저장

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int round = 1;
        while (!queue.isEmpty()) {
            sb.append(round).append("(").append(queue.size()).append(") : ");

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int value = queue.poll();
                sb.append(value).append(" ");
                if (value * 10 > M) {
                    continue;
                }

                queue.offer(value * 10);
            }

            round++;
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
