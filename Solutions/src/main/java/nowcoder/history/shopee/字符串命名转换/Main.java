package nowcoder.history.shopee.字符串命名转换;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int start = 0;//定位每个单词的首字母
        StringBuilder ans0 = new StringBuilder();//纯大写
        StringBuilder ans1 = new StringBuilder();//纯小写 + _
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'A' && c <= 'Z') || c == '-' || c == '_') {//截断
                ans0.append(Character.toUpperCase(s.charAt(start))).append(s, start + 1, i);
                ans1.append(Character.toLowerCase(s.charAt(start))).append(s, start + 1, i).append('_');
                start = i;//索引更新
                if (c == '-' || c == '_')//跳过，无操作
                    start++;
            }
        }
        String s1 = ans0.append(Character.toUpperCase(s.charAt(start))).append(s, start + 1, s.length()).toString();
        String s2 = ans1.append(Character.toLowerCase(s.charAt(start))).append(s, start + 1, s.length()).toString();
        System.out.print(s1 + " ");//首字母大写
        System.out.print(s1.substring(0, 1).toLowerCase() + s1.substring(1) + " ");//首字母小写
        System.out.print(s2 + " ");//_
        System.out.println(s2.replaceAll("_", "-"));//-
    }
}
