package dev.basic.ds.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 과제 1번 :
 *
 * 스택 2개로 큐를 구현해보세요.
 */

public class Task1 {

    public static class Queue {
        private Stack<Integer> saveStack;
        private Stack<Integer> likeQueue;

        public Queue() {
            this.saveStack = new Stack<>();
            this.likeQueue = new Stack<>();
        }

        public void enqueue(int value) {
            this.saveStack.push(value);
        }

        public int dequeue() {
            if (likeQueue.isEmpty() && !saveStackToLikeQueue()) {
                return -1;
            }

            return likeQueue.pop();
        }

        public int peek() {
            if (likeQueue.isEmpty() && !saveStackToLikeQueue()) {
                return -1;
            }

            return likeQueue.peek();
        }

        private boolean saveStackToLikeQueue() {
            if (saveStack.isEmpty()) {
                System.out.println("큐가 비어있습니다.");
                return false;
            }

            while (!saveStack.isEmpty()) {
                likeQueue.push(saveStack.pop());
            }
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
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
