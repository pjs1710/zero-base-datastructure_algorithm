package dev.basic.ds.stack.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 문제풀이 2번 :
 *
 * ()로 이루어진 문자열을 받습니다. '('과 ')'이 붙어있다면 한 쌍이며,
 * 입력받은 문자열이 온전한 쌍으로만 이루어져있으면 true를 아니면 false를 출력해주세요.
 */

public class Practice2 {

    // 내 풀이
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//
//        Stack<Character> stack = new Stack<>();
//        boolean result = false;
//        for (char item : input.toCharArray()) {
//            if (item == ')') {
//                if (stack.isEmpty()) {
//                    System.out.println(result);
//                    return;
//                } else if (stack.peek() == '(') {
//                    stack.pop();
//                }
//            } else {
//                stack.push(item);
//            }
//        }
//        result = true;
//        System.out.println(result);
//    }

    // 강사님 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char item : input.toCharArray()) {
            if (item == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            stack.push(item);
        }
        System.out.println(stack.isEmpty());
    }
}
