package dev.basic.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int size = arr.length;
        boolean swapped = false;

        for (int i = 0; i < size - 1; i++) {
            swapped = false;
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int[] arr = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }
        System.out.println("정렬 전 : " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("정렬 후 : " + Arrays.toString(arr));
    }
}
