package dev.timer.nonlineards_03.heap;

// 비선형 자료구조 - 힙
// ArrayList로 최소 힙 구현

import java.util.ArrayList;

class MinHeap {
    ArrayList<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public void insert(int data) {
        heap.add(data);

        int cur = heap.size() - 1; // 방금 넣은 데이터의 인덱스 위치 -> size = 1, cur = 0 -> 0번째 인덱스에 데이터 하나
        while (cur > 1 && heap.get(cur / 2) > heap.get(cur)) { // 부모 노드의 값 > 현재 노드의 값 이면 작은 값이 아래에 있으니까 MinHeap X -> 현재 노드의 값을 부모 노드로 올리는 작업
            int parentVal = heap.get(cur / 2);
            heap.set(cur / 2, data);
            heap.set(cur, parentVal);

            cur /= 2; // 그 위의 부모도 체크
        }
    }

    public Integer delete() {
        if (heap.size() == 1) {
            System.out.println("Heap is Empty!");
            return null;
        }

        int target = heap.get(1); // 상위 데이터 꺼내기

        heap.set(1, heap.get(heap.size() - 1)); // 상위 데이터(루트 노드)와 가장 마지막 데이터를 바꿔줘야 함
        heap.remove(heap.size() - 1); // 루트 노드가 20이고 새로 들어온 데이터가 10이라면 20 위치(루트 노드)에 10 데이터를 추가하고 마지막 데이터 삭제

        int cur = 1;
        while (true) {
            int leftIdx = cur * 2;
            int rightIdx = cur * 2 + 1;
            int targetIdx = -1;

            if (rightIdx < heap.size()) {
                targetIdx = heap.get(leftIdx) < heap.get(rightIdx) ? leftIdx : rightIdx;
            } else if (leftIdx < heap.size()) {
                targetIdx = leftIdx;
            } else {
                break;
            }

            if (heap.get(cur) < heap.get(targetIdx)) {
                break;
            } else {
                int parentVal = heap.get(cur);
                heap.set(cur, heap.get(targetIdx));
                heap.set(targetIdx, parentVal);
                cur = targetIdx;
            }
        }

        return target;
    }

    public void printTree() {
        for (int i = 1; i < this.heap.size(); i++) {
            System.out.print(this.heap.get(i) + " ");
        }
        System.out.println();
    }
}

public class Main1 {

    public static void main(String[] args) {
        // Test Code
        MinHeap minHeap = new MinHeap();
        System.out.println("== 데이터 삽입 ==");
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.printTree();
        minHeap.insert(50);
        minHeap.insert(60);
        minHeap.insert(70);
        minHeap.printTree();
        minHeap.insert(20);
        minHeap.printTree();
        minHeap.insert(30);
        minHeap.printTree();

        System.out.println();
        System.out.println("== 데이터 삭제 ==");
        System.out.println("삭제 : " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제 : " + minHeap.delete());
        minHeap.printTree();
        System.out.println("삭제 : " + minHeap.delete());
        minHeap.printTree();
    }
}
