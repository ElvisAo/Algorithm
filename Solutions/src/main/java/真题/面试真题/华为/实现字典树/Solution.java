package 真题.面试真题.华为.实现字典树;

import java.util.LinkedList;

class TrieTree {
    class TrieNode {
        public TrieNode[] subNode;
        public int count;//该节点的子节点个数
        public boolean isWord;//单词标记位

        public TrieNode() {
            this.count = 0;
            this.isWord = false;
            this.subNode = new TrieNode[26];//只包含小写字母a-z
        }
    }

    public TrieNode root;

    public TrieTree() {
        root = new TrieNode();  // 根节点不存储数据
    }

    public boolean search(String word) {
        TrieNode curNode = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';           // 找到第i个字符的索引
            if (curNode.subNode[index] != null) {   // 如果第i个字符在子节点中，就继续向下寻找
                curNode = curNode.subNode[index];
            } else {
                return false;
            }
        }
        return curNode.isWord;      // 如果最后到达的节点是单词，则返回true，否则false
    }

    public void insert(String word) {
        if (search(word)) {     // 如果已经存在该单词，则直接返回
            System.out.println("The word already exists.");
            return;
        }
        TrieNode node = root;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (node.subNode[index] == null) {
                node.subNode[index] = new TrieNode();
            }
            node.count++;
            node = node.subNode[index];
        }
        node.isWord = true;
    }


    public void delete(String word) {
        if (!search(word)) {
            System.out.println("No such word.");
            return;
        }
        TrieNode node = root;
        LinkedList<Integer> indexList = new LinkedList();
        LinkedList<TrieNode> nodeList = new LinkedList();
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            indexList.add(index);
            nodeList.add(node);
            node = node.subNode[index];
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            node = nodeList.pollLast();
            index = indexList.pollLast();
            if (node.subNode[index].subNode == null) {
                if (i != word.length() - 1) {
                    if (node.subNode[index].isWord == true) {//如果前缀节点中有单词标记位，那么不再继续删除
                        return;
                    }
                }
                node.subNode[index] = null;
                node.count--;
            }
            if (i == word.length() - 1) {
                if (node.subNode[index].subNode != null) {
                    node.subNode[index].isWord = false;
                    return;
                }
            }

        }
    }
}


public class Solution {
    public static void main(String[] args) {
        TrieTree myTrieTree = new TrieTree();
        String[] words = {"hello", "face", "hi", "hell", "why"};
        //插入字符串
        for (String word : words)
            myTrieTree.insert(word);

        //插入重复字符串
        myTrieTree.insert("hello");
        //删除字符串
        myTrieTree.delete("hell");
        //重复删除字符串
        myTrieTree.delete("hell");
        myTrieTree.delete("hi");
        //查询字符串，找到为true，未找到为false
        System.out.println(myTrieTree.search("hello"));
        System.out.println(myTrieTree.search("hi"));
        System.out.println(myTrieTree.search("hell"));
    }
}
