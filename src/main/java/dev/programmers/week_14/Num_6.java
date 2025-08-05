package dev.programmers.week_14;

import java.util.*;

/**
 * 흰색(0)과 검은색(1)로만 이루어진 이진영상(binary image)은 다양한 방식으로 압축할 수 있다.
 * 여러 압축 방법 중에, 당신은 쿼드트리(quad-tree) 방식으로 압축하고자 한다.
 * 쿼드트리 압축 방식은 아래와 같다.
 * - 압축하려는 영상 전체가 0이면 "0", 전체가 1이면 "1"로 압축한다.
 * - 영상 전체가 같은 값이 아니라면, 영상을 동일한 크기로 4분할하여 부분 영상 별로 압축한다.
 * -- 각 부분 영상을 압축하는 방법은 전체 영상을 압축하는 방법과 같다.
 * -- 각각의 압축 결과를 "(좌상단 우상단 좌하단 우하단)" 과 같이 출력한다. (각 문자 사이에 공백은 쓰지 않는다.)
 *
 * 입력 :
 * 0, 0
 * 0, 0
 *
 * 결과 :
 * 0
 *
 * 입력 :
 * 0, 1
 * 1, 0
 *
 * 결과 :
 * (0110)
 */

public class Num_6 {

    public static String solution(int[][] image) {
        return compress(image, 0, 0, image.length);
    }

    private static String compress(int[][] image, int startRow, int startCol, int size) {
        if (isUniform(image, startRow, startCol, size)) {
            return String.valueOf(image[startRow][startCol]);
        }

        int halfSize = size / 2;

        String topLeft = compress(image, startRow, startCol, halfSize);
        String topRight = compress(image, startRow, startCol + halfSize, halfSize);
        String bottomLeft = compress(image, startRow + halfSize, startCol, halfSize);
        String bottomRight = compress(image, startRow + halfSize, startCol + halfSize, halfSize);

        return "(" + topLeft + topRight + bottomLeft + bottomRight + ")";
    }

    private static boolean isUniform(int[][] image, int startRow, int startCol, int size) {
        int firstValue = image[startRow][startCol];

        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                if (image[i][j] != firstValue) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
