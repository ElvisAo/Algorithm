package leetcode.数学.Excel表列名称;

/**
 * leetcode 168
 */
public class Solution {
    public static void main(String[] args) {
        int n = 52;    // ZY
        System.out.println(new Solution().convertToTitle(n));
    }

    public String convertToTitle(int columnNumber) {
        StringBuilder r = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--; // 每次-1，就转换为了0~25
            r = r.append(numberToAlphabetic(columnNumber % 26));
            columnNumber /= 26;
        }
        return r.reverse().toString();
    }

    /**
     * 将1~26的数字转换为A~Z的字符
     * 如果n是0，return Z
     * 如果n是1，return A
     * 。。。
     * 如果是25，return Y
     *
     * @param n 0~25
     * @return
     */
    private char numberToAlphabetic(int n) {
        return (char) ('A' + n);
    }
}
