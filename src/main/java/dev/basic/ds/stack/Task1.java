package dev.basic.ds.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 과제 1번 :
 *
 * 중위 표현식을 후위 표현식으로 변환하는 코드를 만들어보세요.
 *
 * ex) 5+2-1 > 52+1-
 *
 * 1. 숫자 1자리 수
 * 2. + - * / 동일한 우선순위
 */

public class Task1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (char item : input.toCharArray()) {
            if ('0' <= item && item <= '9') {
                sb.append(item);
            } else { // 연산자일때
                if (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                stack.push(item);
            }
        }

        if (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }
}
