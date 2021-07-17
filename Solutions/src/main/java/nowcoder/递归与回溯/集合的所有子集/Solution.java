package nowcoder.递归与回溯.集合的所有子集;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int[] s = {1, 2, 3};
        ArrayList<ArrayList<Integer>> r = new Solution().solution_1(s);
        for (ArrayList<Integer> l : r) {
            System.out.println(l);
        }
    }

    public ArrayList<ArrayList<Integer>> solution_1(int[] S) {
        ArrayList<ArrayList<Integer>> olist = new ArrayList<>();
        backtrack(S, new ArrayList<Integer>(), olist, new HashSet<Integer>());
        return olist;
    }

    private void backtrack(int[] s, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> olist, HashSet<Integer> visited) {
        ArrayList<Integer> t = new ArrayList<>(path);
        Collections.sort(t);
        if (!olist.contains(t)) {
            olist.add(t);
        }
        if (path.size() == s.length) return;
        for (int i = 0; i < s.length; i++) {
            if (visited.contains(s[i])) continue;
            path.add(s[i]);
            visited.add(s[i]);
            backtrack(s, path, olist, visited);
            path.remove(path.size() - 1);
            visited.remove(s[i]);
        }
    }
}
