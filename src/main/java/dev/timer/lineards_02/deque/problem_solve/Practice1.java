package dev.timer.lineards_02.deque.problem_solve;

// 데이터 재정렬
// D_0 -> D_1 -> ... -> D_n-1 -> D_n 순으로 되어 있는 데이터를
// D_0 -> D_n -> D_1 -> D_n-1 -> ... 순이 되도록 재정렬 하시오.

// 입력 예시)
// 입력 데이터 : 1 -> 2 -> 3 -> 4 -> 5
// 출력 데이터 : 1 -> 5 -> 2 -> 4 -> 3

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.stream.IntStream;

public class Practice1 {

    public static void reorderData(int[] arr) {
        Deque deque = new ArrayDeque();
        ArrayList result = new ArrayList();

        IntStream.of(arr).forEach(x -> deque.addLast(x)); // int형 배열을 deque에 삽입. 1 2 3 4 5
        System.out.println(deque);

        while (!deque.isEmpty()) { // 반복문을 돌면서 result에 deque에 입력되어 있는 좌, 우 데이터를 하나씩 빼줌. 처음에는 왼쪽(First)
            result.add(deque.removeFirst());

            if (!deque.isEmpty()) { // 데이터 뺀 후에 비어있는지 항상 체크한 후, 오른쪽 데이터 빼주기.
                result.add(deque.removeLast());
            }
        }

        System.out.println("== 정렬 전 ==");
        printData(arr);
        System.out.println("== 정렬 후 ==");
        printData(result.stream().mapToInt(x -> (int) x).toArray()); // result에는 ArrayList 형태로 값이 들어가있음. stream으로 람다를 이용해 원소값을 int형으로 바꾼 후 배열로 저장.
    }

    public static void printData(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    public static void main(String[] args) {
        // Test Code
        int[] arr = {1, 2, 3, 4, 5};
        reorderData(arr); // 1 -> 5 -> 2 -> 4 -> 3

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        reorderData(arr2); // 1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4
    }
}
