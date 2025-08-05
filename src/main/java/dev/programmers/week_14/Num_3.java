package dev.programmers.week_14;

import java.util.*;

/**
 * 유미는 소설 작가로, 최근 작품이 베스트셀러가 되어 큰 부를 거머쥐었다.
 * 유미는 마트에서 저녁에 쓸 요리 재료를 구매하려고 한다. 필요한 요리 재료는 ingredients 배열에 정리해 두었다.
 * 평소에는 무척 검소한 유미는, 처음으로 "여기서부터 저기까지 다 주세요!"라고 외치고 싶어졌다.
 * 마트에 진열된 품목은 items[i]로 주어지며, 유미는 필요한 요리 재료가 모두 포함되는 가장 최소한의 구간을 선택하려고 한다.
 * 이 때 유미가 구매할 구간의 길이를 출력하시오.
 *
 * 입력 :
 * ingredients = {"생닭", "인삼", "소주", "대추"}
 * items = {"물", "인삼", "커피", "생닭", "소주", "사탕", "생닭", "대추", "쌀"}
 *
 * 결과 :
 * 7
 */

public class Num_3 {

    public static int solution(String[] ingredients, String[] items) {
        // 필요한 재료들을 Set으로 관리
        Set<String> needed = new HashSet<>(Arrays.asList(ingredients));

        // 현재 윈도우에서 찾은 재료들과 개수를 관리
        Map<String, Integer> window = new HashMap<>();

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int validCount = 0; // 필요한 재료 중 조건을 만족하는 재료의 개수

        for (int right = 0; right < items.length; right++) {
            String item = items[right];

            // 현재 아이템이 필요한 재료인 경우
            if (needed.contains(item)) {
                window.put(item, window.getOrDefault(item, 0) + 1);

                // 해당 재료를 처음 찾은 경우
                if (window.get(item) == 1) {
                    validCount++;
                }
            }

            // 모든 필요한 재료를 찾은 경우, 왼쪽 포인터를 축소
            while (validCount == needed.size()) {
                // 현재 윈도우 크기 확인
                minLength = Math.min(minLength, right - left + 1);

                String leftItem = items[left];

                // 왼쪽 아이템이 필요한 재료인 경우
                if (needed.contains(leftItem)) {
                    window.put(leftItem, window.get(leftItem) - 1);

                    // 해당 재료가 윈도우에서 완전히 제거된 경우
                    if (window.get(leftItem) == 0) {
                        validCount--;
                    }
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {

    }
}
