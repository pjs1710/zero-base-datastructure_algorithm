package dev.timer.lineards_02.stack.problem_solve;

// 괄호 짝 검사

// 입출력 예시)
// 입력 : "("
// 출력 : Fail

// 입력 : ")"
// 출력 : Fail

// 입력 : "()"
// 출력 : Pass

import java.util.Stack;

public class Practice2 {

    //        // 내 풀이
    //    public static void checkParenthesis(String str) {
//        int cnt1 = 0;
//        int cnt2 = 0;
//
//        String[] arr = str.split("");
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i].equals("(")) {
//                cnt1++;
//            } else if (arr[i].equals(")")) {
//                cnt2++;
//            }
//        }
//
//        if (cnt1 == cnt2) {
//            System.out.println("Pass!");
//        } else {
//            System.out.println("Fail!");
//        }
//    }
    public static void checkParenthesis(String str) {
        Stack stack = new Stack<>();
        boolean checkFlag = true;

        for (String s : str.split("")) {
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.isEmpty()) {
                    checkFlag = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (checkFlag && stack.isEmpty()) {
            System.out.println("Pass!");
        } else {
            System.out.println("Fail!");
        }
    }

    public static void main(String[] args) {

        // Test Code
        checkParenthesis("("); // Fail!
        checkParenthesis(")"); // Fail!
        checkParenthesis("()"); // Pass!
        checkParenthesis("()()()"); // Pass!
        checkParenthesis("(())()"); // Pass!
        checkParenthesis("(((()))"); // Fail!
    }
}
