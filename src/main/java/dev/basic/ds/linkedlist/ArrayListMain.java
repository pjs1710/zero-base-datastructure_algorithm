package dev.basic.ds.linkedlist;

import java.util.Arrays;

public class ArrayListMain {

    public static class CustomArrayList {
        private int defaultSize = 10;
        private int[] data;
        private int size = 0;

        public CustomArrayList() {
            data = new int[defaultSize];
        }

        public CustomArrayList(int size) {
            data = new int[size];
        }

        public void add(int value) {
            resizeDataSize();
            data[size] = value;
            size++;
        }

        public void add(int index, int value) {
            if (index < 0 || index > size) {
                System.out.println("인덱스 범위 초과");
                return;
            }
            resizeDataSize();
            for (int i = size; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = value;
            size++;
        }

        public void remove() {
            size--;
        }

        public void remove(int index) {
            if (index < 0 || index >= size) {
                System.out.println("인덱스 범위 초과");
                return;
            }

            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
            size--;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                System.out.println("인덱스 범위 초과");
                return -1;
            }
            return data[index];
        }

        public void print() {
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            for (int i = 0; i < size; i++) {
                sb.append(data[i]);
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
        }

        private void resizeDataSize() {
            if (data.length > size) {
                return;
            }
            int newSize = data.length * 2;
            int[] newArr = new int[newSize];

            for (int i = 0; i < data.length; i++) {
                newArr[i] = data[i];
            }
            data = newArr;
        }
    }

    public static void main(String[] args) {
        CustomArrayList list1 = new CustomArrayList();
        list1.print();
        CustomArrayList list2 = new CustomArrayList(5);
        list2.print();
        list1.add(10);
        list1.print();
        list1.add(5);
        list1.print();
        list1.remove();
        list1.print();

        list1.add(0, 3);
        list1.print();

        list1.add(-1, 7);
        list1.print();

        list1.remove(0);
        list1.print();

        System.out.println(list1.get(0));
        System.out.println(list1.get(1));
    }
}
