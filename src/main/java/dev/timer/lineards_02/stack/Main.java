package dev.timer.lineards_02.stack;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.peek()); // 가장 마지막에 있는 스택을 반환
        System.out.println(stack); // 스택에 있는 데이터를 pop하진 않음

        System.out.println(stack.contains(1)); // 1이 있으면 true
        System.out.println(stack.size());
        System.out.println(stack.empty());

        stack.clear();
        System.out.println(stack);
        stack.pop(); // EmptyStackException 발생!
    }
}
