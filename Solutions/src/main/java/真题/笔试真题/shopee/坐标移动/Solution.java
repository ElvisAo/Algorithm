package 真题.笔试真题.shopee.坐标移动;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = new Solution().GetEndPoint("W2D");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     * 假设点P处于坐标轴原点，W表示向上，A表示向左，S表示向下，D表示向右，输入一串指令代表P点的移动轨迹，输出最终P的位置
     * <p>
     * 例如 "2W2D"表示向上移动两个坐标位置，再向右移动两个坐标位置
     * <p>
     * "W2D"表示向上移动一个坐标位置，再向右移动两个坐标位置
     *
     * @param order string字符串
     * @return int整型一维数组
     */
    public int[] GetEndPoint(String order) {
        int i = 0, j = 0;
        int stepln = 1;
        order = order.toUpperCase();
        for (int k = 0; k < order.length(); k++) {
            char c = order.charAt(k);
            if (c == 'W') {
                i += stepln;
                stepln = 1;
            } else if (c == 'A') {
                j -= stepln;
                stepln = 1;
            } else if (c == 'S') {
                i -= stepln;
                stepln = 1;
            } else if (c == 'D') {
                j += stepln;
                stepln = 1;
            } else {
                stepln = 0;
                while (order.charAt(i) >= '0' && order.charAt(k) <= '9') {
                    stepln = stepln * 10 + (order.charAt(k) - '0');
                    k++;
                }
                k--;
            }
        }
        int[] r = new int[]{j, i};
        return r;
    }
}
