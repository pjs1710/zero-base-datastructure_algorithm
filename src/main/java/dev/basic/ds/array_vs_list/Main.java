package dev.basic.ds.array_vs_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // 각 자료구조를 초기화
        int size = 1000000;

        // Array
        int[] array = new int[size];

        // ArrayList
        List<Integer> arrayList = new ArrayList<>(size);

        // LinkedList
        List<Integer> linkedList = new LinkedList<>();

        // 성능 비교용 시간 기록
        long startTime, endTime;

        // 1. 배열(Array) 값 초기화
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        endTime = System.nanoTime();
        System.out.println("Array\t\t초기화 시간 : " + (endTime - startTime) + "ns");

        // 2. ArrayList 값 초기화
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList\t초기화 시간 : " + (endTime - startTime) + "ns");

        // 3. LinkedList 값 초기화
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList\t초기화 시간 : " + (endTime - startTime) + "ns");
    }
}
