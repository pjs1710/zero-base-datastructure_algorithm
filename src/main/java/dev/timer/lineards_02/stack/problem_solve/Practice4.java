package dev.timer.lineards_02.stack.problem_solve;

// 두 문자열 비교
// 단, #은 backspace로 바로 이전의 문자를 삭제하는 기능이라고 가정

// 입출력 예시
// 입력 : s1 = "tree", s2 = "th#ree"
// 출력 : true

// 입력 : s1 = "ab#a", s2 = "aab#"
// 출력 : true

// 입력 : s1 = "wo#w", s2 = "ww#o"
// 출력 : false

import java.util.Stack;

public class Practice4 {

    // 내 풀이 (refactoring 전)
//    public static boolean stringCompare(String s1, String s2) {
//        Stack stack1 = new Stack();
//        Stack stack2 = new Stack();
//        for (String s : s1.split("")) {
//            if (s.equals("#")) {
//                if (!stack1.isEmpty()) {
//                    stack1.pop();
//                }
//            } else {
//                stack1.push(s);
//            }
//        }
//        for (String s : s2.split("")) {
//            if (s.equals("#")) {
//                if (!stack2.isEmpty()) {
//                    stack2.pop();
//                }
//            } else {
//                stack2.push(s);
//            }
//        }
//        return stack1.equals(stack2);
//    }

    // 내 풀이 (refactoring 후)
    public static boolean stringCompare(String s1, String s2) {
        String s1Result = processBackspace(s1);
        String s2Result = processBackspace(s2);

        return s1Result.equals(s2Result);
    }

    // #을 만나면 pop, 아니라면 push하는 메서드 추출
    private static String processBackspace(String str) {
        Stack stack = new Stack();

        for (String s : str.split("")) {
            if (s.equals("#")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        return String.valueOf(stack);
    }

//    // 강사님 풀이
//    public static boolean stringCompare(String s1, String s2) {
//        String s1After = doBackSpace(s1);
//        String s2After = doBackSpace(s2);
//
//        return s1After.equals(s2After);
//    }
//
//    // # 제거 밑 push하는 메서드 추출
//    private static String doBackSpace(String str) {
//        Stack stack = new Stack();
//
//        for (String s : str.split("")) {
//            if (s.equals("#")) {
//                if (!stack.isEmpty()) {
//                    stack.pop();
//                }
//            } else {
//                stack.push(s);
//            }
//        }
//        return String.valueOf(stack);
//    }


    public static void main(String[] args) {

        // Test Code
        String s1 = "tree";
        String s2 = "th#ree";
        System.out.println(stringCompare(s1, s2)); // true

        s1 = "ab#a";
        s2 = "aab#";
        System.out.println(stringCompare(s1, s2)); // true

        s1 = "wo#w";
        s2 = "ww#o";
        System.out.println(stringCompare(s1, s2)); // false
    }
}
