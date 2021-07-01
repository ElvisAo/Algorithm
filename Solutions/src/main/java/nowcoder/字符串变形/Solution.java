/**
 * @description: TODO
 * @author Everett
 * @date 6/30/2021 5:50 PM
 */
package nowcoder.字符串变形;

public class Solution {
    public static void main(String[] args) {
//        System.out.println('A' - 'a');
        System.out.println(new Solution().trans("  Hello world  ", 15));
    }

    public String trans(String s, int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') sb.append(' ');
            else {
                int j = i - 1;
                while (j >= 0 && s.charAt(j) != ' ') j--;
                for (int k = j + 1; k <= i; k++) {
                    char c = s.charAt(k);
                    if (c >= 'A' && c <= 'Z') sb.append((char) (c + 32));
                    else sb.append((char) (c - 32));
                }
                i = j + 1;
            }
        }
        return sb.toString();
    }
}
