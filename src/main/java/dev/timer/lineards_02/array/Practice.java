package dev.timer.lineards_02.array;

// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현

import java.util.Arrays;

class MyArray {
    int[] arr;

    // 배열의 초기 사이즈 설정
    MyArray(int size) {
        this.arr = new int[size];
    }

    // 배열에 데이터 삽입
    public void insert(int index, int data) {
        if (index < 0 || index > this.arr.length) {
            System.out.println("Index Error");
            return;
        }

        // Let this.arr = [1, 2, 3, 4] -> insert(2, 5) -> result = [1, 2, 5, 3, 4]

        int[] arrDup = this.arr.clone(); // arrDup = [1, 2, 3, 4]
        this.arr = new int[this.arr.length + 1]; // this.arr = [0, 0, 0, 0, 0]

        for (int i = 0; i < index; i++) { // this.arr = [1, 2, 0, 0, 0]
            this.arr[i] = arrDup[i];
        }

        for (int i = index + 1; i < this.arr.length; i++) { // this.arr = [1, 2, 0, 3, 4]
            this.arr[i] = arrDup[i - 1];
        }

        this.arr[index] = data; // this.arr = [1, 2, 5, 3, 4]
    }

    // 배열에서 특정 데이터 삭제
    public void removeData(int data) {
        int targetIndex = -1;

        for (int i = 0; i < this.arr.length; i++) { // this.arr = [1, 2, 3, 4, 5] -> removeData(3) -> result = [1, 2, 4, 5]
            if (this.arr[i] == data) {
                targetIndex = i;
                break;
            }
        }

        if (targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다.");
        } else {

            int[] arrDup = this.arr.clone(); // arrDup = [1, 2, 3, 4, 5]
            this.arr = new int[this.arr.length - 1]; // this.arr = [0, 0, 0, 0]

            for (int i = 0; i < targetIndex; i++) { // this.arr = [1, 2, 0, 0]
                this.arr[i] = arrDup[i];
            }

            for (int i = targetIndex; i < this.arr.length; i++) { // this.arr = [1, 2, 4, 5]
                this.arr[i] = arrDup[i + 1];
            }
        }

    }

}

public class Practice {

    public static void main(String[] args) {
        // Test code
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insert(2, 20);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insert(6, 60);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.insert(-1, 0); // Index Error

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));

        myArray.removeData(99); // 해당 데이터가 없습니다.
    }
}
