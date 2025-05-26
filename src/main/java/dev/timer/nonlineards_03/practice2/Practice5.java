package dev.timer.nonlineards_03.practice2;

import java.util.ArrayList;
import java.util.HashMap;

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
    ArrayList<Character> capitals;

    public Trie() {
        this.root = new Node();
        capitals = new ArrayList<>();
    }

    public void insert(String str) {
        Node cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c < 'a') { // 대문자인 경우
                capitals.add(c);
            }

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
        ArrayList<Character> cap = new ArrayList<>(capitals);

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cap.remove(new Character(c));
                cur = cur.child.get(c);
            } else {
                if (c < 'a') {
                    return false;
                } else {
                    continue;
                }
            }

            if (i == str.length() - 1) {
                if (!cur.isTerminal) {
                    return false;
                }
            }
        }
        return cap.size() == 0;
    }
}

public class Practice5 {

    public static ArrayList<Boolean> solution(String[] queries, String pattern) {
        Trie trie = new Trie();
        trie.insert(pattern);

        ArrayList<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(trie.search(query));
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Code
        String[] queries = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        String pattern = "FB";
        System.out.println(solution(queries, pattern));

        pattern = "FoBa";
        System.out.println(solution(queries, pattern));

        pattern = "FoBaT";
        System.out.println(solution(queries, pattern));
    }
}
