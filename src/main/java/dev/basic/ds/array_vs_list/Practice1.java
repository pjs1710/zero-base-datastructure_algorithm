package dev.basic.ds.array_vs_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 문제 풀이 1번 :
 *
 * 연속적으로 저장할 숫자를 첫 줄에 입력받고, 다음 줄에 숫자 2개를 입력받습니다.
 * 숫자는 순서대로 넣고자 하는 인덱스와 값입니다. 결과는 전체 리스트를 출력하세요.
 */

public class Practice1 {

//    ArrayList 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrList = new ArrayList<>();

        String input1 = br.readLine();
        String[] values = input1.split(" ");
        for (String value : values) {
            arrList.add(Integer.parseInt(value));
        }
        String input2 = br.readLine();
        String[] split = input2.split(" ");
        int index = Integer.parseInt(split[0]);
        int value = Integer.parseInt(split[1]);
        arrList.add(index, value);

        printList(arrList);
    }

    private static void printList(ArrayList<Integer> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i) + " ");
        }
        System.out.println();
    }

    /* LinkedList 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> linkedList = new LinkedList<>();

        String input1 = br.readLine();
        String[] values = input1.split(" ");
        for (String value : values) {
            linkedList.add(Integer.parseInt(value));
        }
        String input2 = br.readLine();
        String[] split = input2.split(" ");
        int index = Integer.parseInt(split[0]);
        int value = Integer.parseInt(split[1]);
        linkedList.add(index, value);

        printList(linkedList);
    }

    private static void printList(LinkedList<Integer> linkedList) {
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
    }
     */

    /* 배열 풀이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String[] values = input1.split(" ");

        int size = values.length;
        int[] arr = new int[size + 1];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        String input2 = br.readLine();
        String[] split = input2.split(" ");
        int index = Integer.parseInt(split[0]);
        int value = Integer.parseInt(split[1]);

        for (int i = arr.length - 1; i > 0; i--) {
            if (i > index) {
                arr[i] = arr[i - 1];
            } else if (i == index) {
                arr[index] = value;
            }
        }

        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

     */
}
