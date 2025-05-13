package dev.timer.nonlineards_03.tree;

// 배열을 이용한 이진 트리 구성, 순회

class BinaryTree {
    char[] arr;

    BinaryTree(char[] data) {
        this.arr = data.clone();
    }

    public void preOrder(int idx) { // 현재 -> 왼쪽 -> 오른쪽 (전위 순회)
        System.out.print(this.arr[idx] + " ");

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if (left < this.arr.length) { // 자식 노드가 있으면
            this.preOrder(left); // 왼쪽 자식 노드 출력
        }

        if (right < this.arr.length) { // 자식 노드가 있으면
            this.preOrder(right); // 오른쪽 자식 노드 출력
        }
    }

    public void inOrder(int idx) { // 왼쪽 -> 현재 -> 오른쪽 (중위 순회)
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < this.arr.length) {
            this.inOrder(left);
        }

        System.out.print(this.arr[idx] + " ");

        if (right < this.arr.length) {
            this.inOrder(right);
        }
    }

    public void postOrder(int idx) { // 왼쪽 -> 오른쪽 -> 현재 (후위 순회)
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < this.arr.length) {
            this.postOrder(left);
        }

        if (right < this.arr.length) {
            this.postOrder(right);
        }

        System.out.print(this.arr[idx] + " ");
    }

    public void levelOrder(int idx) {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class Practice1 {

    public static void main(String[] args) {
        // Test Code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) { // 들어오는 데이터를 순서대로 배열에 넣는 형태를 예시로
            arr[i] = (char) ('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== PreOrder ==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("== InOrder ==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("== PostOrder ==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("== LevelOrder ==");
        bt.levelOrder(0);
        System.out.println();
    }
}
