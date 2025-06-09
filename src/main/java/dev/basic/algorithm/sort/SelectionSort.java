package dev.basic.algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int tmp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int[] arr = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        System.out.println("정렬 전 :" + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("정렬 후 :" + Arrays.toString(arr));
    }
}
