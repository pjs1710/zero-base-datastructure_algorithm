package dev.basic.algorithm.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) { // 역전되는 순간은 데이터에 찾고자 하는 값이 없다는 것
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid; // 찾으면 바로 반환
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // 존재하지 않는다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int[] arr = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            arr[i] = Integer.parseInt(data[i]);
        }

        // 정렬을 해주고 search 해야 한다.

        int target = Integer.parseInt(br.readLine());
        int index = binarySearch(arr, target);
        System.out.println("찾고자 한 값 " + target + "의 위치는 " + (index == -1 ? "존재하지 않는다" : (index + " 인덱스에 있다.")));
    }
}
