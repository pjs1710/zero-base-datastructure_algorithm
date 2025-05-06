package dev.timer.lineards_02.linkedlist;

// 단방향 연결 리스트에서 중복 데이터를 찾아 삭제하세요.

// 입출력 예시)
// 입력 연결 리스트 : 1, 3, 3, 1, 4, 2, 4, 2
// 결과 연결 리스트 : 1, 3, 4, 2


public class Practice4 {

    public static LinkedList removeDup(LinkedList beforeList) {
        LinkedList resultList = new LinkedList();

        Node cur = beforeList.head;
        while (cur != null) {
            if (resultList.findData(cur.data) == false) {
                resultList.addData(cur.data);
            }
            cur = cur.next;
        }

        return resultList;
    }

    public static void main(String[] args) {

        // Test Code
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(3);
        linkedList.addData(1);
        linkedList.addData(4);
        linkedList.addData(2);
        linkedList.addData(4);
        linkedList.addData(2); // 1 3 3 1 4 2 4 2

        linkedList = removeDup(linkedList);
        linkedList.showData(); // 1 3 4 2
    }
}
