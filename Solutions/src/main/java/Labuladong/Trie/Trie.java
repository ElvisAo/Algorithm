package Labuladong.Trie;

/**
 * {@字典树用途：在所有单词中统计以某个字符串为前缀的单词的个数}
 */
public class Trie {
    class TrieNode {
        TrieNode[] subNodes;
        boolean isEnd;
        int count;

        public TrieNode() {
            subNodes = new TrieNode[26];
            isEnd = false;
            count = 0;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public boolean search(String s) {
        TrieNode cur = root;
        int index;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            if (cur.subNodes[index] != null) {
                cur = cur.subNodes[index];
            } else {
                return false;
            }
        }
        return cur.isEnd;
    }

    public void insert(String s) {
        if (search(s)) return;
        TrieNode cur = root;
        int index;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i) - 'a';
            if (cur.subNodes[index] == null) {
                cur.subNodes[index] = new TrieNode();
            }
            cur.count++;
            cur = cur.subNodes[index];
        }
        cur.isEnd = true;
    }
}
