package dev.timer.nonlineards_03.trie.problem_solve;

import java.util.HashMap;

// 문자열 배열 strs와 문자열 prefix가 주어졌을 때
// 문자열 배열 내에 prefix로 시작하는 단어가 있는 지를 확인하는 프로그램을 작성하세요
// prefix로 시작하는 단어가 있으면 true, 없으면 false를 반환

// 입출력 예시
// 입력 strs : "apple", "april", "app", "ace", "bear", "best"
// 입력 prefix : "app"
// 출력 : true

// 입력 strs : "apple", "april", "app", "ace", "bear", "best"
// 입력 prefix : "pre"
// 출력 : false

class Node {
    HashMap<Character, Node> child;
    boolean isTerminal;

    public Node() {
        this.child = new HashMap<>();
        this.isTerminal = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node()); // c가 존재하지 않으면 추가, 존재하면 넘어간다
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }

    public boolean search(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return false;
            }

            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return true;
    }

    public void delete(String str) {
        boolean ret = this.delete(this.root, str, 0);
        if (ret) {
            System.out.println(str + " 삭제 완료");
        } else {
            System.out.println(str + " 단어가 없습니다.");
        }
    }

    public boolean delete(Node node, String str, int idx) {
        char c = str.charAt(idx);

        if (!node.child.containsKey(c)) { // 지워야 하는 단어가 없으면
            return false;
        }
        Node cur = node.child.get(c);
        idx++;

        if (idx == str.length() - 1) {
            if (!cur.isTerminal) {
                return false;
            }

            cur.isTerminal = false;

            if (cur.child.isEmpty()) {
                node.child.remove(c);
            }
        } else {
            if (!this.delete(cur, str, idx)) {
                return false;
            }

            if (!cur.isTerminal && cur.child.isEmpty()) {
                node.child.remove(c);
            }
        }
        return true;
    }
}


public class Practice1 {

    public static boolean solution(String[] strs, String prefix) {
        Trie trie = new Trie();

        for (String str : strs) {
            trie.insert(str);
        }

        Node cur = trie.root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (cur.child.get(c) == null) {
                return false;
            }
            cur = cur.child.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Code
        String[] strs = {"apple", "april", "app", "ace", "bear", "best"};
        String prefix = "app";
        System.out.println(solution(strs, prefix)); // true

        prefix = "be";
        System.out.println(solution(strs, prefix)); // true

        prefix = "pre";
        System.out.println(solution(strs, prefix)); // false
    }
}
