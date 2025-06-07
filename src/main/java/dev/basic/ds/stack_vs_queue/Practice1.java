package dev.basic.ds.stack_vs_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문제풀이 1번 :
 *
 * 스택 2개를 이용해서, 오름차순 정렬을 해보세요.
 *
 * 5 6 1 3 2 4 -> 1 2 3 4 5 6
 */

public class Practice1 {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> processStack = new Stack<>();

        while (!stack.isEmpty()) {
            int now = stack.pop();

            while (!processStack.isEmpty() && processStack.peek() > now) {
                stack.push(processStack.pop());
            }
            processStack.push(now);
        }

        while (!processStack.isEmpty()) {
            stack.push(processStack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String value : data) {
            stack.push(Integer.parseInt(value));
        }
        // TODO stack 정렬
        sortStack(stack);

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
