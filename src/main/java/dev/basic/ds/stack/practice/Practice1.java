package dev.basic.ds.stack.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문제풀이 1번 :
 *
 * 사용자한테 단어를 입력받고, 스택을 활용해 단어의 순서를 뒤집는 프로그램을 만들어보세요.
 */

public class Practice1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char item : input.toCharArray()) {
            stack.push(item);
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
}
