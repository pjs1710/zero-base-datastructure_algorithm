package dev.timer.lineards_02.linkedlist;

// 단순 연결 리스트 구현 완성

class LinkedList2 extends LinkedList {

    LinkedList2(Node node) {
        this.head = node;
    }

    // 연결 리스트에 데이터 추가
    // before_data가 null인 경우, 가장 뒤에 추가
    // before_data에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    // 예시 : list.addData(10, null) -> 10 노드 생성
    // list.addData(20, null) -> 10 노드의 next 주소를 new Node를 통해 만들어진 20 노드의 주소로 설정. 결과 : 10 -> 20
    // list.addData(15, 20) -> 15 데이터의 next 주소를 20 노드의 주소로 설정. 결과 : 10 -> 15 -> 20
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null) {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            Node prev = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new Node(data, this.head);
                    } else {
                        prev.next = new Node(data, cur);
                    }
                    break;
                }
                prev = cur;
                cur = cur.next;
            }
        }
    }

    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;
        while (cur != null) {
            if (cur.data == data) {
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
}

public class Practice1 {

    public static void main(String[] args) {

        // Test Code
        LinkedList2 myList = new LinkedList2(new Node(1, null));
        myList.showData(); // 1

        myList.addData(2);
        myList.addData(3);
        myList.addData(4);
        myList.addData(5);
        myList.showData(); // 1 2 3 4 5

        myList.addData(100, 1);
        myList.addData(200, 2);
        myList.addData(300, 3);
        myList.addData(400, 4);
        myList.addData(500, 5);
        myList.showData(); // 100 1 200 2 300 3 400 4 500 5

        myList.removeData(300);
        myList.removeData(100);
        myList.removeData(500);
        myList.removeData(200);
        myList.removeData(400);
        myList.showData(); // 1 2 3 4 5

        myList.removeData(3);
        myList.removeData(1);
        myList.removeData(5);
        myList.removeData(2);
        myList.removeData(4);
        myList.showData(); // List is empty
    }
}
