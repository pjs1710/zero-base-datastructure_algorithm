package dev.timer.lineards_02.stack;

// 배열을 이용한 기본 스택 직접 구현

class MyStack2 {
    int[] arr;
    int top = -1; // 초기 위치 -1로

    MyStack2(int size) {
        arr = new int[size];
    }

    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if (this.top == this.arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int data) {
        if (this.isFull()) {
            System.out.println("Stack is Full!");
            return;
        }

        this.top += 1;
        this.arr[this.top] = data; // 아무 것도 없는 상태일 땐 top = -1이므로 +1해주면 top = 0 -> 첫 번째 인덱스에 데이터 추가
    }

    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty!");
            return null;
        }

        int data = this.arr[this.top];
        this.top -= 1;
        return data;
    }

    public Integer peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty!");
            return null;
        }

        return this.arr[this.top];
    }

    public void printStack() {
        for (int i = 0; i < this.top + 1; i++) { // 초기에 아무 것도 없으면 출력 X 데이터 하나 들어오면 top = 0이므로 this.top + 1 = 1 => 반복문 1번 시행
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}

public class Practice2 {

    public static void main(String[] args) {

        // Test Code
        MyStack2 myStack = new MyStack2(5);

        System.out.println(myStack.isEmpty());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);
        myStack.push(6);
        myStack.printStack(); // 1, 2, 3, 4, 5

        System.out.println(myStack.peek()); // 5
        myStack.printStack(); // 1, 2, 3, 4, 5

        System.out.println(myStack.pop()); // 5
        System.out.println(myStack.pop()); // 4
        myStack.printStack(); // 1, 2, 3

        System.out.println(myStack.pop()); // 3
        System.out.println(myStack.pop()); // 2
        System.out.println(myStack.pop()); // 1
        myStack.printStack();

    }
}
