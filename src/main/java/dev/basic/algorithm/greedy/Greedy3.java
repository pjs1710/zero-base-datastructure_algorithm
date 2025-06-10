package dev.basic.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 배낭 문제
 *
 * 배낭에 순도가 높은 금덩이를 넣어가려고 합니다. 첫 줄에는 금덩이의 개수와 배낭이 담을 수 있는 최대 무게가 주어집니다.
 * 그 다음 최대 무게만큼 금덩이를 최대한 담습니다.
 * 이때, 금덩이를 조합해서 만들 수 있는 최대 가치를 구하세요. 금덩이는 자를 수 있습니다.
 */

public class Greedy3 {

    public static class Item implements Comparable<Item> {
        int weight, value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Item other) {
            double ratio1 = (double) this.value / this.weight; // 10kg -> 60원 => 1kg -> 6원으로 가치를 통일시키기
            double ratio2 = (double) other.value / other.weight; // 10kg -> 60원 => 1kg -> 6원으로 가치를 통일시키기
            return Double.compare(ratio2, ratio1); // 무게 내림차순으로 정렬
        }

        @Override
        public String toString() {
            return String.format("[%s, %s, %s]", weight, value, ((double) value / weight));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]); // 총 개수
        int w = Integer.parseInt(data[1]); // 최대 무게

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data = br.readLine().split(" ");
            int weight = Integer.parseInt(data[0]); // 금덩이 무게
            int value = Integer.parseInt(data[1]); // 금덩이 가치
            items.add(new Item(weight, value));
        }

        Collections.sort(items);

        int totalValue = 0; // 결과 가치
        int currentWeight = 0; // 지금 무게

        for (Item item : items) {
            if (currentWeight + item.weight <= w) {
                currentWeight += item.weight;
                totalValue += item.value;
            } else { // 일부만 잘라서 넣어야 할 때
                int remainWeight = w - currentWeight; // 남은 무게
                totalValue += (item.value * remainWeight) / item.weight; // 20 * 120 / 30 = 80
                break;
            }
        }

        System.out.println(totalValue);
    }
}
