package dev.timer.lineards_02.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        Deque deque = new ArrayDeque();

        // Front 부분 입력
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque);

        // Rear 부분 입력
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);
        System.out.println(deque);

        // Front 부분 입력
        System.out.println(deque.removeFirst());
        System.out.println(deque);

        // Rear 부분 입력
        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque);

        System.out.println(deque.pollLast()); // null 출력
        System.out.println(deque.removeLast()); // error 발생

    }
}
