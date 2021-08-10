package 真题.面试真题.华为.字符串单一映射;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        String s = "apple", t = "cdqfe";
        System.out.println(new Solution().solution(s, t));
    }

    public boolean solution(String s, String t) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        for (char c : s.toCharArray()) set1.add(c);
        for (char c : t.toCharArray()) set2.add(c);
        return set1.size() == set2.size();
    }
}
