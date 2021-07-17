package nowcoder.字符串.大数乘法;

/**
 * TODO 待完成
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public String solution_1(String s, String t) {
        int ln1 = s.length(), ln2 = t.length();
        for (int i = ln1 - 1; i >= 0; i--) {
            int vals = s.charAt(i) - '0';
            int jinwei = 0;
            for (int j = ln2 - 1; j >= 0; j--) {
                int valt = t.charAt(j) - '0';

            }
        }
        return null;
    }
}
