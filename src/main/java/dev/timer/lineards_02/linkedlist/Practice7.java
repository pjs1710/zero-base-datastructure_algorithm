package dev.timer.lineards_02.linkedlist;

// 연결 리스트 부분 뒤집기
// 주어진 연결 리스트에서 시작 위치부터 끝 위치 사이의 노드들을 뒤집으시오.

// 입력 예시)
// 입력 연결 리스트 : 1, 2, 3, 4, 5
// 시작 위치 : 2
// 끝 위치 : 4
// (처음 위치는 1부터라고 가정)
// 결과 연결 리스트: 1, 4, 3, 2, 5

public class Practice7 {

    public static LinkedList reverseList(LinkedList list, int left, int right) {
        Node cur1 = null;
        Node prev1 = null;

        cur1 = list.head;
        for (int i = 0; i < left - 1; i++) {
            prev1 = cur1;
            cur1 = cur1.next;
        }

        Node cur2 = cur1;
        Node prev2 = prev1;
        Node after = null;
        for (int i = left; i <= right; i++) {
            after = cur2.next;
            cur2.next = prev2;
            prev2 = cur2;
            cur2 = after;
        }

        prev1.next = prev2;
        cur1.next = cur2;

        return list;
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(2);
        linkedList.addData(3);
        linkedList.addData(4);
        linkedList.addData(5);
        linkedList.showData();

        linkedList = reverseList(linkedList, 2, 4);
        linkedList.showData();

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(1);
        linkedList2.addData(2);
        linkedList2.addData(3);
        linkedList2.addData(4);
        linkedList2.addData(5);
        linkedList2.addData(6);
        linkedList2.addData(7);
        linkedList2.showData();

        linkedList2 = reverseList(linkedList2, 3, 5);
        linkedList2.showData();
    }
}
