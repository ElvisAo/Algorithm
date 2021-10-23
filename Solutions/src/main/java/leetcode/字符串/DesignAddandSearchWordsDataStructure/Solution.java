package leetcode.字符串.DesignAddandSearchWordsDataStructure;

/**
 * leetocde 211
 */
public class Solution {
    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("bad");
        dic.addWord("dad");
        dic.addWord("mad");
        dic.addWord("pad");
        System.out.println(dic.search("bad"));
        System.out.println(dic.search("had"));
        System.out.println(dic.search(".ad"));
    }

    static class WordDictionary {
        static class Node {
            Node[] subnodes;
            boolean isEnd;

            public Node() {
                subnodes = new Node[26];
                isEnd = false;
            }
        }

        static class Trie {
            Node root;

            public Trie() {
                root = new Node();
            }

            public void addWord(String word) {
                char[] charArray = word.toCharArray();
                int index;
                Node cur = root;
                for (int i = 0; i < charArray.length; i++) {
                    index = charArray[i] - 'a';
                    if (cur.subnodes[index] == null) {
                        cur.subnodes[index] = new Node();
                    }
                    cur = cur.subnodes[index];
                }
                cur.isEnd = true;
            }

            public boolean search(String word) {
                return searchHelper(word.toCharArray(), 0, root);
            }

            /**
             * @param charArray 单词的char数组
             * @param start     charArray中要匹配的单词的索引
             * @param root
             * @return
             */
            private boolean searchHelper(char[] charArray, int start, Node root) {
                if (start == charArray.length) return root.isEnd;
                if (charArray[start] == '.') {
                    for (int i = 0; i < 26; i++) {
                        if (root.subnodes[i] != null && searchHelper(charArray, start + 1, root.subnodes[i])) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    int index = charArray[start] - 'a';     // 字母在trie中的索引
                    if (root.subnodes[index] != null) {
                        return searchHelper(charArray, start + 1, root.subnodes[index]);
                    } else return false;
                }
            }
        }

        Trie diction;

        public WordDictionary() {
            diction = new Trie();
        }

        public void addWord(String word) {
            diction.addWord(word);
        }

        public boolean search(String word) {
            return diction.search(word);
        }
    }
}
