package dev.timer.nonlineards_03.priority_queue;

// 자바 기본 PriorityQueue 응용
// 나이 순으로 오름차순 또는 내림차순 출력

import java.util.PriorityQueue;

class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        // 1 : 변경 안함
        // -1 : 변경

        // 새롭게 추가하는 데이터가 더 작을 때 변경 (작은 값이 위로 올라감, 오름차순)
//        return this.age >= o.age ? 1 : -1; // this.age : 새로 들어온 데이터, o.age : 기존 데이터
        // 새롭게 추가하는 데이터가 더 클 때 변경 (큰 값이 위로 올라감, 내림차순)
        return this.age >= o.age ? -1 : 1;
    }
}

class Person1 {
    String name;
    int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Practice1 {

    public static void solution(String[] name, int[] age) {
        PriorityQueue<Person> pq = new PriorityQueue<>();

        for (int i = 0; i < name.length; i++) {
            pq.offer(new Person(name[i], age[i]));
        }

        System.out.println("== 실제 출력 순서 ==");
        while (!pq.isEmpty()) {
            Person p = pq.poll();
            System.out.println(p.name + " " + p.age);
        }
    }

    public static void main(String[] args) {
        String[] name = {"A", "B", "C", "D", "E"};
        int[] age = {30, 20, 45, 62, 35};

        solution(name, age);

        PriorityQueue<Person1> pq2 = new PriorityQueue<>((Person1 p1, Person1 p2) ->
                p1.age >= p2.age ? 1 : -1); // 오름차순

        for (int i = 0; i < name.length; i++) {
            pq2.offer(new Person1(name[i], age[i]));
        }

        System.out.println("== Comparable 없이 구현 ==");
        while (!pq2.isEmpty()) {
            Person1 p = pq2.poll();
            System.out.println(p.name + " " + p.age);
        }
    }
}
