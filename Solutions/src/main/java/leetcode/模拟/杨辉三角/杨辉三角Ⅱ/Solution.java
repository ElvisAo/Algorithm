package leetcode.模拟.杨辉三角.杨辉三角Ⅱ;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution_1(1));
    }

    public List<Integer> solution_1(int rowIndex) {
        rowIndex += 1;
        ArrayList<Integer> pre = new ArrayList<>();
        ArrayList<Integer> cur;
        pre.add(1);
        for (int row = 2; row <= rowIndex; row++) {
            cur = new ArrayList<>();
            cur.add(1);
            for (int col = 2; col < row; col++) {
                cur.add(pre.get(col - 2) + pre.get(col - 1));
            }
            cur.add(1);
            pre = cur;
        }
        return pre;
    }

    /**
     * {@杨辉三角第n行的第i个元素为：C(n,i)}
     * @param rowIndex
     * @return
     */
    public List<Integer> solution_2(int rowIndex) {
        rowIndex += 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < rowIndex; i++) {
            list.add((int) ((long) list.get(i - 1) * (rowIndex - i) / i));
        }
        return list;
    }
}
