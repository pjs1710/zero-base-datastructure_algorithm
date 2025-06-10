package dev.programmers.first_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 선택 과제 1번 :
 *
 * 병선이는 압축된 문자열 code의 압축을 해제하는 프로그램을 작성하려고 한다. code는 기본적으로 다음과 같이 압축되어 있다.
 * - n{알파벳_문자열} -> 알파벳_문자열을 n번 만큼 반복
 * 즉, 3{abc}e는 abcabcabce로 압축을 해제할 수 있다.
 * 병선이는 압축 효율을 높이고자, 위 방법을 다중으로 사용하기로 하였다.
 * 즉, f2{a3{bc}}z는 f2{abcbcbc}z -> fabcbcbcabcbcbcz로 압축을 해제할 수 있다.
 * 압축된 문자열 code를 입력받아 압축을 해제하여 문자열로 출력하시오.
 *
 * 문자열 반복 횟수인 n은 한자리 자연수
 * 0 < code.length <= 10000
 * code[i]는 영문 소문자
 *
 */

public class SelectiveTask1 {

    public static String solution(String code) {
        if (code == null || code.isEmpty()) {
            return "No Result";
        }
        StringBuilder sb = new StringBuilder();
        char[] data = code.toCharArray(); // 하나씩 담기
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>(); // 숫자를 스택에 담아놨다가 꺼내서 해당 값만큼 반복
        int num = 0;

        for (char item : data) {
            if ('0' <= item && '9' >= item) { // 숫자인 경우
                num = item - '0'; // ASCII 계산
            } else if (item == '{') { // 반복 시작하는 구간
                numStack.push(num); // 숫자가 있다면 0~9사이 값. 없다면 0으로 반복 안하도록
                stringStack.push(sb.toString()); // 만약에 처음으로 {를 만났다면, 빈 문자열이 push됨 sb는 위에서 방금 초기화 해서
                sb = new StringBuilder(); // push하고 나서 sb는 다시 초기화 해줘야 다음 {를 만났을 때 중복되는 버그 X
                num = 0; // 마찬가지로 num도 0으로 초기화
            } else if (item == '}') { // 반복 끝나는 구간
                String s = sb.toString(); // sb에 담긴 문자열을 반복해서 다시 담아야함
                sb = new StringBuilder(stringStack.pop()); // 스택에 저장한 문자열을 다시 뽑아서 앞에 붙여줘야함
                int cnt = numStack.pop(); // 반복할 수

                for (int i = 0; i < cnt; i++) {
                    sb.append(s); // 반복할 수만큼 sb에 담기
                }
            } else {
                sb.append(item); // 그냥 문자열들은 sb에 다 담아야됨
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split("");
        String code = String.join("", data);

        System.out.println(solution(code));
    }
}
