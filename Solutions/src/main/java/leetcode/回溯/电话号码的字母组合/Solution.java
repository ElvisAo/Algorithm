package leetcode.回溯.电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("1234"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> r = new ArrayList<>();
        if (digits == null || digits.length() == 0) return r;
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();
        char n = '2', alpha = 'a';
        while (alpha <= 'z') {
            ArrayList<Character> ilist = new ArrayList<>();
            ilist.add(alpha++);
            ilist.add(alpha++);
            ilist.add(alpha++);
            if (n == '7' || n == '9') {
                ilist.add(alpha++);
            }
            map.put(n++, ilist);
        }
        backtrack(map, 0, new StringBuilder(), digits, r);
        return r;
    }

    private void backtrack(HashMap<Character, ArrayList<Character>> map, int index, StringBuilder path, String digits, List<String> r) {
        if (index == digits.length()) {
            r.add(path.toString());
            return;
        }
        List<Character> list = map.get(digits.charAt(index));
        int n = list.size();
        for (int i = 0; i < n; i++) {
            path.append(list.get(i));
            backtrack(map, index + 1, path, digits, r);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
