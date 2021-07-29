package nowcoder.字符串.大数计算.大数减法;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String result = sub(s1, s2);
        System.out.println(result);
    }

    private static String sub(String s1, String s2) {
        String fuhao = "";
        int l1 = s1.length();
        int l2 = s2.length();
        //判断，如果s1小于s2那么 符号就是  -     然后，s1和s2交换位置，保证s1是大的
        if ((l1 == l2 && s1.compareTo(s2) < 0) || l1 < l2) {
            fuhao = "-";
            String t = s1;
            s1 = s2;
            s2 = t;
        }
        for (int i = 0; i < Math.abs(l1 - l2); i++) {
            s2 = '0' + s2;  //补0处理，使长度一致
        }
        String result = "";
        int w = 0;
        for (int i = s1.length() - 1; i >= 0; i--) {
            //计算每一个位置的差，在加上借位w的值
            int c = s1.charAt(i) - s2.charAt(i) + w;
            //如果c小于0，说明需要借位，c+=10，然后w该为-1，否则，借位w=0
            if (c < 0) {
                c += 10;
                w = -1;
            } else {
                w = 0;
            }
            result = c + result;    // 把当前位的数字放入result里
        }
        return fuhao + result;
    }
}