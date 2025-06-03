package dev.basic.ds.array;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // 사이즈를 명확하게 지정
        int[] arr = new int[5];
//        char[] arr1 = new char[5];
//        String[] arr2 = new String[5];
//        boolean[] arr3 = new boolean[5];
//        Boolean[] arr4 = new Boolean[5];

        // 선언과 초기값 설정 동시에
        int[] arr2 = {10, 30, 20}; // 사이즈 3짜리 배열

        int[] arr3 = new int[5];
        Random rand = new Random();
        for (int index = 0; index < arr3.length; index++) {
            arr3[index] = rand.nextInt(10);
        }

        int[] arr4 = new int[5];
        Arrays.fill(arr4, 10);

        int[] arr5 = IntStream.range(0, 5).toArray();

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));

    }
}
