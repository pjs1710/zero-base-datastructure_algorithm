package dev.timer.algorithm_04.sort;

import java.util.*;

public class Sort3 {

    public static void radixSort(int[] arr) {
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }

        int idx = 0;
        int div = 1;
        int maxLen = getMaxLen(arr);

        for (int i = 0; i < maxLen; i++) {

            for (int j = 0; j < arr.length; j++) {
                list.get((arr[j] / div) % 10).offer(arr[j]);
            }

            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = list.get(j);

                while (!queue.isEmpty()) {
                    arr[idx++] = queue.poll();
                }
            }

            idx = 0;
            div *= 10;
        }

    }

    public static int getMaxLen(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int) Math.log10(arr[i]) +1; // 자리 수 계산 log10(10) = 1, 10은 두 자리 수 -> 1 + 1
            if (maxLen < len) {
                maxLen = len;
            }
        }

        return maxLen;
    }

    public static void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] cntArr = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            cntArr[arr[i]]++;
        }

        int idx = 0;
        for (int i = 0; i < cntArr.length; i++) {
            while (cntArr[i] > 0) {
                arr[idx++] = i;
                cntArr[i] -= 1;
            }
        }

        // max 값이 커졌을 때를 대비해서 만든 HashMap 보완 솔루션
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        int idx2 = 0;
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            int cnt = map.get(list.get(i));
            while (cnt > 0) {
                arr[idx2++] = list.get(i);
                cnt--;
            }
        }
    }

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;

        for (int g = gap; g > 0; g /= 2) { // 4, 2, 1
            for (int i = g; i < arr.length; i++) {
                int tmp = arr[i];

                int j = 0;
                for (j = i - g; j >= 0; j -= g) {
                    if (arr[j] > tmp) {
                        arr[j + g] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + g] = tmp;
            }
        }
    }

    public static void main(String[] args) {

        // Test Code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬 : " + Arrays.toString(arr));

        // Test Code
        countingSort(arr);
        System.out.println("계수 정렬 : " + Arrays.toString(arr));

        // Test Code
        shellSort(arr);
        System.out.println("셸 정렬 : " + Arrays.toString(arr));
    }
}
