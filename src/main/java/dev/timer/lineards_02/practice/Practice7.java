package dev.timer.lineards_02.practice;

import java.util.ArrayList;
import java.util.Stack;

public class Practice7 {

    public static void solution(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<String> result = new ArrayList<>(); // stack push, pop할 때 +-를 담을 ArrayList 변수

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num > idx) {
                for (int j = idx + 1; j < num + 1; j++) {
                    stack.push(j);
                    result.add("+");
                }
                idx = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            result.add("-");
        }

        for (String item : result) {
            System.out.print(item);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Code
        int[] nums = {4, 3, 6, 8, 7, 5, 2, 1};
        solution(nums);

        System.out.println("=====");
        nums = new int[]{1, 2, 5, 3, 4};
        solution(nums);
    }
}
