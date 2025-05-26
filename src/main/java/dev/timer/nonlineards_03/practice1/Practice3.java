package dev.timer.nonlineards_03.practice1;

import java.util.*;

public class Practice3 {

    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        HashMap<String, String> name = new HashMap<>();

        for (ArrayList<String> account : accounts) {
            String username = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }

                name.put(account.get(i), username);

                if (i == 1) {
                    continue;
                }

                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        HashSet<String> visited = new HashSet<>();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String email : name.keySet()) { // email 목록들
            ArrayList<String> list = new ArrayList<>();

            if (visited.add(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                result.add(list);
            }
        }

        return result;
    }

    public static void dfs(HashMap<String, HashSet<String>> graph, String email, HashSet<String> visited, ArrayList<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }

    public static void main(String[] args) {
        // Test Code
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john_lab@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john02@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts = solution(accounts);
        for (ArrayList<String> item : accounts) {
            System.out.println(item);
        }
    }
}
