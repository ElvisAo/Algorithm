package leetcode.数学.二进制求和;

/**
 * leetcode 67
 */
public class Solution {
    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(new Solution().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        int ln1 = a.length(), ln2 = b.length();
        StringBuilder r = new StringBuilder();
        int carry = 0, i = ln1 - 1, j = ln2 - 1;
        for (; i >= 0 || j >= 0; i--, j--) {
            int num1 = i >= 0 ? aArray[i] - '0' : 0, num2 = j >= 0 ? bArray[j] - '0' : 0;
            r.append((num1 + num2 + carry) % 2);
            carry = (num1 + num2 + carry) / 2;
        }
        if (carry != 0) r.append(carry);
        return r.reverse().toString();
    }
}
