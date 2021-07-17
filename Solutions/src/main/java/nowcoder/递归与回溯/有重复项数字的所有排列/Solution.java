package nowcoder.递归与回溯.有重复项数字的所有排列;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0) return olist;
        backtrack(num, new ArrayList<Integer>());
        return olist;
    }

    ArrayList<ArrayList<Integer>> olist = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();

    private void backtrack(int[] num, ArrayList<Integer> path) {
        if (path.size() == num.length) {
            if (!olist.contains(path))
                olist.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!visited.contains(i)) {
                path.add(num[i]);
                visited.add(i);
                backtrack(num, path);
                path.remove(path.size() - 1);
                visited.remove(i);
            }
        }
    }
}
