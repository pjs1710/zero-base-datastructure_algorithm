package dev.programmers.third_week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 7주차 문제 6번 :
 *
 * 최종 레벨에 도달한 캐릭터가 가질 수 있는 모든 스킬 트리로 플레이하여 밸런스를 확인하는 업무.
 * 스킬 트리란, 레벨마다 1개씩 획득할 수 있는 스킬을 최종 레벨인 N레벨에 도달할 때까지 N개 획득한 결과를 말한다.
 * 제로의 전설의 스킬트리는 아래와 같은 독특한 시스템을 가지고 있다.
 * - M개의 스킬이 존재한다.
 * - 어떤 스킬들은 사전에 우선 획득해야 하는 `사전 획득 스킬`이 있다. 각 스킬의 사전 획득 스킬은 정수 배열 parents에 해당 스킬의 인덱스 (0 ~ M - 1)
 * 가 주어지며, 조건 없이 획득할 수 있는 스킬에는 -1이 주어진다.
 * - 모든 스킬은 `속성`이 존재한다. 각 스킬의 속성은 정수 배열 elements에 0이상의 정수로 주어진다.
 * 한 속성의 스킬을 과반수 이상 (N/2 초과) 획득할 경우, 그때부터는 더 이상 다른 속성의 스킬을 획득할 수 없다.
 *
 * 위 시스템에 의해서 N레벨에 완성할 수 있는 스킬 트리의 모든 경우의 수를 구하시오.
 * 단, 최종적으로 완성된 스킬 트리는 스킬을 획득한 순서와 관계 없이 최종적으로 획득한 스킬이 같으면 동일한 스킬 트리로 간주한다.
 *
 * 입력 :
 * N = 8
 * M = 10
 * parents = -1 0 1 2 3 4 5 -1 7 8
 * elements = 0 0 0 0 0 0 0 1 1 1
 *
 * 결과 : 3
 */

public class Task6 {

    static int N, M;
    static int[] parents;
    static int[] elements;
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    static Set<Set<Integer>> skillTreeSet = new HashSet<>();

    public static int solution(int n, int m, int[] p, int[] e) {
        N = n;
        M = m;
        parents = p;
        elements = e;

        for (int i = 0; i < M; i++) {
            tree.computeIfAbsent(parents[i], x -> new ArrayList<>()).add(i);
        }

        Set<Integer> available = new HashSet<>(tree.getOrDefault(-1, new ArrayList<>()));

        // dfs
        dfs(new HashSet<>(), available, new HashMap<>());

        return skillTreeSet.size();
    }

    public static void dfs(Set<Integer> selected, Set<Integer> available, Map<Integer, Integer> elementCnt) {
        if (selected.size() == N) {
            skillTreeSet.add(new HashSet<>(selected));
            return;
        }

        Integer lockedElement = null;
        for (Map.Entry<Integer, Integer> entry : elementCnt.entrySet()) {
            if (entry.getValue() > N / 2) {
                lockedElement = entry.getKey();
                break;
            }
        }

        for (int skill : new HashSet<>(available)) {
            int element = elements[skill];
            if (lockedElement != null && element != lockedElement) continue;

            selected.add(skill);
            available.remove(skill);
            elementCnt.put(element, elementCnt.getOrDefault(element, 0) + 1);

            Set<Integer> newlyAdded = new HashSet<>();
            for (int child : tree.getOrDefault(skill, new ArrayList<>())) {
                if (parents[child] == skill) {
                    available.add(child);
                    newlyAdded.add(child);
                }
            }

            dfs(selected, available, elementCnt);

            selected.remove(skill);
            available.add(skill);
            for (int child : newlyAdded) {
                available.remove(child);
            }
            elementCnt.put(element, elementCnt.get(element) - 1);
            if (elementCnt.get(element) == 0) {
                elementCnt.remove(element);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] parents = new int[M];
        int[] elements = new int[M];

        String[] data1 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            parents[i] = Integer.parseInt(data1[i]);
        }

        String[] data2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            elements[i] = Integer.parseInt(data2[i]);
        }

        System.out.println(solution(N, M, parents, elements));
    }
}
