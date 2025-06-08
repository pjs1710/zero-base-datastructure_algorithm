package dev.programmers.first_week;

import java.util.*;
import java.io.*;

/**
 *  5주차 문제 7번 :
 *
 * 4가지 종류의 괄호가 있다.
 * 각 괄호들은 서로 짝이 있으며 그 짝은 괄호가 열리고 닫히는 것을 의미한다.
 * ( ), { }, [ ], < >,
 * 이때 주어진 문자열 S가 괄호가 서로 교차하지 않은 형태로 짝이 잘 맞게 이루어진 문자열인지 판단하여 맞으면 1, 틀리면 0으로 반환하는 프로그램을 구현하세요.
 *
 * 예시 입력 :
 * (()){[<>]}
 * 출력 : 1
 *
 * ({)}[<]>
 * 출력 : 0
 */

public class Task7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        // Stack에 여는 괄호를 넣고, 닫는 괄호가 나왔을 때 짝이 맞는지 확인하고 아니면 땡
        int result = solution(S);
        System.out.println(result);
    }

    public static int solution(String S) {
        String[] data = S.split("");
        Stack<String> stack = new Stack<>();
        while (true) {
            for (int i = 0; i < data.length; i++) {
                if (data[i].equals("(") || data[i].equals("{") || data[i].equals("[") || data[i].equals("<")) {
                    stack.push(data[i]);
                } else if (data[i].equals(")")) {
                    if (stack.peek().equals("(")) {
                        stack.pop(); // ( 다음에 )이 오면 ( 꺼내기
                    } else {
                        return 0; // 안 맞으면 바로 0 리턴
                    }
                } else if (data[i].equals("}")) {
                    if (stack.peek().equals("{")) {
                        stack.pop();
                    } else {
                        return 0;
                    }
                } else if (data[i].equals("]")) {
                    if (stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        return 0;
                    }
                } else if (data[i].equals(">")) {
                    if (stack.peek().equals("<")) {
                        stack.pop();
                    } else {
                        return 0;
                    }
                }
            }
            if (stack.isEmpty()) {
                return 1;
            }
        }
    }
}
