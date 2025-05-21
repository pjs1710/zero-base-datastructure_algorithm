package dev.timer.nonlineards_03.priority_queue;

// 비선형 자료구조 - 우선순위 큐
// 연결 리스트를 이용한 우선순위 큐
// 자바에서 제공해주는 PriorityQueue 클래스

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {

    // 연결 리스트를 이용한 우선순위 큐 방식
    // data 값이 낮을 수록 우선순위가 높은 방식으로 가정! (오름차순으로)
    public static void enqueue(LinkedList<Integer> list, int data) {
        int idx = list.size(); // 가장 끝 index
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > data) { // 들어온 data 값이 작으면 index = i 업데이트
                idx = i;
                break;
            }
        }
        list.add(idx, data);
    }

    public static Integer dequeue(LinkedList<Integer> list) {
        if (list.size() == 0) {
            return null;
        }
        int data = list.get(0);
        list.remove(0);
        return data;
    }

    public static void main(String[] args) {

        // 연결 리스트를 이용한 우선순위 큐
        System.out.println("== 연결 리스트 방식의 우선순위 큐 ==");
        LinkedList<Integer> pqList = new LinkedList<>();
        enqueue(pqList, 5);
        enqueue(pqList, 7);
        enqueue(pqList, 3);
        enqueue(pqList, 1);
        enqueue(pqList, 9);
        System.out.println(pqList);

        System.out.println(dequeue(pqList));
        System.out.println(dequeue(pqList));
        System.out.println(pqList);
        System.out.println();

        // 자바에서 제공하는 PriorityQueue 사용
        System.out.println("== 자바 기본 우선순위 큐 ==");
        // 우선순위 : 낮은 숫자 순
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(7);
        pq.add(3);
        pq.add(1);
        pq.add(9);
        System.out.println(Arrays.toString(pq.toArray())); // [1, 3, 5, 7, 9]

        // 우선순위 : 높은 숫자 순
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        pq2.add(5);
        pq2.add(7);
        pq2.add(3);
        pq2.add(1);
        pq2.add(9);
        System.out.println(Arrays.toString(pq2.toArray())); // [9, 7, 3, 1, 5]

    }
}
