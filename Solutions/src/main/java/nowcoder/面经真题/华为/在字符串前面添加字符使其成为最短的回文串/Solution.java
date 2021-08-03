package nowcoder.面经真题.华为.在字符串前面添加字符使其成为最短的回文串;

public class Solution {
    public static void main(String[] args) {
        String s = "aaceebb";
        System.out.println(new Solution().solution(s));
    }

    public String solution(String s) {
        String t = new StringBuilder(s).reverse().toString();
        int n = s.length();
        String r = "";
        for (int i = 0; i < n; i++) {
            String post_new = t.substring(i);    // 必须是从新串的0开始往后
            String pre_orig = s.substring(0, n - i);
            if (post_new.equals(pre_orig)) {
                System.out.println(t.substring(0, i));
                r = new StringBuilder(t.substring(0, i)).append(s).toString();
                break;  // 找到之后一定要break，不然可能变成更长的
            }
        }
        return r;
    }
}
