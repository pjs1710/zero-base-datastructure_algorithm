package dev.basic.ds.queue.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제풀이 1번 :
 *
 * N개의 인원이 둥글게 앉아있으며, 1번부터 N번의 숫자가 주어져 있습니다.
 * 1번부터 퇴실하며, 다음은 M번 떨어진 인원이 순서대로 퇴실합니다.
 * 이 때, 떨어진 자리는 자리가 아닌 인원으로 판단할 때 퇴실하는 인원의 번호를 순서대로 출력하세요.
 */

public class Practice1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String[] data = br.readLine().split(" "); // data[0]은 인원수, data[1]은 M번 떨어진 인원 퇴실
        int size = Integer.parseInt(data[0]);
        int gap = Integer.parseInt(data[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            queue.offer(i);
        }

        int cnt = 0;
        boolean isFirst = true;
        while (true) {
            if (isFirst) { // 처음에만 실행 -> 처음 값은 무조건 출력
                sb.append(queue.poll()).append(" ");
                cnt++;
                isFirst = false;
            }

            if (!queue.isEmpty()) {
                if (cnt != gap) {
                    int value = queue.poll();
                    queue.offer(value);
                    cnt++;
                } else {
                    sb.append(queue.poll()).append(" ");
                    cnt = 1;
                }
            } else {
                break;
            }
        }

        System.out.println(sb.toString());
    }
}
