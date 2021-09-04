package leetcode.数学.七进制数;

public class Solution {
    public static void main(String[] args) {

    }

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean is_negative = num < 0;
        if (is_negative) num = -num;
        String r = "";
        while (num > 0) {
            int a = num / 7, b = num % 7;
            r = b + r;
            num = a;
        }
        return is_negative ? "-" + r : r;
    }
}
