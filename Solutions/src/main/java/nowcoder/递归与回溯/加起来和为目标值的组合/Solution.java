/**
 * @author Everett
 * @date 6/29/2021 2:56 PM
 */
package nowcoder.递归与回溯.加起来和为目标值的组合;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 和{@link leetcode.回溯.组合总和}一样
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 2, 3, 4, 5};
        ArrayList<ArrayList<Integer>> olist = new Solution().combinationSum2(ints, 7);
        for (ArrayList<Integer> ilist : olist) {
            System.out.println(ilist);
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> olist = new ArrayList<>();
        if (num == null || num.length == 0) return olist;
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(num);
        backtrack(num, 0, target, path, olist);
        return olist;
    }

    private void backtrack(int[] num, int k, int rema, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> olist) {
        if (rema == 0) {
            olist.add(new ArrayList<>(path));
            return;
        }
        if (k > num.length) return;

        for (int i = k; i < num.length; i++) {
            if (i > k && num[i] == num[i - 1]) continue;    // 保证不重复，对于类似1，2，2求5这种，多个2在下一层k+1保证
            rema -= num[i];
            if (rema < 0) return;
            path.add(num[i]);
            backtrack(num, i + 1, rema, path, olist);
            path.remove(path.size() - 1);
            rema += num[i];
        }
    }
}
