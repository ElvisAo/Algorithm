package leetcode.字符串.RepeatedDNASequence;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 187
 */
public class Solution {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(new Solution().findRepeatedDnaSequences(s));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new LinkedList<>();
        int n = s.length();
        if (n <= 10) return list;
        HashSet<String> set = new HashSet<>();
        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i + 10 <= n; i++) {
            String target = s.substring(i, i + 10);
            if (visited.contains(target)) continue;
            if (set.contains(target)) {
                list.add(target);
                visited.add(target);
            }
            set.add(target);
        }
        return list;
    }
}
