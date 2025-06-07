package dev.basic.ds.queue;

import java.util.LinkedList;

/**
 * 과제 2번 :
 *
 * 배열이 아닌 리스트로 큐를 구현해보세요.
 */

public class Task2 {

    public static class Queue {
        private LinkedList<Integer> list;

        public Queue() {
            list = new LinkedList<>();
        }

        public void enqueue(int value) {
            list.addLast(value);
        }

        public int dequeue() {
            if (list.isEmpty()) {
                System.out.println("큐가 비어있습니다.");
                return -1;
            }
            return list.removeFirst();
        }

        public int peek() {
            if (list.isEmpty()) {
                System.out.println("큐가 비어있습니다.");
                return -1;
            }
            return list.getFirst();
        }
    }

    public static void main(String[] args) {

        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue()); // 1 (제거되면서)
        System.out.println(queue.peek()); // 2 (제거 X)
        queue.enqueue(4); // 2 3 4

        System.out.println(queue.dequeue()); // 2 (제거되면서)
        System.out.println(queue.dequeue()); // 3 (제거되면서) likeQueue 비어있음
        System.out.println(queue.dequeue()); // 4 saveStack에서 likeQueue로 이동
        System.out.println(queue.dequeue()); // Error or -1
    }
}
