package dev.timer.lineards_02.linkedlist;

// 단순 연결 리스트 (simple ver.) 기본 구조 구현

// 노드
class Node {
    int data;
    Node next;

    Node() {
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node head;

    LinkedList() {

    }

    public LinkedList(Node head) {
        this.head = head;
    }

    // 연결 리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    // 연결 리스트의 맨 뒤에 데이터 추가
    public void addData(int data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next; // next 주소가 null인 끝 노드까지 순회했을 때 조건 탈출
            }
            cur.next = new Node(data, null); // 마지막 노드의 next 주소를 새로운 노드를 생성한 주소로 변경 (데이터 삽입)
        }
    }

    // 연결 리스트의 맨 뒤의 데이터 삭제
    public void removeData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;

        while (cur.next != null) { // 제일 마지막 노드를 찾을 때까지 반복 -> 마지막 노드를 cur, 마지막 이전 노드를 prev
            prev = cur;
            cur = cur.next;
        }

        if (cur == this.head) { // 나 자신의 데이터만 있을 때 자신 삭제
            this.head = null;
        } else { // 제일 마지막 노드를 참조하는 제일 마지막 이전 노드의 next 참조값 null로 변경 -> 이후에 GC작업을 통해 마지막 노드 삭제됨.
            prev.next = null;
        }
    }

    // 연결 리스트에서 데이터 찾기
    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("Data exist!");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
    }

    // 연결 리스트의 모든 데이터 출력
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

public class Main {

    public static void main(String[] args) {

        // Test Code
        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData(); // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData(); // 1 2 3 4 5

        myList.findData(3); // Data exist!
        myList.findData(100); // Data not found!

        myList.removeData();
        myList.removeData();
        myList.removeData();
        myList.showData(); // 1 2

        myList.removeData();
        myList.removeData();
        myList.removeData(); // List is empty

    }
}
