package 真题.笔试真题.shopee.杨辉三角;

import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getValue(3, 2));
    }

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     * @param rowIndex    int整型 第几行
     * @param columnIndex int整型 第几列
     * @return int整型
     */
    public int getValue(int rowIndex, int columnIndex) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < rowIndex; i++) {
            list.add(list.get(i - 1) * (rowIndex - i) / i);
        }
        return list.get(columnIndex - 1);
    }
}
