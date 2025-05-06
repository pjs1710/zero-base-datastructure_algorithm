package dev.timer.lineards_02.linkedlist.stringlinkedlist;

// 연결 리스트 배열 사용 연습

// 주어진 문자열 배열을 연결 리스트 배열로 관리하는 코드를 작성하시오.
// 관리 규칙은 다음과 같다.
// 각 문자열의 첫 글자가 같은 것끼리 같은 연결 리스트로 관리하기

import java.util.HashSet;

class Node {
    String data;
    Node next;

    Node() {

    }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;
    char alphabet;

    LinkedList() {

    }

    public LinkedList(Node node, char alphabet) {
        this.head = node;
        this.alphabet = alphabet;
    }

    public boolean isEmpty() {
        return this.head == null; // null이면 true, 아니면 false
    }

    public void addData(String data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    public void removeData(String data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;
        while (cur != null) {
            if (cur.data.equals(data)) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public boolean findData(String data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return false;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data.equals(data)) {
                System.out.println("Data exist!");
                return true;
            }
            cur = cur.next;
        }
        System.out.println("Data not Found!");
        return false;
    }

    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}


public class Practice8 {

    public static void dataCollect(String[] data) {
        HashSet<Character> set = new HashSet();
        // ex. apple, ant, banana, blueberry, cherry, cat
        for (String item : data) { // 첫 글자들이 중복되지 않게 가져와짐
            set.add(item.toCharArray()[0]); // set = {'a', 'b', 'c'}
        }
        System.out.println(set);

        Character[] arr = set.toArray(new Character[0]); // arr = {'a', 'b', 'c'} HashSet -> Array, new Character[0] 배열에 담을 때 Character 타입 배열로 달라는 의미
        LinkedList[] linkedList = new LinkedList[set.size()];
        for (int i = 0; i < linkedList.length; i++) {
            linkedList[i] = new LinkedList(null, arr[i]); // 참조하는 노드는 없는 그냥 단순 노드만 생성하는 로직
        }

        for (String item : data) { // data 배열에 있는 값을 순회하면서
            for (LinkedList list : linkedList) { // 연결 리스트에 넣기
                if (list.alphabet == item.toCharArray()[0]) { // data 배열에 있는 원소의 첫 번째 알파벳이 위의 연결 리스트에 미리 생성해놓은 노드의 알파벳과 같다면
                    list.addData(item); // 연결 리스트에 해당 data의 전체 배열 값을 넣는다. apple의 a를 비교해서 node의 a 데이터가 있으니 apple을 저장.
                }
            }
        }

        for (LinkedList list : linkedList) {
            System.out.print(list.alphabet + " : ");
            list.showData();
        }
    }

    public static void main(String[] args) {

        // Test Code
        String[] input = {"apple", "watermelon", "banana", "apricot", "kiwi", "blueberry", "cherry", "orange"};
        dataCollect(input);

        System.out.println();
        String[] input2 = {"ant", "kangaroo", "dog", "cat", "alligator", "duck", "crab"};
        dataCollect(input2);
    }

}
