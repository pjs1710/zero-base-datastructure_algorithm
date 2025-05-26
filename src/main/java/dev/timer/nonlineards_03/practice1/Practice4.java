package dev.timer.nonlineards_03.practice1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Practice4 {

    public static int solution(String[] deadends, String target) {
        if (target == null || target.length() == 0) {
            return -1;
        }

        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curNum = queue.poll(); // 현재 자물쇠 번호
                if (!visited.add(curNum)) { // HashSet에 curNum을 넣으려고 했는데 이미 들어가있는 수라면?
                    continue;
                }

                if (curNum.equals(target)) {
                    return cnt;
                }

                for (String nextNum : getNextNums(curNum.toCharArray())) { // 현재 자물쇠 번호에서 이동 가능한 8가지의 경우의 수가 nextNum에 담겨서 for문 순회
                    if (!visited.contains(nextNum)) {
                        queue.offer(nextNum);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public static LinkedList<String> getNextNums(char[] cArr) {
        LinkedList<String> nums = new LinkedList<>();
        for (int i = 0; i < cArr.length; i++) {
            char c = cArr[i];
            // 증가하는 로직
            cArr[i] = c == '9' ? '0' : (char) (c + ((char) 1)); // 9라면 0으로 아니면 해당 수에서 하나 증가한 값으로 ex -> 9 -> 0, 8 -> 9
            nums.add(String.valueOf(cArr));
            // 감소하는 로직
            cArr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
            nums.add(String.valueOf(cArr));
            cArr[i] = c;
        }
        return nums;
    }

    public static void main(String[] args) {
        // Test Code
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        System.out.println(solution(deadends, "0202"));

        deadends = new String[]{"8888"};
        System.out.println(solution(deadends, "0009"));

    }
}
