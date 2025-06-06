package dev.basic.ds.list.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringJoiner;

/**
 * 문제풀이 1번 :
 *
 * 사용자가 입력한 명령어에 따라 리스트에 값을 추가/삭제합니다.
 * 명령어는 I(마지막에 입력; 양수만 가능), D(마지막 값 삭제), E(종료)로 진행되며,
 * 결과는 종료 이후에 가장 마지막 값, 모든 값, 사이즈를 출력합니다. 비어있다면 -1을 출력합니다.
 * 단, D는 I의 횟수보다 더 많이 입력될 수 없습니다.
 *
 */

public class Practice1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int inputCnt = 0;
        int deleteCnt = 0;

        while (true) {
            String input = br.readLine();
            String[] split = input.split(" ");
            if (split[0].equals("I")) {
                list.add(Integer.valueOf(split[1]));
                inputCnt++;
            } else if (split[0].equals("D")) {
                if (inputCnt <= deleteCnt) {
                    System.out.println(inputCnt + " " + deleteCnt);
                    System.out.println("더 이상 삭제할 수 없습니다.");
                } else {
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
//        StringJoiner sj = new StringJoiner(", ");
//        for (int item : list) {
//            sj.add(Integer.toString(item));
//        }
//        System.out.println(sj.toString());
        System.out.println();
        System.out.println(list.size());
    }
}
