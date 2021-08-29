package leetcode.字符串.通过删除字母匹配到字典里最长单词;

import java.util.List;

/**
 * 据说是{@归并有序数组}的变形题
 */
public class Solution {
    /**
     * {@先排序再用双指针}
     *
     * @param s
     * @param dictionary
     * @return
     */
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((x, y) -> {
            if (x.length() == y.length()) return x.compareTo(y);
            else return y.length() - x.length();
        });
        int n = dictionary.size(), j, k;
        String word;
        for (int i = 0; i < n; i++) {
            word = dictionary.get(i);
            j = k = 0;
            while (j < s.length() && k < word.length()) {
                if (s.charAt(j) != word.charAt(k)) j++;
                else {
                    j++;
                    k++;
                }
            }
            if (k == word.length()) return word;
        }
        return "";
    }
}
