package leetcode.字符串相乘;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("12", "34"));
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2) || num1 == null || num2 == null) return "0";
        int[] res = new int[num1.length() + num2.length()];
        int rail = -1;
        // 必须要从个位开始
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int m = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int pl = i + j, ph = i + j + 1;
                m += res[pl] * 10 + res[ph];
                res[ph] = m % 10;
                res[pl] = m / 10;
                if (rail == -1) rail = ph;
            }
        }
        int j = 0;
        while (res[j] == 0) j++;
        String s = "";
        for (int k = j; k <= rail; k++) {
            s += res[k];
        }
        return s;
    }
}
