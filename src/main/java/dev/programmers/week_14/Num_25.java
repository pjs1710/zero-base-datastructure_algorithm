package dev.programmers.week_14;

import java.util.*;

/**
 * 당신은 이진 트리 자료구조를 순회하는 새로운 알고리즘을 설계하였고, 그것의 이름을 '거꾸로 BFS'라고 이름 지었다.
 * 기존의 BFS는 가장 상위 노드인 루트 노드부터, 깊이 순서대로 노드를 순회하는 방법이다. 또한, 순회의 순서는 왼쪽부터 오른쪽으로 이루어진다.
 * '거꾸로 BFS' 순회방법은 가장 하위 노드인 리프 노드부터 시작한다. 각 리프 노드를 오른ㅉ쪽부터 왼쪽으로 순회한다.
 * 그 다음에는 이미 순회한 리프 노드를 제거하고, 나머지 부분 트리에서 리프 노드를 오른쪽부터 왼ㅉ쪽 순으로 순회한다.
 * 위 과정을ㄹ 모든 노드를 순회할 때까지 반복한다.
 * 전체 노드의 수가 N으로 주어지며, 부모-ㅈ자식 관계가 left[i] = {부모노드의 인덱스, 왼쪽 자식 노드의 인덱스}, right[i] = {부모노드의 인덱스, ㅈ오른쪽 자식 노드의 인덱스}
 * 로 주어질 때, 위에서 묘사된 '거꾸로 BFS'를 구현하시오.
 * 단, 루트 노드의 인덱스는 항상 0이며, 출력은 '거꾸로 BFS'로 순회하는 노드의 인덱스를 배열로 출력하시오.
 *
 * 입력 :
 * N = 6
 * left = {{0, 1}, {1, 5}, {2, 3}}
 * right = {{0, 2}, {3, 4}}
 *
 * 결과 :
 * {4, 5, 3, 1, 2, 0}
 */

public class Num_25 {

    public static int[] solution(int N, int[][] left, int[][] right) {
        // 트리 구조 구성
        Map<Integer, Integer> leftChild = new HashMap<>();
        Map<Integer, Integer> rightChild = new HashMap<>();
        Set<Integer> remainingNodes = new HashSet<>();

        // 모든 노드 추가
        for (int i = 0; i < N; i++) {
            remainingNodes.add(i);
        }

        // 자식 관계 설정
        for (int[] relation : left) {
            leftChild.put(relation[0], relation[1]);
        }

        for (int[] relation : right) {
            rightChild.put(relation[0], relation[1]);
        }

        // 트리의 각 노드의 위치(깊이, 좌우 순서)를 계산
        Map<Integer, Integer> nodeDepth = new HashMap<>();
        Map<Integer, Integer> nodePosition = new HashMap<>();

        // BFS로 각 노드의 깊이와 위치 계산
        Queue<int[]> queue = new LinkedList<>(); // {node, depth, position}
        queue.offer(new int[]{0, 0, 0});
        nodeDepth.put(0, 0);
        nodePosition.put(0, 0);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];
            int position = current[2];

            // 왼쪽 자식
            if (leftChild.containsKey(node)) {
                int leftNode = leftChild.get(node);
                nodeDepth.put(leftNode, depth + 1);
                nodePosition.put(leftNode, position * 2); // 왼쪽은 position * 2
                queue.offer(new int[]{leftNode, depth + 1, position * 2});
            }

            // 오른쪽 자식
            if (rightChild.containsKey(node)) {
                int rightNode = rightChild.get(node);
                nodeDepth.put(rightNode, depth + 1);
                nodePosition.put(rightNode, position * 2 + 1); // 오른쪽은 position * 2 + 1
                queue.offer(new int[]{rightNode, depth + 1, position * 2 + 1});
            }
        }

        List<Integer> result = new ArrayList<>();

        // 거꾸로 BFS 수행
        while (!remainingNodes.isEmpty()) {
            // 현재 리프 노드들 찾기
            List<Integer> currentLeaves = new ArrayList<>();

            for (int node : remainingNodes) {
                boolean isLeaf = true;

                // 자식이 남아있는지 확인
                if (leftChild.containsKey(node) && remainingNodes.contains(leftChild.get(node))) {
                    isLeaf = false;
                }
                if (rightChild.containsKey(node) && remainingNodes.contains(rightChild.get(node))) {
                    isLeaf = false;
                }

                if (isLeaf) {
                    currentLeaves.add(node);
                }
            }

            // 리프 노드들을 깊이 순으로, 같은 깊이에서는 오른쪽부터 정렬
            currentLeaves.sort((a, b) -> {
                int depthA = nodeDepth.get(a);
                int depthB = nodeDepth.get(b);

                if (depthA != depthB) {
                    return Integer.compare(depthB, depthA); // 깊은 것부터
                } else {
                    return Integer.compare(nodePosition.get(b), nodePosition.get(a)); // 오른쪽부터
                }
            });

            // 결과에 추가하고 제거
            for (int leaf : currentLeaves) {
                result.add(leaf);
                remainingNodes.remove(leaf);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

    }
}
