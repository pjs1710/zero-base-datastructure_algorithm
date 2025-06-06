package dev.basic.ds.list.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * 문제풀이 2번 :
 *
 * 방금 입력하는 문제에서 I의 형식을 바꿉니다. I 다음에는 값과 위치를 넣습니다.
 * 위치가 입력되지 않거나 사이즈보다 큰 값이면, 가장 뒤에 값을 넣습니다.
 */
public class Practice2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            String input = br.readLine();
            String[] split = input.split(" ");
            if (split[0].equals("I")) {
                int value = Integer.parseInt(split[1]);
                if (split.length == 3) {
                    int index = Integer.parseInt(split[2]);
                    if (index >= list.size()) {
                        list.add(value);
                    } else {
                        list.add(index, value);
                    }
                } else {
                    list.add(value);
                }
            } else if (split[0].equals("D")) {
                if (!list.isEmpty()) {
                    list.removeLast();
                }
            } else if (split[0].equals("E")) {
                break;
            } else {
                System.out.println("올바른 명령어가 아닙니다.");
            }
        }
        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            printList(list);
        }
    }

    private static void printList(ArrayList<Integer> list) {
        System.out.println(list.getLast());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println(list.size());
    }
}
