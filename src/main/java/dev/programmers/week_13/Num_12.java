package dev.programmers.week_13;

import java.util.*;

/**
 * 건물의 특징은 아래와 같이 buildings 배열로 주어진다.
 * - buildings 배열은 2차원 배열로, 각 건물의 위치와 높이를 나타낸다.
 * - 배열의 각 요소는 buildings[i] = {left, right, height}로, 각 건물의 좌우측 x축 좌표와 높이를 나타낸다.
 * - 총 N개의 건물은 서로 겹쳐있을 수도 있고, 겹쳐있지 않을 수도 있다.
 * - 건물의 각 끝점{left와 right}은 유일하다. 즉, 건물의 끝 점이 딱 맞는 경우는 없다.
 *
 * 출력은 아래와 같다.
 * - 건물의 실루엣을 표현할 수 있는 키포인트를 모은 배열을 출력한다.
 * - 키포인트는 y축의 값이 변화하는 각 x축 위치에서, 변환 후의 좌표 {x, y}를 의미한다.
 * - 키포인트는 x값이 작은 값부터 오름차순으로 정렬하여 반환한다.
 * - 키포인트에 대한 자세한 설명은 아래 예시 입출력 설명을 참조하시오.
 *
 * 입력 :
 * building = {{1, 8, 4}, {2, 4, 10}, {3, 5, 6}, {10, 12, 6}}
 *
 * 결과 :
 * {{1, 4}, {2, 10}, {4, 6}, {5, 4}, {8, 0}, {10, 6}, {12, 0}}
 */

public class Num_12 {

    public static int[][] solution(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];

            events.add(new int[]{left, -height});
            events.add(new int[]{right, height});
        }

        events.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        List<int[]> result = new ArrayList<>();
        TreeMap<Integer, Integer> heightCount = new TreeMap<>(Collections.reverseOrder());
        heightCount.put(0, 1);

        for (int[] event : events) {
            int x = event[0];
            int h = event[1];
            if (h < 0) {
                h = -h;
                heightCount.put(h, heightCount.getOrDefault(h, 0) + 1);
            } else {
                int count = heightCount.get(h);
                if (count == 1) {
                    heightCount.remove(h);
                } else {
                    heightCount.put(h, count - 1);
                }
            }
            int maxHeight = heightCount.firstKey();

            if (result.isEmpty() || result.get(result.size() - 1)[1] != maxHeight) {
                result.add(new int[]{x, maxHeight});
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

    }
}
