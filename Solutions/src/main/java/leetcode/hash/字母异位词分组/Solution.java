package leetcode.hash.字母异位词分组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * {@一旦需要根据特征进行分类，就应该想到使用散列表}
 */
public class Solution {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                LinkedList<String> val = new LinkedList<>();
                val.add(strs[i]);
                map.put(key, val);
            }
        }
        List<List<String>> r = new LinkedList<>();
        for (List<String> list : map.values()) {
            r.add(list);
        }
        return r;
    }
}
