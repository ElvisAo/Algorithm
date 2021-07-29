package nowcoder.字符串.大数计算.大数乘法;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        //输入2个数字
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String result = muilt(s1, s2);
        System.out.println(result);
    }

    private static String muilt(String s1, String s2) {
        String result = "";
        //把s2拆分成一个一个的
        for (int i = 0; i < s2.length(); i++) {
            //计算s2中单个数字和s1的乘积
            String temp = per(s1, s2.charAt(i));
            //把每次计算的乘积想加（因为每次的乘积位置不一样，所以先要补0）
            result = add(result, add_0(temp, s2.length() - 1 - i));
        }

        return result;
    }

    //单个数字和s1的积
    private static String per(String s1, char c) {
        int n = c - '0';
        String result = "";
        int w = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            //计算当前位置的积
            int m = (s1.charAt(i) - '0') * n + w;
            // m/10就是进位值
            w = m / 10;
            //  m%10就是当前位置的值
            result = m % 10 + result;
        }
        //对第一位进行判断
        if (w != 0) result = w + result;
        return result;
    }

    //大数和的方法
    private static String add(String s1, String s2) {
        //保证s1小于等于s2的长度
        if (s1.length() > s2.length()) {
            String t = s1;
            s1 = s2;
            s2 = t;
        }
        int cha = s2.length() - s1.length();
        for (int i = 0; i < cha; i++) {
            s1 = '0' + s1;
        }
        String result = "";
        int w = 0;
        for (int i = s2.length() - 1; i >= 0; i--) {
            int c = s2.charAt(i) + s1.charAt(i) - 96 + w;
            w = c / 10;
            result = (c % 10) + result;
        }
        if (w == 1) result = 1 + result;
        return result;
    }

    private static String add_0(String temp, int i) {
        for (int j = 0; j < i; j++) {
            temp = temp + '0';
        }
        return temp;
    }
}
