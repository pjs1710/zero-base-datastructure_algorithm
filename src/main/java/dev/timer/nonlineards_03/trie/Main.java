package dev.timer.nonlineards_03.trie;

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

public class Main {

    public static void main(String[] args) {
        // Test Code
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("april");
        trie.insert("app");
        trie.insert("ace");
        trie.insert("bear");
        trie.insert("best");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("april")); // true
        System.out.println(trie.search("app")); // true
        System.out.println(trie.search("ace")); // true
        System.out.println(trie.search("bear")); // true
        System.out.println(trie.search("best")); // true
        System.out.println(trie.search("abc")); // false

        System.out.println();
        trie.delete("apple");
        System.out.println(trie.search("apple")); // false
        System.out.println(trie.search("april")); // true
        System.out.println(trie.search("appl")); // false
        trie.delete("apple");
    }
}
