package dev.basic.ds.stack;

public class Main {

    public static class Stack {
        private int[] data;
        private int top;        // 최상위 데이터의 인덱스 값
        private int size;

        public Stack() {
            this.size = 0;
            this.data = new int[10];
            top = -1;
        }

        public void push(int data) {
            if (isFull()) {
                System.out.println("스택이 가득 찼습니다.");
                return;
            }
            this.data[++top] = data;
            this.size++;
        }

        public void pop() {
            if (isEmpty()) {
                System.out.println("현재 스택이 비어있습니다.");
                return;
            }
            top--;
            this.size--;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("현재 스택이 비어있습니다.");
                return -1;
            }
            return this.data[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == data.length - 1;
        }

        public void printStack() {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i <= top; i++) {
                sb.append(data[i]).append(" ");
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack();

        stack.pop();
        stack.printStack();

        System.out.println(stack.isEmpty());

        stack.pop();
        stack.pop();
        stack.pop(); // 현재 스택이 비어있습니다.

        stack.push(5);
        System.out.println(stack.peek());

        for (int i = 1; i < 10; i++) {
            stack.push(i);
        }
        stack.printStack();
        System.out.println(stack.isFull());
        stack.push(100); // 스택이 가득 찼습니다.

    }
}
