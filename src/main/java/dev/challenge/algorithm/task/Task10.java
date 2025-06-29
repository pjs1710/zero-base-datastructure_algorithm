package dev.challenge.algorithm.task;

import java.io.*;
import java.util.*;

/**
 * 8주차 문제 10번 :
 *
 * 마크업 문서는 태그와 영문자, 그리고 공백으로 이루어져 있다.
 * 문서 도중에 <태그명>으로 작성된 부분은 태그의 시작 부분이 된다.
 * - 태그명은 영문자로 이루어져 있으며, 대소문자를 구분하지 않는다.
 * - 태그명의 길이는 1이상 9이하만 허용된다.
 * 문서 도중에 </태그명>으로 작성된 부분은 태그의 끝 부분이 된다.
 * - 시작한 태그는 반드시 문서 내에서 끝나야 한다.
 * 태그의 시작과 끝 사이를 태그의 내부라고 한다.
 * 태그는 중첩이 가능하다.
 * - 태그의 내부에 다른 태그가 있다면, 그것을 태그가 중첩되었다고 한다.
 * - 예를 들어 <A> this is <B> nested tag </B> </A>는 A태그 안에 B 태그가 중첩된 것이다.
 * 태그는 교차가 불가능하다.
 * - 어떤 태그가 그 태그의 내부에서 시작된 태그보다 먼저 끝나는 것을 태그가 교차되었다고 한다.
 * - 이 마크업 언어에서는 태그의 교차를 허용하지 않는다.
 * - 예를 들어 <A> this is <B> crossed tag </A> </B>는 A태그가 B태그와 교차된 것이다.
 *
 * 주어진 마크업 문서 s를 분석하여, 태그가 올바르게 작성되었는지 여부를 논리형으로 반환하시오.
 *
 * 예시 입력 :
 * s = "<DIV> My first article <SPAN>full of insightful</SPAN> quotes</DIV>"
 *
 * 반환값 :
 * true
 */

public class Task10 {

    public static boolean solution(String s) {
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == '<') {
                int close = s.indexOf('>', i);
                if (close == -1) {
                    return false;
                }

                String content = s.substring(i + 1, close).trim();
                boolean isEnd = content.startsWith("/");
                String tagName = isEnd ? content.substring(1) : content;

                if (tagName.length() < 1 || tagName.length() > 9) {
                    return false;
                }
                if (!tagName.matches("[a-zA-Z]+")) { // 정규형
                    return false;
                }

                tagName = tagName.toUpperCase();

                if (isEnd) {
                    if (stack.isEmpty() || !stack.peek().equals(tagName)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(tagName);
                }
                i = close + 1;
            } else {
                i++;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
