package nowcoder.字符串.大数计算.大数加法;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve(String s, String t) {
        // write code here
        StringBuilder res = new StringBuilder();
        int tmp;
        int jinwei = 0;
        int i = s.length() - 1, j = t.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            tmp = s.charAt(i) - '0' + t.charAt(j) - '0' + jinwei;
            jinwei = tmp / 10;
            tmp = tmp % 10;
            res.insert(0, tmp);
        }
        for (; i >= 0; i--) {
            tmp = s.charAt(i) - '0' + jinwei;
            jinwei = tmp / 10;
            tmp = tmp % 10;
            res.insert(0, tmp);
        }
        for (; j >= 0; j--) {
            tmp = t.charAt(j) - '0' + jinwei;
            jinwei = tmp / 10;
            tmp = tmp % 10;
            res.insert(0, tmp);
        }
        if (jinwei > 0) res.insert(0, jinwei);
        return res.toString();
    }
}
