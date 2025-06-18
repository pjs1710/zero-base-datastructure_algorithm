package dev.challenge.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Practice2 {

    static int N, M;
    static List<Integer> arr; // 4 -> 1, 2, 3, 4
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        result = new ArrayList<>();

        dfs(0, 0); // 인덱스 0번부터 시행
    }

    /**
     *
     * @param n : 현재 돌고 있는 번호를 의미
     * @param m : 조합을 만드는데 몇개의 숫자를 썻는지 의미
     */
    public static void dfs(int n, int m) {
        if (m == M) {
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        if (n < N && m < M) {
            result.add(arr.get(n));
            dfs(n + 1, m + 1);
            result.removeLast();
            dfs(n + 1, m);
        }
    }
}
