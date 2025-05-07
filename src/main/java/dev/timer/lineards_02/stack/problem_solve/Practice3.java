package dev.timer.lineards_02.stack.problem_solve;

// 후위표기법 연산
// 참고 설명) 전위/중위/후위 표기법

// 입출력 예시)
// 입력 : "2 2 +"
// 출력 : 4

// 입력 : "2 2 -"
// 출력 : 0

import java.util.Stack;

public class Practice3 {

    public static double calculate(String str) {
        Stack<Double> stack = new Stack();

        for (String s : str.split(" ")) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                stack.push(1 / stack.pop() * stack.pop());
            } else {
                stack.push(Double.parseDouble(s)); // 연산자가 아닌 숫자는 그대로 stack에 push
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        // Test Code
        System.out.println(calculate("2 2 +")); // 4
        System.out.println(calculate("2 2 -")); // 0
        System.out.println(calculate("2 2 *")); // 4
        System.out.println(calculate("2 2 /")); // 1

        System.out.println(calculate("1 1 + 2 * 3 * 2 / 5 -")); // 1
        System.out.println(calculate("5 2 * 3 - 8 * 4 /")); // 14
    }
}
