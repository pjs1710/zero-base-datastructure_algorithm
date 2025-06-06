package dev.basic.ds.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 과제 2번 :
 *
 * 중위 표현식을 후위 표현식으로
 * 우선순위 고려해서 구현해보세요.
 */
public class Task2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char item : input.toCharArray()) {
            if ('0' <= item && item <= '9') {
                sb.append(item);
            } else { // 연산자일때
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(item)) {
                    sb.append(stack.pop());
                }
                stack.push(item);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    private static int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 0;
        }
        if (ch == '*' || ch == '/') {
            return 1;
        }
        return -1;
    }
}
