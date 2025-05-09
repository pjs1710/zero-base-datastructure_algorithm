package dev.timer.lineards_02.hash;

// 해시 충돌 해결 - 개방 주소법 (제곱 탐사법)

class MyHastTable3 extends MyHashTable {

    MyHastTable3(int size) {
        super(size);
    }

    public void setValue(int key, int data) {
        int idx = this.getHash(key);

        if (this.elemCnt == this.table.length) {
            System.out.println("Hash table is Full");
            return;
        } else if (this.table[idx] == null) {
            this.table[idx] = data;
        } else {
            int newIdx = idx;
            int cnt = 0;
            while (true) {
                newIdx = (newIdx + (int) Math.pow(2, cnt)) % this.table.length;
                if (this.table[newIdx] == null) {
                    break;
                }
                cnt++;
            }
            this.table[newIdx] = data;
        }
        this.elemCnt++;
    }
}
public class Practice3 {

    public static void main(String[] args) {
        // Test Code
        MyHastTable3 ht = new MyHastTable3(11);
        ht.setValue(1, 10);
        ht.setValue(2, 20);
        ht.setValue(4, 40);
        ht.printHashTable();

        ht.setValue(1, 100);
        ht.printHashTable();

        ht.setValue(1, 200);
        ht.setValue(1, 300);
        ht.setValue(1, 400);
        ht.printHashTable();

    }
}
