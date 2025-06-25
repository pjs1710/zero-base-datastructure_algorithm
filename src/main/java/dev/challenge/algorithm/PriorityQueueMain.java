package dev.challenge.algorithm;

import java.util.PriorityQueue;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point other) {
        if (this.x == other.x) {
            return this.y - other.y;
        }

        return this.x - other.x;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

public class PriorityQueueMain {

    public static void main(String[] args) {
        PriorityQueue<Point> pq = new PriorityQueue<>(); // new PriorityQueue<>(Comparator.reverseOrder()); 하면 MaxHeap 구조로 출력
        pq.add(new Point(4, 5));
        pq.add(new Point(1, 2));
        pq.add(new Point(1, 3));
        pq.add(new Point(2, 3));
        pq.add(new Point(2, 1));
        System.out.println(pq);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll() + " ");
        }

    }
}
