package 真题.面试真题.华为.字符串消减;

public class Solution {
    public static void main(String[] args) {
        String s = "ABBDA";
        solution(s);
    }

    public static void solution(String s) {
        StringBuilder sb = new StringBuilder(s);
//        boolean flag = true;
//        while (true) {
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i - 1) == sb.charAt(i)) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i - 1);
                i -= 2;
            }
        }
//        }
//        System.out.println(sb.toString());
        if (sb.length() == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
