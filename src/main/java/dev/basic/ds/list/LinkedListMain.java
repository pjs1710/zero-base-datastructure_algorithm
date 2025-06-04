package dev.basic.ds.list;

public class LinkedListMain {

    public static class CustomLinkedList {
        private static class Node {
            int value;
            Node pointer;

            public Node(int value) {
                this.value = value;
                this.pointer = null;
            }
        }

        private Node head; // list의 시작점
        private int size;

        public CustomLinkedList() {
            this.size = 0;
        }

        public void add(int value) {
            if (head == null) {
                head = new Node(value);
            } else {
                Node current = head;
                while (current.pointer != null) {
                    current = current.pointer;
                }
                current.pointer = new Node(value);
            }
            size++;
        }

        public void add(int index, int value) {
            // 인덱스 유효범위
            if (index < 0 || index > size) {
                System.out.println("인덱스 범위 초과");
                return;
            }

            Node newNode = new Node(value);

            if (index == 0) { // 첫 번째 공간에 데이터 추가할 때
                newNode.pointer = head;
                head = newNode;
            } else { // 사이에 데이터 추가할 때
                Node prev = head;
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.pointer;
                }
                newNode.pointer = prev.pointer;
                prev.pointer = newNode;
            }

            size++;
        }

        public void remove() {
            Node current = head;

            while (current.pointer != null) {
                if (current.pointer.pointer != null) {
                    current = current.pointer;
                } else {
                    current.pointer = null;
                    size--;
                    break;
                }
            }
        }

        public void remove(int index) {
            // 인덱스의 유효 범위 체크
            if (index < 0 || index > size) {
                System.out.println("인덱스 범위 초과");
                return;
            }
            if (index == 0) {
                head = head.pointer;
            } else {
                Node prev = head;
                for (int i = 0; i < index - 1; i++) {
                    prev = prev.pointer; // 삭제하고자 하는 Node 전까지 접근
                }
                // prev.pointer // 내가 삭제하고자 하는 Node
                prev.pointer = prev.pointer.pointer;
            }
            size--;
        }

        public int get(int index) {
            // 인덱스의 유효 범위 체크
            if (index < 0 || index >= size) {
                System.out.println("인덱스 범위 초과");
                return -1;
            }
            // 풀이 1번
//            Node current = head;
//            for (int i = 0; i < size; i++) {
//                if (i == index) {
//                    return current.value;
//                }
//                current = current.pointer;
//            }
//            return -1;
            // 풀이 2번
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.pointer;
            }
            return current.value;
        }

        public void print() {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            Node current = head;
            while (true) {
                sb.append(current.value);
                if (current.pointer != null) {
                    sb.append(", ");
                }
                current = current.pointer;
                if (current == null) {
                    break;
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {

        CustomLinkedList list = new CustomLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);

        list.print();

        list.remove();
        list.print();

        System.out.println(list.get(1));

        list.add(30);
        list.print();

        list.add(1, 15);
        list.print();

        list.remove(2); // [10, 15, 30]
        list.print();;
    }
}
