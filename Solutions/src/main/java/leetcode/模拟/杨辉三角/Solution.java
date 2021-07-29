package leetcode.模拟.杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> olist = new Solution().generate(5);
        for (List list : olist) System.out.println(list);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> olist = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> ilist = new ArrayList<>();
            ilist.add(1);
            for (int col = 2; col < i; col++) {
                List<Integer> pre = olist.get(i - 2);
                ilist.add(pre.get(col - 2) + pre.get(col - 1));
            }
            if (i != 1)
                ilist.add(1);
            olist.add(ilist);
        }
        return olist;
    }
}
