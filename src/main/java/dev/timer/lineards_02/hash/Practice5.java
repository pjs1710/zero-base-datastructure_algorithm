package dev.timer.lineards_02.hash;

// 해시 충돌 해결 - 분리 연결법

class Node {
    int key;
    int data;
    Node next;

    Node() {
    }

    public Node(int key, int data, Node next) {
        this.key = key;
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

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int key, int data) {
        if (this.head == null) {
            this.head = new Node(key, data, null);
        } else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(key, data, null);
        }
    }

    public void removeData(int key) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;

        while (cur != null) {
            if (cur.key == key) {
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

    public Integer findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return null;
//            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.key == data) {
                System.out.println("Data exist!");
                return cur.data;
//                return true;
            }
            cur = cur.next;
        }
        System.out.println("Data not found!");
        return null;
//        return false;
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

class MyHashTable5 {
    LinkedList[] table;

    MyHashTable5(int size) {
        this.table = new LinkedList[size];
        for (int i = 0; i < this.table.length; i++) {
            this.table[i] = new LinkedList(null); // 기본 노드들 생성
        }
    }

    public int getHash(int key) {
        return key % this.table.length;
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        this.table[idx].addData(key, data);
    }

    public int getValue(int key) {
        int idx = this.getHash(key);
        int data = this.table[idx].findData(key);
        return data;
    }

    public void removeValue(int key) {
        int idx = this.getHash(key);

        this.table[idx].removeData(key);
    }

    public void printHashTable() {
        System.out.println("== Hash Table ==");
        for (int i = 0; i < this.table.length; i++) {
            System.out.print(i + " : ");
            this.table[i].showData();
        }
    }
}

public class Practice5 {

    public static void main(String[] args) {
        // Test Code
        MyHashTable5 ht = new MyHashTable5(11);

        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(3, 30);
        ht.printHashTable();

        ht.setValue(12, 11);
        ht.setValue(23, 12);
        ht.setValue(34, 13);

        ht.setValue(13, 21);
        ht.setValue(24, 22);
        ht.setValue(35, 23);

        ht.setValue(5, 1);
        ht.setValue(16, 2);
        ht.setValue(27, 3);
        ht.printHashTable();

        System.out.println("== Key 값으로 해당 데이터 가져오기 ==");
        System.out.println(ht.getValue(1));
        System.out.println(ht.getValue(12));

        System.out.println("== 데이터 삭제 ==");
        ht.removeValue(1);
        ht.removeValue(5);
        ht.removeValue(16);
        ht.printHashTable();
    }
}
