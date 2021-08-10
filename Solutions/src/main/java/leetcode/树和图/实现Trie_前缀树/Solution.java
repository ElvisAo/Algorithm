package leetcode.树和图.实现Trie_前缀树;

public class Solution {
    public static void main(String[] args) {

    }

    class Trie {
        private class TrieNode {
            private TrieNode[] children;
            private int childCount;
            private boolean end;

            public TrieNode() {
                childCount = 0;
                children = new TrieNode[26];
            }
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            int n = word.length();
            TrieNode cur = root;
            for (int i = 0; i < n; i++) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
                cur.childCount++;
            }
            cur.end = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            int n = word.length();
            TrieNode cur = root;
            for (int i = 0; i < n; i++) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) return false;
                else cur = cur.children[index];
            }
            return cur.end;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            int n = prefix.length();
            TrieNode cur = root;
            for (int i = 0; i < n; i++) {
                int index = prefix.charAt(i) - 'a';
                if (cur.children[index] == null) return false;
                else cur = cur.children[index];
            }
            return true;
        }
    }
}
