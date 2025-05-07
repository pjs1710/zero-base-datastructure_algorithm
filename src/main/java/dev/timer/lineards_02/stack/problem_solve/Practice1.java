package dev.timer.lineards_02.stack.problem_solve;

// 문자열 뒤집기

// 입출력 예시)
// 입력 : "Hello"
// 출력 : "olleH"

// 입력 : 1 3 5 7 9
// 출력 : 9 7 5 3 1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Practice1 {

    // 강사님 풀이
//    public static String reverseString(String str) {
//        Stack stack = new Stack();
//        String result = "";
//
//        for (String s : str.split("")) {
//            stack.push(s);
//        }
//
//        while (!stack.isEmpty()) {
//            result += stack.pop();
//        }
//
//        return result;
//    }

    // 내 풀이
    public static String reverseString(String str) {
        Stack stack = new Stack();
        String[] arr = str.split(""); // str 문자열을 한 글자씩 쪼개서 arr 배열에 담기
        String result = "";

        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]); // stack에 문자열들이 담기는데 역순으로 담김 hello -> olleh 순으로
        }

        if (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                result += stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {

        // Test Code
        String result = reverseString("Hello");
        System.out.println("result = " + result);

        result = reverseString("1 3 5 7 9");
        System.out.println("result = " + result);
    }
}
