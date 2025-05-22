package dev.timer.nonlineards_03.trie.problem_solve;

// 문자열 배열 strs와 targets가 주어졌을 때
// targets 내의 단어 중 한 문자만 바꾸면 strs중의 단어가 되는지 판별하는 프로그램을 작성

// 입출력 예시
// 입력 strs : "apple", "banana", "kiwi"
// 입력 targets : "applk", "bpple", "apple"
// 출력 : true, true, false

public class Practice3 {

    public static void solution(String[] strs, String[] targets) {
        Trie trie = new Trie();
        for (String str : strs) {
            trie.insert(str);
        }

        for (String target : targets) {
            boolean result = examineWord(trie.root, target, 0, false);
            System.out.println(result + " ");
        }
        System.out.println();
    }

    public static boolean examineWord(Node node, String target, int i, boolean flag) {
        if (i < target.length()) {
            if (node.child.containsKey(target.charAt(i))) {
                if (examineWord(node.child.get(target.charAt(i)), target, i + 1, flag)) {
                    return true;
                }
            }

            if (!flag) {
                for (char c : node.child.keySet()) {
                    if (c != target.charAt(i) && examineWord(node.child.get(c), target, i + 1, true)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return flag && node.isTerminal;
    }

    public static void main(String[] args) {
        // Test Code
        String[] strs = {"apple", "banana", "kiwi"};
        String[] targets = {"applk", "bpple", "apple", "banan", "kiww"};
        solution(strs, targets); // true, true, false, false, true
    }
}
